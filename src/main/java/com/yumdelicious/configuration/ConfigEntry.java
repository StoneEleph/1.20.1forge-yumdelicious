package yum.configuration;

public class ConfigEntry {
    private final String configPrefix;
    
    public ConfigEntry(String configPrefix) {
        this.configPrefix = configPrefix;
    }
    
    public String getEnabledKey() {
        return configPrefix + "enabled";
    }
    
    public String getEffectKey() {
        return configPrefix + "effect";
    }
    
    public String getDurationKey() {
        return configPrefix + "duration";
    }
    
    public String getAmplifierKey() {
        return configPrefix + "amplifier";
    }
    
    public String getMultiEffectsKey() {
        return configPrefix + "multi_effects";
    }
    
    public String getConfigKey() {
        return configPrefix;
    }
}