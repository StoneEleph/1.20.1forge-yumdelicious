
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package yum.init;

import yum.item.YumyumItem;
import yum.item.PeachsodaoItem;
import yum.item.PeachsodaItem;
import yum.item.OrangesodaoItem;
import yum.item.OrangesodaItem;
import yum.item.MineralwateroItem;
import yum.item.MineralwaterItem;
import yum.item.LimeflavoredsodaoItem;
import yum.item.LimeflavoredsodaItem;
import yum.item.GrapesodaoItem;
import yum.item.GrapesodaItem;
import yum.item.ColaoItem;
import yum.item.ColaItem;
import yum.item.Chipso4Item;
import yum.item.Chipso3Item;
import yum.item.Chipso2Item;
import yum.item.Chipso1Item;
import yum.item.Chips4Item;
import yum.item.Chips3Item;
import yum.item.Chips2Item;
import yum.item.Chips1Item;
import yum.item.Chocolateo2Item;
import yum.item.Chocolateo1Item;
import yum.item.Chocolate2Item;
import yum.item.Chocolate1Item;
import yum.item.ChinesespicysnackfoodoItem;
import yum.item.ChinesespicysnackfoodItem;
import yum.item.BubbleTea6Item;
import yum.item.BubbleTea5Item;
import yum.item.BubbleTea4Item;
import yum.item.BubbleTea3Item;
import yum.item.BubbleTea2Item;
import yum.item.BubbleTea1Item;
import yum.item.BlueberryyogurtflavoredbeverageItem;
import yum.item.FruitjuiceItem;
import yum.item.GrapejuiceItem;
import yum.item.GreenappleflavorItem;
import yum.item.LitchijuiceItem;
import yum.item.PeachjuiceItem;
import yum.item.Fruitjuiceo_1Item;
import yum.item.Fruitjuiceo_2Item;
import yum.item.Fruitjuiceo_3Item;
import yum.item.Fruitjuiceo_4Item;
import yum.item.Fruitjuiceo_5Item;
import yum.item.Fruitjuiceo_6Item;
import yum.item.CupNoodles_1Item;
import yum.item.CupNoodles_2Item;
import yum.item.CupNoodles_3Item;
import yum.item.CupNoodles_4Item;
import yum.item.oCupNoodles_1Item;
import yum.item.oCupNoodles_2Item;
import yum.item.oCupNoodles_3Item;
import yum.item.oCupNoodles_4Item;

import yum.YumMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

