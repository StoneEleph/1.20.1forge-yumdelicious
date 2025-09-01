package yum.configuration;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import yum.configuration.YumitemeffectstomlConfiguration;
import yum.configuration.ItemConfigMapping;
import yum.procedures.EffectData;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConfigHelper {
    private static final Logger LOGGER = LogManager.getLogger(ConfigHelper.class);
    private static final Map<String, ForgeConfigSpec.ConfigValue<Boolean>> ENABLED_CACHE = new HashMap<String, ForgeConfigSpec.ConfigValue<Boolean>>();
    private static final Map<String, ForgeConfigSpec.ConfigValue<String>> EFFECT_CACHE = new HashMap<String, ForgeConfigSpec.ConfigValue<String>>();
    private static final Map<String, ForgeConfigSpec.ConfigValue<Integer>> DURATION_CACHE = new HashMap<String, ForgeConfigSpec.ConfigValue<Integer>>();
    private static final Map<String, ForgeConfigSpec.ConfigValue<Integer>> AMPLIFIER_CACHE = new HashMap<String, ForgeConfigSpec.ConfigValue<Integer>>();
    private static final Map<String, ForgeConfigSpec.ConfigValue<String>> MULTI_EFFECTS_CACHE = new HashMap<String, ForgeConfigSpec.ConfigValue<String>>();
    private static final Gson GSON = new Gson();
    
    public static MobEffect getEffectFromConfig(String effectName) {
        if (effectName == null || effectName.isEmpty()) {
            return null;
        }
        
        ResourceLocation effectLocation = ResourceLocation.tryParse(effectName);
        if (effectLocation != null) {
            return ForgeRegistries.MOB_EFFECTS.getValue(effectLocation);
        }
        
        // 默认效果映射
        switch (effectName.toLowerCase()) {
            case "minecraft:regeneration":
            case "regeneration":
                return MobEffects.REGENERATION;
            case "minecraft:strength":
            case "strength":
                return MobEffects.DAMAGE_BOOST;
            case "minecraft:speed":
            case "speed":
                return MobEffects.MOVEMENT_SPEED;
            case "minecraft:jump_boost":
            case "jump_boost":
                return MobEffects.JUMP;
            case "minecraft:resistance":
            case "resistance":
                return MobEffects.DAMAGE_RESISTANCE;
            case "minecraft:fire_resistance":
            case "fire_resistance":
                return MobEffects.FIRE_RESISTANCE;
            case "minecraft:haste":
            case "haste":
                return MobEffects.DIG_SPEED;
            case "minecraft:instant_health":
            case "instant_health":
            case "minecraft:instant health":
            case "instant health":
                return MobEffects.HEAL;
            case "minecraft:absorption":
            case "absorption":
                return MobEffects.ABSORPTION;
            case "minecraft:luck":
            case "luck":
                return MobEffects.LUCK;
            default:
                return null;
        }
    }
    
    public static boolean isConfigEnabled(String configKey) {
        try {
            ForgeConfigSpec.ConfigValue<Boolean> enabledConfig = ENABLED_CACHE.computeIfAbsent(configKey, key -> {
                try {
                    java.lang.reflect.Field enabledField = YumitemeffectstomlConfiguration.class.getField(key + "_enabled");
                    Object fieldValue = enabledField.get(null);
                    if (fieldValue instanceof ForgeConfigSpec.ConfigValue) {
                        @SuppressWarnings("unchecked")
                        ForgeConfigSpec.ConfigValue<Boolean> configValue = (ForgeConfigSpec.ConfigValue<Boolean>) fieldValue;
                        return configValue;
                    }
                    return null;
                } catch (Exception e) {
                    LOGGER.warn("Failed to load enabled config for: " + key, e);
                    return null;
                }
            });
            return enabledConfig != null ? enabledConfig.get() : false;
        } catch (Exception e) {
            LOGGER.error("Error checking config enabled for: " + configKey, e);
            return false;
        }
    }
    
    public static List<String> getConfigEffects(String configKey) {
        String effects = "";
        try {
            ForgeConfigSpec.ConfigValue<String> effectConfig = EFFECT_CACHE.computeIfAbsent(configKey, key -> {
                try {
                    java.lang.reflect.Field effectField = YumitemeffectstomlConfiguration.class.getField(key + "_effect");
                    Object fieldValue = effectField.get(null);
                    if (fieldValue instanceof ForgeConfigSpec.ConfigValue) {
                        @SuppressWarnings("unchecked")
                        ForgeConfigSpec.ConfigValue<String> configValue = (ForgeConfigSpec.ConfigValue<String>) fieldValue;
                        return configValue;
                    }
                    return null;
                } catch (Exception e) {
                    LOGGER.warn("Failed to load effect config for: " + key, e);
                    return null;
                }
            });
            effects = effectConfig != null ? effectConfig.get() : "";
        } catch (Exception e) {
            LOGGER.error("Error getting effects for: " + configKey, e);
            effects = "";
        }
        return Arrays.stream(effects.split(","))
            .map(String::trim)
            .filter(effect -> !effect.isEmpty())
            .collect(Collectors.toList());
    }
    
    public static List<Integer> getConfigDurations(String configKey) {
        String durations = "";
        try {
            ForgeConfigSpec.ConfigValue<Integer> durationConfig = DURATION_CACHE.computeIfAbsent(configKey, key -> {
                try {
                    java.lang.reflect.Field durationField = YumitemeffectstomlConfiguration.class.getField(key + "_duration");
                    Object fieldValue = durationField.get(null);
                    if (fieldValue instanceof ForgeConfigSpec.ConfigValue) {
                        @SuppressWarnings("unchecked")
                        ForgeConfigSpec.ConfigValue<Integer> configValue = (ForgeConfigSpec.ConfigValue<Integer>) fieldValue;
                        return configValue;
                    }
                    return null;
                } catch (Exception e) {
                    LOGGER.warn("Failed to load duration config for: " + key, e);
                    return null;
                }
            });
            durations = durationConfig != null ? String.valueOf(durationConfig.get()) : "0";
        } catch (Exception e) {
            LOGGER.error("Error getting durations for: " + configKey, e);
            durations = "0";
        }
        return Arrays.stream(durations.split(","))
            .map(String::trim)
            .filter(duration -> !duration.isEmpty())
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
    
    public static List<Integer> getConfigAmplifiers(String configKey) {
        String amplifiers = "";
        try {
            ForgeConfigSpec.ConfigValue<Integer> amplifierConfig = AMPLIFIER_CACHE.computeIfAbsent(configKey, key -> {
                try {
                    java.lang.reflect.Field amplifierField = YumitemeffectstomlConfiguration.class.getField(key + "_amplifier");
                    Object fieldValue = amplifierField.get(null);
                    if (fieldValue instanceof ForgeConfigSpec.ConfigValue) {
                        @SuppressWarnings("unchecked")
                        ForgeConfigSpec.ConfigValue<Integer> configValue = (ForgeConfigSpec.ConfigValue<Integer>) fieldValue;
                        return configValue;
                    }
                    return null;
                } catch (Exception e) {
                    LOGGER.warn("Failed to load amplifier config for: " + key, e);
                    return null;
                }
            });
            amplifiers = amplifierConfig != null ? String.valueOf(amplifierConfig.get()) : "0";
        } catch (Exception e) {
            LOGGER.error("Error getting amplifiers for: " + configKey, e);
            amplifiers = "0";
        }
        return Arrays.stream(amplifiers.split(","))
            .map(String::trim)
            .filter(amplifier -> !amplifier.isEmpty())
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
    

    
    public static List<EffectData> getConfigEffectsWithFallback(String configKey) {
        LOGGER.info("Getting config effects for: " + configKey);
        // 首先尝试获取多效果配置
        List<EffectData> multiEffects = MultiEffectConfig.getMultiEffects(configKey);
        LOGGER.info("Multi effects for " + configKey + ": " + multiEffects.size() + " effects found");
        if (!multiEffects.isEmpty()) {
            return multiEffects;
        }
        
        // 如果没有多效果配置，使用传统的单个效果配置
        List<String> effectNames = getConfigEffects(configKey);
        List<Integer> durations = getConfigDurations(configKey);
        List<Integer> amplifiers = getConfigAmplifiers(configKey);
        
        List<EffectData> result = new ArrayList<EffectData>();
        for (int i = 0; i < effectNames.size(); i++) {
            String effectName = effectNames.get(i);
            int duration = i < durations.size() ? durations.get(i) : 0;
            int amplifier = i < amplifiers.size() ? amplifiers.get(i) : 0;
            
            MobEffect effect = getEffectFromConfig(effectName);
            if (effect != null) {
                result.add(new EffectData(effect, duration, amplifier));
            }
        }
        
        return result;
    }
}