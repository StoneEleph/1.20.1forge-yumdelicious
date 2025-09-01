
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package yum.init;

import yum.YumMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

public class YumModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, YumMod.MODID);
	public static final RegistryObject<CreativeModeTab> YUM = REGISTRY.register("yum",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.yum.yum")).icon(() -> new ItemStack(YumModItems.YUMYUM.get())).displayItems((parameters, tabData) -> {
				tabData.accept(YumModItems.CHIPS_1.get());
				tabData.accept(YumModItems.CHIPS_2.get());
				tabData.accept(YumModItems.CHIPS_3.get());
				tabData.accept(YumModItems.CHIPS_4.get());
				tabData.accept(YumModItems.CHOCOLATE_1.get());
				tabData.accept(YumModItems.CHOCOLATE_2.get());
				tabData.accept(YumModItems.BUBBLE_TEA_1.get());
				tabData.accept(YumModItems.BUBBLE_TEA_2.get());
				tabData.accept(YumModItems.BUBBLE_TEA_3.get());
				tabData.accept(YumModItems.BUBBLE_TEA_4.get());
				tabData.accept(YumModItems.BUBBLE_TEA_5.get());
				tabData.accept(YumModItems.BUBBLE_TEA_6.get());
				tabData.accept(YumModItems.CHINESESPICYSNACKFOOD.get());
				tabData.accept(YumModItems.SODA_1.get());
				tabData.accept(YumModItems.SODA_2.get());
				tabData.accept(YumModItems.SODA_3.get());
				tabData.accept(YumModItems.SODA_4.get());
				tabData.accept(YumModItems.SODA_5.get());
				tabData.accept(YumModItems.SODA_6.get());
				tabData.accept(YumModItems.FRUITJUICE_1.get());
				tabData.accept(YumModItems.FRUITJUICE_2.get());
				tabData.accept(YumModItems.FRUITJUICE_3.get());
				tabData.accept(YumModItems.FRUITJUICE_4.get());
				tabData.accept(YumModItems.FRUITJUICE_5.get());
				tabData.accept(YumModItems.FRUITJUICE_6.get());
				tabData.accept(YumModItems.ICECREAM_1.get());
				tabData.accept(YumModItems.ICECREAM_2.get());
				tabData.accept(YumModItems.ICECREAM_3.get());
				tabData.accept(YumModItems.ICECREAM_4.get());
				tabData.accept(YumModItems.ICECREAM_5.get());
				tabData.accept(YumModItems.CUP_NOODLES_1.get());
				tabData.accept(YumModItems.CUP_NOODLES_2.get());
				tabData.accept(YumModItems.CUP_NOODLES_3.get());
				tabData.accept(YumModItems.CUP_NOODLES_4.get());
			})

			.build());
}
