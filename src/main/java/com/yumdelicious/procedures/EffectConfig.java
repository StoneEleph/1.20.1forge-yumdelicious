package yum.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import yum.init.YumModItems;
import yum.configuration.YumitemeffectstomlConfiguration;
import yum.configuration.ConfigHelper;
import yum.configuration.ItemConfigMapping;
import yum.configuration.ConfigEntry;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class EffectConfig {
    private static final Logger LOGGER = LogManager.getLogger(EffectConfig.class);
    private static final Map<Item, List<EffectData>> ITEM_EFFECTS = new HashMap<Item, List<EffectData>>();
    
    public static void registerItemEffect(Item item, EffectData config) {
        if (item != null && config != null) {
            ITEM_EFFECTS.computeIfAbsent(item, k -> new ArrayList<EffectData>()).add(config);
        }
    }
    
    // 减少重复的instanceof检查
    public static void execute(Level world, Entity entity, Item consumedItem) {
        // 前置检查优化
        if (world == null || entity == null || world.isClientSide() || consumedItem == null) {
            return;
        }
        
        // 快速检查是否为LivingEntity
        if (!(entity instanceof LivingEntity)) {
            return;
        }
        
        LivingEntity livingEntity = (LivingEntity) entity;
        
        // 使用配置文件效果
        applyConfigEffects(livingEntity, consumedItem);
    }
    
    private static boolean isConfigEnabled(Item consumedItem) {
        ConfigEntry config = ItemConfigMapping.getConfigForItem(consumedItem);
        if (config != null) {
            return ConfigHelper.isConfigEnabled(config.getConfigKey());
        }
        return false;
    }
    
    private static void applyConfigEffects(LivingEntity livingEntity, Item consumedItem) {
        ConfigEntry config = ItemConfigMapping.getConfigForItem(consumedItem);
        if (config != null) {
            try {
                // 使用新的多效果配置系统
                List<EffectData> effects = ConfigHelper.getConfigEffectsWithFallback(config.getConfigKey());
                
                for (EffectData effectData : effects) {
                    livingEntity.addEffect(new MobEffectInstance(
                        effectData.effect,
                        effectData.duration * 20, // 转换为游戏刻 (1秒 = 20刻)
                        effectData.amplifier,
                        false,
                        true
                    ));
                }
            } catch (Exception e) {
                LOGGER.error("Error applying config effects for: " + config.getConfigKey(), e);
            }
        }
    }
    

    
    private static void applyDefaultEffects(LivingEntity livingEntity, Item consumedItem) {
        List<EffectData> configs = ITEM_EFFECTS.get(consumedItem);
        
        if (configs != null) {
            for (EffectData config : configs) {
                livingEntity.addEffect(new MobEffectInstance(
                    config.effect,
                    config.duration,
                    config.amplifier,
                    false,
                    true
                ));
            }
        }
    }
    
}
