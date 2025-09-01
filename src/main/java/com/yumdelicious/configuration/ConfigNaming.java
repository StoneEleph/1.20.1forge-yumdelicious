package yum.configuration;

public enum ConfigNaming {
    BUBBLE_TEA("bubble_tea"),
    CHIPS("chips"),
    CHOCOLATE("chocolate");
    
    private final String configKey;
    
    ConfigNaming(String configKey) {
        this.configKey = configKey;
    }
    
    public String getConfigKey() {
        return configKey;
    }
}