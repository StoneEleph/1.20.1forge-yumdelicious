package yum.procedures;

import yum.init.YumModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.items.ItemHandlerHelper;

import java.util.HashMap;
import java.util.Map;

public class ChipsProcedure {
    private static final Map<Item, Item> CHIPS_MAP = new HashMap<Item, Item>();
    private static final SoundEvent CHIP_SOUND = SoundEvents.ITEM_FRAME_REMOVE_ITEM;

    static {
        // 物品转换映射 - 使用缓存减少.get()调用
        Item chips1 = YumModItems.CHIPS_1.get();
        Item chipso1 = YumModItems.CHIPSO_1.get();
        Item chips2 = YumModItems.CHIPS_2.get();
        Item chipso2 = YumModItems.CHIPSO_2.get();
        Item chips3 = YumModItems.CHIPS_3.get();
        Item chipso3 = YumModItems.CHIPSO_3.get();
        Item chips4 = YumModItems.CHIPS_4.get();
        Item chipso4 = YumModItems.CHIPSO_4.get();
        Item chocolate1 = YumModItems.CHOCOLATE_1.get();
        Item chocolateo1 = YumModItems.CHOCOLATEO_1.get();
        Item chocolate2 = YumModItems.CHOCOLATE_2.get();
        Item chocolateo2 = YumModItems.CHOCOLATEO_2.get();
        Item snackfood = YumModItems.CHINESESPICYSNACKFOOD.get();
        Item snackfoodo = YumModItems.CHINESESPICYSNACKFOODO.get();
        
        // 薯片
        CHIPS_MAP.put(chips1, chipso1);
        CHIPS_MAP.put(chips2, chipso2);
        CHIPS_MAP.put(chips3, chipso3);
        CHIPS_MAP.put(chips4, chipso4);
        // 巧克力
        CHIPS_MAP.put(chocolate1, chocolateo1);
        CHIPS_MAP.put(chocolate2, chocolateo2);
        // 辣条
        CHIPS_MAP.put(snackfood, snackfoodo);
        
        // 饮料
        Item soda1 = YumModItems.SODA_1.get();
        Item sodao1 = YumModItems.SODAO_1.get();
        Item soda2 = YumModItems.SODA_2.get();
        Item sodao2 = YumModItems.SODAO_2.get();
        Item soda3 = YumModItems.SODA_3.get();
        Item sodao3 = YumModItems.SODAO_3.get();
        Item soda4 = YumModItems.SODA_4.get();
        Item sodao4 = YumModItems.SODAO_4.get();
        Item soda5 = YumModItems.SODA_5.get();
        Item sodao5 = YumModItems.SODAO_5.get();
        Item soda6 = YumModItems.SODA_6.get();
        Item sodao6 = YumModItems.SODAO_6.get();
        
        CHIPS_MAP.put(soda1, sodao1);
        CHIPS_MAP.put(soda2, sodao2);
        CHIPS_MAP.put(soda3, sodao3);
        CHIPS_MAP.put(soda4, sodao4);
        CHIPS_MAP.put(soda5, sodao5);
		CHIPS_MAP.put(soda6, sodao6);
		
		// 水果汁
		Item fruitjuice1 = YumModItems.FRUITJUICE_1.get();
		Item fruitjuiceo1 = YumModItems.FRUITJUICEO_1.get();
		Item fruitjuice2 = YumModItems.FRUITJUICE_2.get();
		Item fruitjuiceo2 = YumModItems.FRUITJUICEO_2.get();
		Item fruitjuice3 = YumModItems.FRUITJUICE_3.get();
		Item fruitjuiceo3 = YumModItems.FRUITJUICEO_3.get();
		Item fruitjuice4 = YumModItems.FRUITJUICE_4.get();
		Item fruitjuiceo4 = YumModItems.FRUITJUICEO_4.get();
		Item fruitjuice5 = YumModItems.FRUITJUICE_5.get();
		Item fruitjuiceo5 = YumModItems.FRUITJUICEO_5.get();
		Item fruitjuice6 = YumModItems.FRUITJUICE_6.get();
		Item fruitjuiceo6 = YumModItems.FRUITJUICEO_6.get();
		
		CHIPS_MAP.put(fruitjuice1, fruitjuiceo1);
		CHIPS_MAP.put(fruitjuice2, fruitjuiceo2);
		CHIPS_MAP.put(fruitjuice3, fruitjuiceo3);
		CHIPS_MAP.put(fruitjuice4, fruitjuiceo4);
		CHIPS_MAP.put(fruitjuice5, fruitjuiceo5);
		CHIPS_MAP.put(fruitjuice6, fruitjuiceo6);
        
        // 杯面
        Item cupnoodles1 = YumModItems.CUP_NOODLES_1.get();
        Item ocupnoodles1 = YumModItems.O_CUP_NOODLES_1.get();
        Item cupnoodles2 = YumModItems.CUP_NOODLES_2.get();
        Item ocupnoodles2 = YumModItems.O_CUP_NOODLES_2.get();
        Item cupnoodles3 = YumModItems.CUP_NOODLES_3.get();
        Item ocupnoodles3 = YumModItems.O_CUP_NOODLES_3.get();
        Item cupnoodles4 = YumModItems.CUP_NOODLES_4.get();
        Item ocupnoodles4 = YumModItems.O_CUP_NOODLES_4.get();
        
        CHIPS_MAP.put(cupnoodles1, ocupnoodles1);
        CHIPS_MAP.put(cupnoodles2, ocupnoodles2);
        CHIPS_MAP.put(cupnoodles3, ocupnoodles3);
        CHIPS_MAP.put(cupnoodles4, ocupnoodles4);
	}

