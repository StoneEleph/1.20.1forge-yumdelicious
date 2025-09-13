package yum.configuration;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yum.configuration.ConfigHelper;
import yum.procedures.EffectData;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class MultiEffectConfig {
    private static final Logger LOGGER = LogManager.getLogger(MultiEffectConfig.class);
    private static final Gson GSON = new Gson();
    private static final Type EFFECT_LIST_TYPE = new TypeToken<List<EffectData>>() {}.getType();
    
    public static final Map<String, ForgeConfigSpec.ConfigValue<String>> MULTI_EFFECT_CACHE = new HashMap<String, ForgeConfigSpec.ConfigValue<String>>();
    

    
    /**
     * 获取物品的多效果配置
     */
    public static List<EffectData> getMultiEffects(String configKey) {
        try {
            ForgeConfigSpec.ConfigValue<String> multiEffectConfig = MULTI_EFFECT_CACHE.computeIfAbsent(configKey, key -> {
                try {
                    java.lang.reflect.Field multiEffectField = YumitemeffectstomlConfiguration.class.getField(key + "_multi_effects");
                    Object fieldValue = multiEffectField.get(null);
                    if (fieldValue instanceof ForgeConfigSpec.ConfigValue) {
                        @SuppressWarnings("unchecked")
                        ForgeConfigSpec.ConfigValue<String> configValue = (ForgeConfigSpec.ConfigValue<String>) fieldValue;
                        return configValue;
                    }
                    return null;
                } catch (Exception e) {
                    // 如果找不到多效果配置字段，返回空配置
                    return null;
                }
            });
            
            // 检查配置是否已加载 - 使用安全的方式获取配置值
            if (multiEffectConfig != null) {
                try {
                    // 检查配置是否已加载 - 使用安全的方式获取配置值
                    String multiEffectsJson = multiEffectConfig.get();
                    if (multiEffectsJson != null && !multiEffectsJson.trim().isEmpty()) {
                        // 先解析为Map列表，然后转换为EffectData对象
                        List<Map<String, Object>> effectMaps = GSON.fromJson(multiEffectsJson, new TypeToken<List<Map<String, Object>>>(){}.getType());
                        List<EffectData> effectDataList = new ArrayList<EffectData>();
                        
                        for (Map<String, Object> effectMap : effectMaps) {
                            String effectName = (String) effectMap.get("effect");
                            int duration = ((Number) effectMap.getOrDefault("duration", 0)).intValue();
                            int amplifier = ((Number) effectMap.getOrDefault("amplifier", 0)).intValue();
                            
                            MobEffect effect = ConfigHelper.getEffectFromConfig(effectName);
                            if (effect != null) {
                                effectDataList.add(new EffectData(effect, duration, amplifier));
                            }
                        }
                        
                        return effectDataList;
                    }
                } catch (IllegalStateException e) {
                    LOGGER.warn("Config not loaded yet for: " + configKey + ", using empty effects");
                    return new ArrayList<EffectData>();
                }
            }
        } catch (Exception e) {
            LOGGER.warn("Failed to load multi-effect config for: " + configKey, e);
        }
        
        return getLegacyEffects(configKey);
    }
    
    private static List<EffectData> getLegacyEffects(String configKey) {
        List<EffectData> effects = new ArrayList<EffectData>();
        
        // 检查是否启用
        if (ConfigHelper.isConfigEnabled(configKey)) {
            List<String> effectNames = ConfigHelper.getConfigEffects(configKey);
            List<Integer> durations = ConfigHelper.getConfigDurations(configKey);
            List<Integer> amplifiers = ConfigHelper.getConfigAmplifiers(configKey);
            
            // 确保所有列表长度一致
            int maxEffects = Math.min(effectNames.size(), Math.min(durations.size(), amplifiers.size()));
            
            for (int i = 0; i < maxEffects; i++) {
                String effectName = effectNames.get(i);
                int duration = durations.get(i);
                int amplifier = amplifiers.get(i);
                
                MobEffect effect = ConfigHelper.getEffectFromConfig(effectName);
                if (effect != null) {
                    effects.add(new EffectData(effect, duration, amplifier));
                }
            }
        }
        
        return effects;
    }
    
    /**
     * 应用多效果配置
     */
    public static void applyMultiEffects(LivingEntity livingEntity, String configKey) {
        List<EffectData> effects = getMultiEffects(configKey);
        for (EffectData effectData : effects) {
            livingEntity.addEffect(new MobEffectInstance(
                effectData.effect,
                effectData.duration * 20, // 转换为游戏刻
                effectData.amplifier,
                false,
                true
            ));
        }
    }
}