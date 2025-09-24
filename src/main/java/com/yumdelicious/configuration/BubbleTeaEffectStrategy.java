package yum.configuration;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import yum.init.YumModItems;

public class BubbleTeaEffectStrategy implements EffectStrategy {
    @Override
    public void applyEffect(LivingEntity livingEntity, Item consumedItem) {
        if (consumedItem == YumModItems.BUBBLE_TEA_1.get()) {
            // 应用奶茶1号效果
        } else if (consumedItem == YumModItems.BUBBLE_TEA_2.get()) {
            // 应用奶茶2号效果
        }
        // 其他奶茶类型处理
    }
}