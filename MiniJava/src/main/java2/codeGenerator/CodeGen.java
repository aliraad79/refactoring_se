package facade;

import scanner.token.Token;
import codeGenerator.CodeGenerator;

public class CodeGeneratorFacade {

    private CodeGenerator codeGenerator;

    public CodeGeneratorFacade() {
        this.codeGenerator = new CodeGenerator();
    }

    public void generateCode(int function, Token token) {
        codeGenerator.semanticFunction(function, token);
    }

    public void printGeneratedCode() {
        codeGenerator.printMemory();
    }

}
