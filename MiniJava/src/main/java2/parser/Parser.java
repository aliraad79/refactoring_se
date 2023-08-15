package parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Log.Log;
import codeGenerator.CodeGen;
import errorHandler.ErrorHandler;
import parser.action.Action;
import scanner.lexProcessor;
import scanner.token.Token;

public class SyntaxFacade {

    private ArrayList<ProductionRule> productionRules;
    private Stack<Integer> analysisStack;
    private SyntaxTable syntaxTable;
    private LexProcessor lexProcessor;
    private CodeGen codeGenerator;

    public SyntaxFacade() {
        initialize();
    }

    private void initialize() {
        analysisStack = new Stack<>();
        analysisStack.push(0);
        try {
            syntaxTable = new SyntaxTable(Files.readAllLines(Path.of("src/main/resources/syntaxTable")).get(0));
        } catch (Exception e) {
            Logger.error(e.getMessage());
        }
        productionRules = new ArrayList<>();
        try {
            for (String strRule : Files.readAllLines(Path.of("src/main/resources/ProductionRules"))) {
                productionRules.add(new ProductionRule(strRule));
            }
        } catch (IOException e) {
            Logger.error(e.getMessage());
        }
        codeGenerator = new CodeGen();
    }

    public void parse(java.util.Scanner inputScanner) {
        lexProcessor = new LexProcessor(inputScanner);
        TokenEntity currentToken = lexProcessor.fetchNextToken();
        boolean isParsingComplete = false;
        ActionEntity currentAction;
        while (!isParsingComplete) {
            try {
                Logger.log("Token: " + currentToken + "\t" + analysisStack.peek());
                currentAction = syntaxTable.retrieveAction(analysisStack.peek(), currentToken);
                Logger.log(currentAction.toString());

                switch (currentAction.operationType) {
                    case SHIFT:
                        analysisStack.push(currentAction.value);
                        currentToken = lexProcessor.fetchNextToken();
                        break;
                    case REDUCE:
                        ProductionRule rule = productionRules.get(currentAction.value);
                        for (int i = 0; i < rule.getRightHandSize(); i++) {
                            analysisStack.pop();
                        }
                        Logger.log("State: " + analysisStack.peek() + "\t" + rule.getLeftHandSide());
                        analysisStack.push(syntaxTable.retrieveGoto(analysisStack.peek(), rule.getLeftHandSide()));
                        Logger.log("New State: " + analysisStack.peek());
                        try {
                            codeGenerator.generateSemantic(rule.getSemanticFunction(), currentToken);
                        } catch (Exception e) {
                            Logger.error("Code Generation Issue");
                        }
                        break;
                    case ACCEPT:
                        isParsingComplete = true;
                        break;
                }
                Logger.log("");
            } catch (Exception ignored) {
                Logger.error(ignored.getMessage());
            }
        }
        if (!ErrorManager.hasErrors()) codeGenerator.displayOutput();
    }
}