	// 提供动态注册方法，添加null检查
    public static void registerConversion(Item input, Item output) {
        if (input == null || output == null) {
            throw new IllegalArgumentException("Input and output items must not be null");
        }
        CHIPS_MAP.put(input, output);
    }

    // 创建输出物品，复制NBT - 优化性能
    private static ItemStack createOutput(ItemStack input, Item outputItem) {
        if (outputItem == null) {
            return ItemStack.EMPTY;
        }
        ItemStack out = new ItemStack(outputItem, 1);
        if (input.hasTag()) {
            out.setTag(input.getTag().copy());
        }
        return out;
    }

    // tryConvert方法优化减少重复计算
    private static boolean tryConvert(Level world, Player player, ItemStack held, int slot) {
        // 前置检查优化
        if (world == null || held.isEmpty()) {
            return false;
        }
        
        Item heldItem = held.getItem();
        if (!CHIPS_MAP.containsKey(heldItem)) {
            return false;
        }

        // 获取当前手中的物品，确保操作前物品未变化
        ItemStack currentStack = (slot == -1) ? player.getOffhandItem() : player.getMainHandItem();
        if (!ItemStack.matches(currentStack, held)) {
            return false;
        }

        // 创建输出物品（单个）
        Item outputItem = CHIPS_MAP.get(heldItem);
        ItemStack output = createOutput(held, outputItem);
        if (output.isEmpty()) {
            return false; // 输出物品无效，中止
        }

        // 剩余物品处理优化
        ItemStack rest = held.copy();
        rest.shrink(1);

        // 根据槽位设置物品
        if (rest.isEmpty()) {
            // 原物品数量为1：直接设置输出物品到槽位
            if (slot == -1) {
                player.setItemInHand(InteractionHand.OFF_HAND, output);
            } else {
                player.getInventory().setItem(slot, output);
            }
        } else {
            // 原物品数量大于1：设置剩余物品到槽位，然后给予输出物品
            if (slot == -1) {
                player.setItemInHand(InteractionHand.OFF_HAND, rest);
            } else {
                player.getInventory().setItem(slot, rest);
            }
            ItemHandlerHelper.giveItemToPlayer(player, output);
        }

        // 播放声音优化 - 减少null检查
        if (CHIP_SOUND != null) {
            world.playSound(null, player.getX(), player.getY(), player.getZ(),
                    CHIP_SOUND, SoundSource.PLAYERS, 1.0F, 1.0F);
        }

        return true;
    }

    // 执行方法优化 - 减少重复的containsKey调用
    public static void execute(Level world, Player player) {
        if (world == null || player == null || world.isClientSide()) {
            return;
        }
    
        // 检查主手
        ItemStack mainHandItem = player.getMainHandItem();
        if (!mainHandItem.isEmpty()) {
            Item mainHandItemType = mainHandItem.getItem();
            if (CHIPS_MAP.containsKey(mainHandItemType)) {
                if (tryConvert(world, player, mainHandItem, player.getInventory().selected)) {
                    return;
                }
            }
        }
    
        // 检查副手
        ItemStack offHandItem = player.getOffhandItem();
        if (!offHandItem.isEmpty()) {
            Item offHandItemType = offHandItem.getItem();
            if (CHIPS_MAP.containsKey(offHandItemType)) {
                tryConvert(world, player, offHandItem, -1);
            }
        }
    }
}
