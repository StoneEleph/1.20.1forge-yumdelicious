package yum.configuration;

import net.minecraft.world.item.Item;
import yum.init.YumModItems;

public class EffectStrategyFactory {
    public static EffectStrategy getStrategy(Item item) {
        if (item == YumModItems.BUBBLE_TEA_1.get() || item == YumModItems.BUBBLE_TEA_2.get()) {
            return new BubbleTeaEffectStrategy();
        }
        // 其他物品类型的策略
        return null;
    }
}