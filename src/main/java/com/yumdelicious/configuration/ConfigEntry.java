package yum.configuration;

public class ConfigEntry {
    private final String configPrefix;
    
    public ConfigEntry(String configPrefix) {
        this.configPrefix = configPrefix;
    }
    
    public String getEnabledKey() {
        return configPrefix + "_enabled";
    }
    
    public String getEffectKey() {
        return configPrefix + "_effect";
    }
    
    public String getDurationKey() {
        return configPrefix + "_duration";
    }
    
    public String getAmplifierKey() {
        return configPrefix + "_amplifier";
    }
    
    public String getMultiEffectsKey() {
        return configPrefix + "_multi_effects";
    }
    
    public String getConfigKey() {
        return configPrefix;
    }
}