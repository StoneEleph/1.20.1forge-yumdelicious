package yum.item;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import yum.procedures.EffectConfig;

import java.util.List;

import yum.init.YumModItems;

public class Icecream_5Item extends Item {
	// 常量定义
	private static final String BITES_TAG = "bites";
	private static final int MAX_USES = 3;
	
	public Icecream_5Item() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(0).saturationMod(0f).alwaysEat().build()));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		// 触发效果
		EffectConfig.execute(world, entity, this);
		
		CompoundTag nbt = itemstack.getOrCreateTag();
		int bites = nbt.getInt(BITES_TAG) + 1;
		nbt.putInt(BITES_TAG, bites);
		itemstack.setTag(nbt);
		
		// 使用3次后消耗物品并给予甜筒
		if (bites >= MAX_USES) {
			itemstack.shrink(1);
			
			// 给予玩家甜筒物品
			if (!world.isClientSide() && entity instanceof net.minecraft.world.entity.player.Player) {
				net.minecraft.world.entity.player.Player player = (net.minecraft.world.entity.player.Player) entity;
				ItemStack coneStack = new ItemStack(YumModItems.CONE.get(), 1);
				
				// 尝试添加到物品栏，如果满了就掉落
				if (!player.getInventory().add(coneStack)) {
					player.drop(coneStack, false);
				}
			}
		}
		
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
		
		if (stack.hasTag() && stack.getTag().contains(BITES_TAG)) {
			int bites = stack.getTag().getInt(BITES_TAG);
			int remainingUses = MAX_USES - bites;
			
			tooltip.add(Component.literal("咬食次数: " + bites).withStyle(ChatFormatting.GRAY));
			
			if (remainingUses > 0) {
				tooltip.add(Component.literal("剩余: " + remainingUses + "/" + MAX_USES).withStyle(ChatFormatting.BLUE));
			} else {
				tooltip.add(Component.literal("已用完").withStyle(ChatFormatting.RED));
			}
		}
	}
}