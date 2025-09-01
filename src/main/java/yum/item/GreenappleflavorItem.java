package yum.item;

import yum.procedures.ChipsProcedure;
import yum.procedures.EffectConfig;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

import java.util.List;

public class GreenappleflavorItem extends Item {
	// 常量定义
	private static final String BITES_TAG = "bites";
	private static final int MAX_USES = 3;
	
	public GreenappleflavorItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.DRINK;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		// 保存当前NBT数据
		CompoundTag originalNbt = itemstack.getOrCreateTag().copy();
		int currentBites = originalNbt.getInt(BITES_TAG);

		// 更新使用次数
		int newBites = currentBites + 1;
		CompoundTag newNbt = itemstack.getOrCreateTag();
		newNbt.putInt(BITES_TAG, newBites);
		itemstack.setTag(newNbt);

		// 使用达到最大次数后消耗物品
		if (newBites >= MAX_USES) {
			itemstack.shrink(1);
		}

		// 传入当前物品实例以触发对应效果
		EffectConfig.execute(world, entity, this);

		return itemstack;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ChipsProcedure.execute(world, entity);
		return ar;
	}

	@Override
	public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, net.minecraft.world.item.TooltipFlag flag) {
		super.appendHoverText(stack, world, tooltip, flag);
		
		if (stack.hasTag() && stack.getTag().contains(BITES_TAG)) {
			int bites = stack.getTag().getInt(BITES_TAG);
			int remainingUses = MAX_USES - bites;
			
			tooltip.add(Component.literal("食用次数: " + bites).withStyle(ChatFormatting.GRAY));
			
			if (remainingUses > 0) {
				tooltip.add(Component.literal("剩余: " + remainingUses + "/" + MAX_USES).withStyle(ChatFormatting.BLUE));
			} else {
				tooltip.add(Component.literal("已用完").withStyle(ChatFormatting.RED));
			}
		}
	}
}