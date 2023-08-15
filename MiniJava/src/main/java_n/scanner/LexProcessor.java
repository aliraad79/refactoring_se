package lexProcessing;

import lexProcessing.token.TokenModel;

public class LexProcessor {
    private LexAnalyzer analyzerInstance;

    public LexProcessor() {}

    public LexAnalyzer retrieveAnalyzer() {
        return analyzerInstance;
    }

    public void initializeAnalyzer(java.util.Scanner inputScanner) {
        this.analyzerInstance = new LexAnalyzer(inputScanner);
    }

    public TokenModel acquireNextToken() {
        return retrieveAnalyzer().extractNextToken();
    }
}
