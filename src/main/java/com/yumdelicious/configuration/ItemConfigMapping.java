package yum.configuration;

import yum.init.YumModItems;
import net.minecraft.world.item.Item;
import java.util.HashMap;
import java.util.Map;

public class ItemConfigMapping {
    private static final Map<Item, ConfigEntry> ITEM_CONFIG_MAP = new HashMap<Item, ConfigEntry>();
    
    static {
        // 初始化所有物品与配置的映射关系
        // 奶茶效果配置映射
        register(YumModItems.BUBBLE_TEA_1.get(), new ConfigEntry("milk_tea_1"));
        register(YumModItems.BUBBLE_TEA_2.get(), new ConfigEntry("milk_tea_2"));
        register(YumModItems.BUBBLE_TEA_3.get(), new ConfigEntry("milk_tea_3"));
        register(YumModItems.BUBBLE_TEA_4.get(), new ConfigEntry("milk_tea_4"));
        register(YumModItems.BUBBLE_TEA_5.get(), new ConfigEntry("milk_tea_5"));
        register(YumModItems.BUBBLE_TEA_6.get(), new ConfigEntry("milk_tea_6"));
        // 薯片效果配置映射
        register(YumModItems.CHIPSO_1.get(), new ConfigEntry("chips_1"));
        register(YumModItems.CHIPSO_2.get(), new ConfigEntry("chips_2"));
        register(YumModItems.CHIPSO_3.get(), new ConfigEntry("chips_3"));
        register(YumModItems.CHIPSO_4.get(), new ConfigEntry("chips_4"));
        // 巧克力效果配置映射
        register(YumModItems.CHOCOLATEO_1.get(), new ConfigEntry("chocolate_1"));
        register(YumModItems.CHOCOLATEO_2.get(), new ConfigEntry("chocolate_2"));
        // 辣条效果配置映射
        register(YumModItems.CHINESESPICYSNACKFOOD.get(), new ConfigEntry("spicy_snack"));
        register(YumModItems.CHINESESPICYSNACKFOODO.get(), new ConfigEntry("spicy_snack"));
        // 苏打水效果配置映射
        register(YumModItems.SODAO_1.get(), new ConfigEntry("sodao_1"));
        register(YumModItems.SODAO_2.get(), new ConfigEntry("sodao_2"));
        register(YumModItems.SODAO_3.get(), new ConfigEntry("sodao_3"));
        register(YumModItems.SODAO_4.get(), new ConfigEntry("sodao_4"));
        register(YumModItems.SODAO_5.get(), new ConfigEntry("sodao_5"));
        register(YumModItems.SODAO_6.get(), new ConfigEntry("sodao_6"));
        // 水果汁效果配置映射
        register(YumModItems.FRUITJUICEO_1.get(), new ConfigEntry("fruitjuiceo_1"));
        register(YumModItems.FRUITJUICEO_2.get(), new ConfigEntry("fruitjuiceo_2"));
        register(YumModItems.FRUITJUICEO_3.get(), new ConfigEntry("fruitjuiceo_3"));
        register(YumModItems.FRUITJUICEO_4.get(), new ConfigEntry("fruitjuiceo_4"));
        register(YumModItems.FRUITJUICEO_5.get(), new ConfigEntry("fruitjuiceo_5"));
        register(YumModItems.FRUITJUICEO_6.get(), new ConfigEntry("fruitjuiceo_6"));
        // 冰淇淋效果配置映射
        register(YumModItems.ICECREAM_1.get(), new ConfigEntry("icecream_1"));
        register(YumModItems.ICECREAM_2.get(), new ConfigEntry("icecream_2"));
        register(YumModItems.ICECREAM_3.get(), new ConfigEntry("icecream_3"));
        register(YumModItems.ICECREAM_4.get(), new ConfigEntry("icecream_4"));
        register(YumModItems.ICECREAM_5.get(), new ConfigEntry("icecream_5"));
        // 杯面效果配置映射
        register(YumModItems.O_CUP_NOODLES_1.get(), new ConfigEntry("ocupnoodles_1"));
        register(YumModItems.O_CUP_NOODLES_2.get(), new ConfigEntry("ocupnoodles_2"));
        register(YumModItems.O_CUP_NOODLES_3.get(), new ConfigEntry("ocupnoodles_3"));
        register(YumModItems.O_CUP_NOODLES_4.get(), new ConfigEntry("ocupnoodles_4"));
    }
    
    public static void register(Item item, ConfigEntry config) {
        ITEM_CONFIG_MAP.put(item, config);
    }
    
    public static ConfigEntry getConfigForItem(Item item) {
        return ITEM_CONFIG_MAP.get(item);
    }
}