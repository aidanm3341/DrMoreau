package util;

public class Config {
    private static Config instance;
    public static Config getInstance(){
        if(instance == null)
            instance = new Config();
        return instance;
    }

    private boolean debugMode = false;

    public boolean isDebugMode() {
        return debugMode;
    }
}
