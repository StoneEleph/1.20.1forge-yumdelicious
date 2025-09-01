
package yum.item;

import yum.procedures.EffectConfig;
import net.minecraft.world.entity.LivingEntity;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

public class Chocolateo1Item extends Item {
	public Chocolateo1Item() {
		super(new Item.Properties().stacksTo(4).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.6f).alwaysEat().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		if (!world.isClientSide() && entity instanceof Player) {
			EffectConfig.execute(world, entity, this);
		}
		return super.finishUsingItem(itemstack, world, entity);
	}
}