public class YumModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, YumMod.MODID);
	// 奶茶
	public static final RegistryObject<Item> BUBBLE_TEA_1 = REGISTRY.register("bubble_tea_1", () -> new BubbleTea1Item());
	public static final RegistryObject<Item> BUBBLE_TEA_2 = REGISTRY.register("bubble_tea_2", () -> new BubbleTea2Item());
	public static final RegistryObject<Item> BUBBLE_TEA_3 = REGISTRY.register("bubble_tea_3", () -> new BubbleTea3Item());
	public static final RegistryObject<Item> BUBBLE_TEA_4 = REGISTRY.register("bubble_tea_4", () -> new BubbleTea4Item());
	public static final RegistryObject<Item> BUBBLE_TEA_5 = REGISTRY.register("bubble_tea_5", () -> new BubbleTea5Item());
	public static final RegistryObject<Item> BUBBLE_TEA_6 = REGISTRY.register("bubble_tea_6", () -> new BubbleTea6Item());
	// 辣条
	public static final RegistryObject<Item> CHINESESPICYSNACKFOOD = REGISTRY.register("chinesespicysnackfood", () -> new ChinesespicysnackfoodItem());
	public static final RegistryObject<Item> CHINESESPICYSNACKFOODO = REGISTRY.register("chinesespicysnackfoodo", () -> new ChinesespicysnackfoodoItem());
	// 薯片
	public static final RegistryObject<Item> CHIPS_1 = REGISTRY.register("chips_1", () -> new Chips1Item());
	public static final RegistryObject<Item> CHIPS_2 = REGISTRY.register("chips_2", () -> new Chips2Item());
	public static final RegistryObject<Item> CHIPS_3 = REGISTRY.register("chips_3", () -> new Chips3Item());
	public static final RegistryObject<Item> CHIPS_4 = REGISTRY.register("chips_4", () -> new Chips4Item());
	public static final RegistryObject<Item> CHIPSO_1 = REGISTRY.register("chipso_1", () -> new Chipso1Item());
	public static final RegistryObject<Item> CHIPSO_2 = REGISTRY.register("chipso_2", () -> new Chipso2Item());
	public static final RegistryObject<Item> CHIPSO_3 = REGISTRY.register("chipso_3", () -> new Chipso3Item());
	public static final RegistryObject<Item> CHIPSO_4 = REGISTRY.register("chipso_4", () -> new Chipso4Item());
	// 巧克力
	public static final RegistryObject<Item> CHOCOLATE_1 = REGISTRY.register("chocolate_1", () -> new Chocolate1Item());
	public static final RegistryObject<Item> CHOCOLATE_2 = REGISTRY.register("chocolate_2", () -> new Chocolate2Item());
	public static final RegistryObject<Item> CHOCOLATEO_1 = REGISTRY.register("chocolateo_1", () -> new Chocolateo1Item());
	public static final RegistryObject<Item> CHOCOLATEO_2 = REGISTRY.register("chocolateo_2", () -> new Chocolateo2Item());
	public static final RegistryObject<Item> YUMYUM = REGISTRY.register("yumyum", () -> new YumyumItem());
	// 汽水
	public static final RegistryObject<Item> SODA_1 = REGISTRY.register("soda_1", () -> new MineralwaterItem());
	public static final RegistryObject<Item> SODAO_1 = REGISTRY.register("sodao_1", () -> new MineralwateroItem());
	public static final RegistryObject<Item> SODA_2 = REGISTRY.register("soda_2", () -> new ColaItem());
	public static final RegistryObject<Item> SODAO_2 = REGISTRY.register("sodao_2", () -> new ColaoItem());
	public static final RegistryObject<Item> SODA_3 = REGISTRY.register("soda_3", () -> new GrapesodaItem());
	public static final RegistryObject<Item> SODAO_3 = REGISTRY.register("sodao_3", () -> new GrapesodaoItem());
	public static final RegistryObject<Item> SODA_4 = REGISTRY.register("soda_4", () -> new LimeflavoredsodaItem());
	public static final RegistryObject<Item> SODAO_4 = REGISTRY.register("sodao_4", () -> new LimeflavoredsodaoItem());
	public static final RegistryObject<Item> SODA_5 = REGISTRY.register("soda_5", () -> new OrangesodaItem());
	public static final RegistryObject<Item> SODAO_5 = REGISTRY.register("sodao_5", () -> new OrangesodaoItem());
	public static final RegistryObject<Item> SODA_6 = REGISTRY.register("soda_6", () -> new PeachsodaItem());
	public static final RegistryObject<Item> SODAO_6 = REGISTRY.register("sodao_6", () -> new PeachsodaoItem());
	// 果汁
	public static final RegistryObject<Item> FRUITJUICE_1 = REGISTRY.register("fruitjuice_1", () -> new FruitjuiceItem());
	public static final RegistryObject<Item> FRUITJUICE_2 = REGISTRY.register("fruitjuice_2", () -> new GrapejuiceItem());
	public static final RegistryObject<Item> FRUITJUICE_3 = REGISTRY.register("fruitjuice_3", () -> new GreenappleflavorItem());
	public static final RegistryObject<Item> FRUITJUICE_4 = REGISTRY.register("fruitjuice_4", () -> new LitchijuiceItem());
	public static final RegistryObject<Item> FRUITJUICE_5 = REGISTRY.register("fruitjuice_5", () -> new PeachjuiceItem());
	public static final RegistryObject<Item> FRUITJUICE_6 = REGISTRY.register("fruitjuice_6", () -> new BlueberryyogurtflavoredbeverageItem());
	public static final RegistryObject<Item> FRUITJUICEO_1 = REGISTRY.register("fruitjuiceo_1", () -> new Fruitjuiceo_1Item());
	public static final RegistryObject<Item> FRUITJUICEO_2 = REGISTRY.register("fruitjuiceo_2", () -> new Fruitjuiceo_2Item());
	public static final RegistryObject<Item> FRUITJUICEO_3 = REGISTRY.register("fruitjuiceo_3", () -> new Fruitjuiceo_3Item());
	public static final RegistryObject<Item> FRUITJUICEO_4 = REGISTRY.register("fruitjuiceo_4", () -> new Fruitjuiceo_4Item());
	public static final RegistryObject<Item> FRUITJUICEO_5 = REGISTRY.register("fruitjuiceo_5", () -> new Fruitjuiceo_5Item());
	public static final RegistryObject<Item> FRUITJUICEO_6 = REGISTRY.register("fruitjuiceo_6", () -> new Fruitjuiceo_6Item());
	// 冰淇淋
	public static final RegistryObject<Item> CONE = REGISTRY.register("cone", () -> new yum.item.ConeItem());
	public static final RegistryObject<Item> ICECREAM_1 = REGISTRY.register("icecream_1", () -> new yum.item.Icecream_1Item());
	public static final RegistryObject<Item> ICECREAM_2 = REGISTRY.register("icecream_2", () -> new yum.item.Icecream_2Item());
	public static final RegistryObject<Item> ICECREAM_3 = REGISTRY.register("icecream_3", () -> new yum.item.Icecream_3Item());
	public static final RegistryObject<Item> ICECREAM_4 = REGISTRY.register("icecream_4", () -> new yum.item.Icecream_4Item());
	public static final RegistryObject<Item> ICECREAM_5 = REGISTRY.register("icecream_5", () -> new yum.item.Icecream_5Item());
	// 杯面
	public static final RegistryObject<Item> CUP_NOODLES_1 = REGISTRY.register("cup_noodles_1", () -> new CupNoodles_1Item());
	public static final RegistryObject<Item> CUP_NOODLES_2 = REGISTRY.register("cup_noodles_2", () -> new CupNoodles_2Item());
	public static final RegistryObject<Item> CUP_NOODLES_3 = REGISTRY.register("cup_noodles_3", () -> new CupNoodles_3Item());
	public static final RegistryObject<Item> CUP_NOODLES_4 = REGISTRY.register("cup_noodles_4", () -> new CupNoodles_4Item());
	public static final RegistryObject<Item> O_CUP_NOODLES_1 = REGISTRY.register("o_cup_noodles_1", () -> new oCupNoodles_1Item());
	public static final RegistryObject<Item> O_CUP_NOODLES_2 = REGISTRY.register("o_cup_noodles_2", () -> new oCupNoodles_2Item());
	public static final RegistryObject<Item> O_CUP_NOODLES_3 = REGISTRY.register("o_cup_noodles_3", () -> new oCupNoodles_3Item());
	public static final RegistryObject<Item> O_CUP_NOODLES_4 = REGISTRY.register("o_cup_noodles_4", () -> new oCupNoodles_4Item());
}

