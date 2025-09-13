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

public class Icecream_2Item extends Item {
	private final BiteCounter biteCounter = new BiteCounter();
	private static final int MAX_USES = 3;
	
	public Icecream_2Item() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(0).saturationMod(0f).alwaysEat().build()));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

    @Override
    public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        // 记录使用的手（主手或副手）
        boolean wasInOffhand = entity.getOffhandItem() == itemstack;
        
        // 触发效果
        EffectConfig.execute(world, entity, this);
        
        biteCounter.incrementBites(itemstack);
        
        // 使用3次后消耗物品并给予甜筒
        if (biteCounter.isMaxUsesReached(itemstack)) {
            itemstack.shrink(1);
            
            // 给予玩家甜筒物品
            if (!world.isClientSide() && entity instanceof net.minecraft.world.entity.player.Player) {
                net.minecraft.world.entity.player.Player player = (net.minecraft.world.entity.player.Player) entity;
                ItemStack coneStack = new ItemStack(YumModItems.CONE.get(), 1);
                
                // 根据原来冰淇淋的位置放置甜筒
                if (wasInOffhand) {
                    // 如果是在副手使用的，检查副手是否为空
                    if (player.getOffhandItem().isEmpty()) {
                        player.setItemInHand(net.minecraft.world.InteractionHand.OFF_HAND, coneStack);
                    } else {
                        // 如果副手不空，尝试添加到物品栏
                        if (!player.getInventory().add(coneStack)) {
                            player.drop(coneStack, false);
                        }
                    }
                } else {
                    // 如果是在主手使用的，找到原来的槽位
                    int slot = -1;
                    for (int i = 0; i < player.getInventory().items.size(); i++) {
                        if (player.getInventory().items.get(i) == itemstack) {
                            slot = i;
                            break;
                        }
                    }
                    
                    // 如果找到原来的槽位且该槽位为空，放置甜筒
                    if (slot != -1 && player.getInventory().getItem(slot).isEmpty()) {
                        player.getInventory().setItem(slot, coneStack);
                    } else {
                        // 否则尝试添加到物品栏
                        if (!player.getInventory().add(coneStack)) {
                            player.drop(coneStack, false);
                        }
                    }
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
		biteCounter.appendBiteTooltip(stack, tooltip, "咬食次数", MAX_USES);
	}
}