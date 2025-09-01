package yum.configuration;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import java.util.List;

/**
 * 效果应用工具类
 * 使用方法：
 * 1. 在配置文件中定义多个效果，格式为：effect1,effect2,...
 * 2. 为每个效果提供独立的duration和amplifier配置，格式为：duration1,duration2,... 和 amplifier1,amplifier2,...
 */
public class EffectApplier {
    public static void applyEffects(LivingEntity entity, List<String> effectTypes, List<Integer> durations, List<Integer> amplifiers) {
        if (effectTypes.size() != durations.size() || effectTypes.size() != amplifiers.size()) {
            throw new IllegalArgumentException("效果类型、持续时间和等级数量不匹配");
        }
        
        for (int i = 0; i < effectTypes.size(); i++) {
            String effectType = effectTypes.get(i);
            int duration = durations.get(i);
            int amplifier = amplifiers.get(i);
            
            switch(effectType) {
                case "FIRE_RESISTANCE":
                    entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, duration, amplifier));
                    break;
                case "REGENERATION":
                    entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, duration, amplifier));
                    break;
                // 其他效果类型处理
            }
        }
    }
}