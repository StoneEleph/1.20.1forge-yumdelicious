package yum.item;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import yum.procedures.EffectConfig;

import java.util.List;

public class Fruitjuiceo_1Item extends Item {
	// 常量定义
	private static final String DRINKS_TAG = "drinks";
	private static final int MAX_USES = 3;
	
	public Fruitjuiceo_1Item() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(0).saturationMod(0f).alwaysEat().build()));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.DRINK;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		// 保存当前NBT数据
		CompoundTag originalNbt = itemstack.getOrCreateTag().copy();
		int currentDrinks = originalNbt.getInt(DRINKS_TAG);

		// 获取食物属性并增加饱食度
		FoodProperties foodProperties = itemstack.getFoodProperties(entity);
		if (foodProperties != null && entity instanceof Player) {
			Player player = (Player) entity;
			player.getFoodData().eat(foodProperties.getNutrition(), foodProperties.getSaturationModifier());
		}

		// 更新使用次数
		int newDrinks = currentDrinks + 1;
		CompoundTag newNbt = itemstack.getOrCreateTag();
		newNbt.putInt(DRINKS_TAG, newDrinks);
		itemstack.setTag(newNbt);

		// 使用达到最大次数后消耗物品
		if (newDrinks >= MAX_USES) {
			itemstack.shrink(1);
		}

		// 触发效果
		EffectConfig.execute(world, entity, this);

		return itemstack;
	}

	@Override
	public boolean isRepairable(ItemStack itemstack) {
		return false;
	}

	@Override
	public boolean isEnchantable(ItemStack itemstack) {
		return false;
	}

	@Override
	public boolean isBarVisible(ItemStack stack) {
		return false;
	}

	@Override
	public int getBarColor(ItemStack stack) {
		return super.getBarColor(stack);
	}

	@Override
	public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, net.minecraft.world.item.TooltipFlag flag) {
		super.appendHoverText(stack, world, tooltip, flag);
		
		if (stack.hasTag() && stack.getTag().contains(DRINKS_TAG)) {
			int drinks = stack.getTag().getInt(DRINKS_TAG);
			int remainingUses = MAX_USES - drinks;
			
			tooltip.add(Component.literal("饮用次数: " + drinks).withStyle(ChatFormatting.GRAY));
			
			if (remainingUses > 0) {
				tooltip.add(Component.literal("剩余: " + remainingUses + "/" + MAX_USES).withStyle(ChatFormatting.BLUE));
			} else {
				tooltip.add(Component.literal("已用完").withStyle(ChatFormatting.RED));
			}
		}
	}
}