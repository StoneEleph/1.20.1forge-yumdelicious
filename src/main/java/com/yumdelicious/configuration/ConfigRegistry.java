package yum.configuration;

import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yum.YumMod;

@Mod.EventBusSubscriber(modid = YumMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ConfigRegistry {
    
    @SubscribeEvent
    public static void onModConfigEvent(final ModConfigEvent.Loading event) {
        // 配置加载时的处理
        YumMod.LOGGER.info("Yum item effects configuration loaded");
        
        // 确保配置已加载
        if (event.getConfig().getSpec() == YumitemeffectstomlConfiguration.SPEC) {
            YumMod.LOGGER.info("Yum item effects configuration spec loaded successfully");
        }
    }
    
    @SubscribeEvent
    public static void onModConfigReload(final ModConfigEvent.Reloading event) {
        // 配置重载时的处理
        YumMod.LOGGER.info("Yum item effects configuration reloaded");
        
        // 确保配置已重新加载
        if (event.getConfig().getSpec() == YumitemeffectstomlConfiguration.SPEC) {
            YumMod.LOGGER.info("Yum item effects configuration spec reloaded successfully");
        }
    }
}