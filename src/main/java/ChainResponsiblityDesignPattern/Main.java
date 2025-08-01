package ChainResponsiblityDesignPattern;

public class Main {
    public static void main(String []args) {
       // LogProcessor logObject = new LogProcessor(null);

        LogProcessor logObject = new InfoLogprocessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logObject.log(LogProcessor.INFO, "just for info");
        logObject.log(LogProcessor.ERROR, "exception happens");
        logObject.log(LogProcessor.DEBUG, "need to debug this");
    }
}
