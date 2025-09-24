package yum.configuration;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;

public interface EffectStrategy {
    void applyEffect(LivingEntity livingEntity, Item consumedItem);
}