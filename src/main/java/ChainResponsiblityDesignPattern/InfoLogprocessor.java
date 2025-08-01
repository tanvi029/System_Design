package ChainResponsiblityDesignPattern;

public class InfoLogprocessor extends LogProcessor{

    InfoLogprocessor(LogProcessor loggerProcessor) {
        super(loggerProcessor);
    }

    public void log(int logLevel, String message) {
        if(logLevel == INFO) {
            System.out.println("INFO: "+message );
        } else {
            super.log(logLevel, message);
        }
    }
}
