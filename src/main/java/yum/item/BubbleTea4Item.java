
package yum.item;

import yum.procedures.EffectConfig;
import yum.item.BiteCounter;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

import java.util.List;

public class BubbleTea4Item extends Item {
	// 使用BiteCounter管理饮用次数
	private final BiteCounter biteCounter = new BiteCounter("drinks", 3);
	
    public BubbleTea4Item() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(0).saturationMod(0f).alwaysEat().build()));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemstack) {
        return UseAnim.DRINK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        // 获取食物属性并增加饱食度
        FoodProperties foodProperties = itemstack.getFoodProperties(entity);
        if (foodProperties != null && entity instanceof Player) {
            Player player = (Player) entity;
            player.getFoodData().eat(foodProperties.getNutrition(), foodProperties.getSaturationModifier());
        }

        // 更新使用次数
        biteCounter.incrementBites(itemstack);

        // 使用达到最大次数后消耗物品
        if (biteCounter.isMaxUsesReached(itemstack)) {
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
        
        biteCounter.appendBiteTooltip(stack, tooltip, "饮用次数", 3);
    }
}
