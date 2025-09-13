package yum.configuration;

import net.minecraftforge.common.ForgeConfigSpec;
import java.util.List;
import java.util.ArrayList;

/**
 * Yum美味Mod配置文件
 * 管理所有食物效果的配置设置
 */
public class YumitemeffectstomlConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	
	// 奶茶效果配置
	public static final ForgeConfigSpec.ConfigValue<Boolean> milk_tea_1_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> milk_tea_1_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> milk_tea_2_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> milk_tea_2_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> milk_tea_3_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> milk_tea_3_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> milk_tea_4_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> milk_tea_4_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> milk_tea_5_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> milk_tea_5_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> milk_tea_6_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> milk_tea_6_multi_effects;
	
	// 辣条效果配置
	public static final ForgeConfigSpec.ConfigValue<Boolean> spicy_snack_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> spicy_snack_multi_effects;
	
	// 薯片效果配置
	public static final ForgeConfigSpec.ConfigValue<Boolean> chips_1_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> chips_1_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> chips_2_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> chips_2_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> chips_3_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> chips_3_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> chips_4_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> chips_4_multi_effects;
	
	// 巧克力效果配置
	public static final ForgeConfigSpec.ConfigValue<Boolean> chocolate_1_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> chocolate_1_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> chocolate_2_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> chocolate_2_multi_effects;

	// 苏打水效果配置
	public static final ForgeConfigSpec.ConfigValue<Boolean> sodao_1_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> sodao_1_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> sodao_2_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> sodao_2_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> sodao_3_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> sodao_3_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> sodao_4_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> sodao_4_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> sodao_5_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> sodao_5_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> sodao_6_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> sodao_6_multi_effects;
	
	// 水果汁效果配置
	public static final ForgeConfigSpec.ConfigValue<Boolean> fruitjuiceo_1_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> fruitjuiceo_1_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> fruitjuiceo_2_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> fruitjuiceo_2_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> fruitjuiceo_3_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> fruitjuiceo_3_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> fruitjuiceo_4_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> fruitjuiceo_4_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> fruitjuiceo_5_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> fruitjuiceo_5_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> fruitjuiceo_6_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> fruitjuiceo_6_multi_effects;

	// 冰淇淋效果配置
	public static final ForgeConfigSpec.ConfigValue<Boolean> icecream_1_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> icecream_1_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> icecream_2_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> icecream_2_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> icecream_3_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> icecream_3_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> icecream_4_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> icecream_4_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> icecream_5_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> icecream_5_multi_effects;
	
	// 杯面效果配置
	public static final ForgeConfigSpec.ConfigValue<Boolean> ocupnoodles_1_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> ocupnoodles_1_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ocupnoodles_2_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> ocupnoodles_2_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ocupnoodles_3_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> ocupnoodles_3_multi_effects;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ocupnoodles_4_enabled;
	public static final ForgeConfigSpec.ConfigValue<String> ocupnoodles_4_multi_effects;
	
	static {
		BUILDER.push("配置说明：");
		BUILDER.comment("每个配置分类包含enabled(启用) | effect(效果) | duration(持续时间) | amplifier(强度) | multi_effects(多重效果)");
		BUILDER.comment("enabled：是否启用该效果");
		BUILDER.comment("effect：效果名称，例如\"minecraft:strength\"");
		BUILDER.comment("duration：效果持续时间，单位为s，例如20表示20秒");
		BUILDER.comment("amplifier：效果强度，例如0表示1级强度，1表示2级强度");
		BUILDER.comment("multi_effects：多重效果，格式为JSON数组，每个元素包含effect、duration、amplifier三个参数,");
		BUILDER.comment("例如\"[{\\\"effect\\\":\\\"minecraft:strength\\\",\\\"duration\\\":200,\\\"amplifier\\\":0},{\\\"effect\\\":\\\"minecraft:regeneration\\\",\\\"duration\\\":200,\\\"amplifier\\\":0}]\"表示力量效果持续200秒，强度为1级，再生效果持续200秒，强度为0级");
		BUILDER.comment("注意：如果enabled为false，其他参数将被忽略，效果将不会生效");
		BUILDER.push("奶茶效果配置");
		milk_tea_1_enabled = BUILDER.define("milk_tea_1_enabled", true);
		milk_tea_1_multi_effects = BUILDER.define("milk_tea_1_multi_effects", "[{\"effect\":\"minecraft:regeneration\",\"duration\":10,\"amplifier\":0}]");
		milk_tea_2_enabled = BUILDER.define("milk_tea_2_enabled", true);
		milk_tea_2_multi_effects = BUILDER.define("milk_tea_2_multi_effects", "[{\"effect\":\"minecraft:resistance\",\"duration\":20,\"amplifier\":0}]");
		milk_tea_3_enabled = BUILDER.define("milk_tea_3_enabled", true);
		milk_tea_3_multi_effects = BUILDER.define("milk_tea_3_multi_effects", "[{\"effect\":\"minecraft:instant_health\",\"duration\":0,\"amplifier\":0}]");
		milk_tea_4_enabled = BUILDER.define("milk_tea_4_enabled", true);
		milk_tea_4_multi_effects = BUILDER.define("milk_tea_4_multi_effects", "[{\"effect\":\"minecraft:speed\",\"duration\":20,\"amplifier\":0}]");
		milk_tea_5_enabled = BUILDER.define("milk_tea_5_enabled", true);
		milk_tea_5_multi_effects = BUILDER.define("milk_tea_5_multi_effects", "[{\"effect\":\"minecraft:fire_resistance\",\"duration\":40,\"amplifier\":0}]");
		milk_tea_6_enabled = BUILDER.define("milk_tea_6_enabled", true);
		milk_tea_6_multi_effects = BUILDER.define("milk_tea_6_multi_effects", "[{\"effect\":\"minecraft:haste\",\"duration\":40,\"amplifier\":0}]");
		BUILDER.pop();
		
		BUILDER.push("辣条效果配置");
		spicy_snack_enabled = BUILDER.define("spicy_snack_enabled", true);
		spicy_snack_multi_effects = BUILDER.define("spicy_snack_multi_effects", "[{\"effect\":\"minecraft:strength\",\"duration\":20,\"amplifier\":0}]");
		BUILDER.pop();
		
		BUILDER.push("薯片效果配置");
		chips_1_enabled = BUILDER.define("chips_1_enabled", true);
		chips_1_multi_effects = BUILDER.define("chips_1_multi_effects", "[{\"effect\":\"minecraft:resistance\",\"duration\":30,\"amplifier\":0}]");
		chips_2_enabled = BUILDER.define("chips_2_enabled", true);
		chips_2_multi_effects = BUILDER.define("chips_2_multi_effects", "[{\"effect\":\"minecraft:luck\",\"duration\":20,\"amplifier\":0}]");
		// 薯片效果配置部分需要修改为：
		chips_3_enabled = BUILDER.define("chips_3_enabled", true);
		chips_3_multi_effects = BUILDER.define("chips_3_multi_effects", "[{\"effect\":\"minecraft:speed\",\"duration\":30,\"amplifier\":0}]");
		chips_4_enabled = BUILDER.define("chips_4_enabled", true);
		chips_4_multi_effects = BUILDER.define("chips_4_multi_effects", "[{\"effect\":\"minecraft:fire_resistance\",\"duration\":24,\"amplifier\":0}]");
		BUILDER.pop();
		
		BUILDER.push("巧克力效果配置");
		chocolate_1_enabled = BUILDER.define("chocolate_1_enabled", true);
		chocolate_1_multi_effects = BUILDER.define("chocolate_1_multi_effects", "[{\"effect\":\"minecraft:instant_health\",\"duration\":0,\"amplifier\":0}]");
		chocolate_2_enabled = BUILDER.define("chocolate_2_enabled", true);
		chocolate_2_multi_effects = BUILDER.define("chocolate_2_multi_effects", "[{\"effect\":\"minecraft:absorption\",\"duration\":30,\"amplifier\":0}]");
		BUILDER.pop();
		
		BUILDER.push("苏打水效果配置");
		sodao_1_enabled = BUILDER.define("sodao_1_enabled", true);
		sodao_1_multi_effects = BUILDER.define("sodao_1_multi_effects", "[]");
		sodao_2_enabled = BUILDER.define("sodao_2_enabled", true);
		sodao_2_multi_effects = BUILDER.define("sodao_2_multi_effects", "[{\"effect\":\"minecraft:haste\",\"duration\":30,\"amplifier\":0}]");
		sodao_3_enabled = BUILDER.define("sodao_3_enabled", true);
		sodao_3_multi_effects = BUILDER.define("sodao_3_multi_effects", "[{\"effect\":\"minecraft:resistance\",\"duration\":60,\"amplifier\":0}]");
		sodao_4_enabled = BUILDER.define("sodao_4_enabled", true);
		sodao_4_multi_effects = BUILDER.define("sodao_4_multi_effects", "[{\"effect\":\"minecraft:water_breathing\",\"duration\":120,\"amplifier\":0}]");
		sodao_5_enabled = BUILDER.define("sodao_5_enabled", true);
		sodao_5_multi_effects = BUILDER.define("sodao_5_multi_effects", "[{\"effect\":\"minecraft:fire_resistance\",\"duration\":120,\"amplifier\":0}]");
		sodao_6_enabled = BUILDER.define("sodao_6_enabled", true);
		sodao_6_multi_effects = BUILDER.define("sodao_6_multi_effects", "[{\"effect\":\"minecraft:instant_health\",\"duration\":1,\"amplifier\":0}]");
		BUILDER.pop();
		
		BUILDER.push("水果汁效果配置");
		fruitjuiceo_1_enabled = BUILDER.define("fruitjuiceo_1_enabled", true);
		fruitjuiceo_1_multi_effects = BUILDER.define("fruitjuiceo_1_multi_effects", "[{\"effect\":\"minecraft:regeneration\",\"duration\":15,\"amplifier\":0}]");
		fruitjuiceo_2_enabled = BUILDER.define("fruitjuiceo_2_enabled", true);
		fruitjuiceo_2_multi_effects = BUILDER.define("fruitjuiceo_2_multi_effects", "[{\"effect\":\"minecraft:resistance\",\"duration\":25,\"amplifier\":0}]");
		fruitjuiceo_3_enabled = BUILDER.define("fruitjuiceo_3_enabled", true);
		fruitjuiceo_3_multi_effects = BUILDER.define("fruitjuiceo_3_multi_effects", "[{\"effect\":\"minecraft:instant_health\",\"duration\":0,\"amplifier\":0}]");
		fruitjuiceo_4_enabled = BUILDER.define("fruitjuiceo_4_enabled", true);
		fruitjuiceo_4_multi_effects = BUILDER.define("fruitjuiceo_4_multi_effects", "[{\"effect\":\"minecraft:speed\",\"duration\":30,\"amplifier\":0}]");
		fruitjuiceo_5_enabled = BUILDER.define("fruitjuiceo_5_enabled", true);
		fruitjuiceo_5_multi_effects = BUILDER.define("fruitjuiceo_5_multi_effects", "[{\"effect\":\"minecraft:fire_resistance\",\"duration\":45,\"amplifier\":0}]");
		fruitjuiceo_6_enabled = BUILDER.define("fruitjuiceo_6_enabled", true);
		fruitjuiceo_6_multi_effects = BUILDER.define("fruitjuiceo_6_multi_effects", "[{\"effect\":\"minecraft:haste\",\"duration\":35,\"amplifier\":0}]");
		BUILDER.pop();

		BUILDER.push("冰淇淋效果配置");
		icecream_1_enabled = BUILDER.define("icecream_1_enabled", true);
		icecream_1_multi_effects = BUILDER.define("icecream_1_multi_effects", "[{\"effect\":\"minecraft:regeneration\",\"duration\":15,\"amplifier\":0}]");
		icecream_2_enabled = BUILDER.define("icecream_2_enabled", true);
		icecream_2_multi_effects = BUILDER.define("icecream_2_multi_effects", "[{\"effect\":\"minecraft:resistance\",\"duration\":25,\"amplifier\":0}]");
		icecream_3_enabled = BUILDER.define("icecream_3_enabled", true);
		icecream_3_multi_effects = BUILDER.define("icecream_3_multi_effects", "[{\"effect\":\"minecraft:instant_health\",\"duration\":0,\"amplifier\":0}]");
		icecream_4_enabled = BUILDER.define("icecream_4_enabled", true);
		icecream_4_multi_effects = BUILDER.define("icecream_4_multi_effects", "[{\"effect\":\"minecraft:speed\",\"duration\":30,\"amplifier\":0}]");
		icecream_5_enabled = BUILDER.define("icecream_5_enabled", true);
		icecream_5_multi_effects = BUILDER.define("icecream_5_multi_effects", "[{\"effect\":\"minecraft:fire_resistance\",\"duration\":45,\"amplifier\":0}]");
		BUILDER.pop();

		BUILDER.push("杯面效果配置");
		ocupnoodles_1_enabled = BUILDER.define("ocupnoodles_1_enabled", true);
		ocupnoodles_1_multi_effects = BUILDER.define("ocupnoodles_1_multi_effects", "[]");
		ocupnoodles_2_enabled = BUILDER.define("ocupnoodles_2_enabled", true);
		ocupnoodles_2_multi_effects = BUILDER.define("ocupnoodles_2_multi_effects", "[]");
		ocupnoodles_3_enabled = BUILDER.define("ocupnoodles_3_enabled", true);
		ocupnoodles_3_multi_effects = BUILDER.define("ocupnoodles_3_multi_effects", "[]");
		ocupnoodles_4_enabled = BUILDER.define("ocupnoodles_4_enabled", true);
		ocupnoodles_4_multi_effects = BUILDER.define("ocupnoodles_4_multi_effects", "[]");
		BUILDER.pop();

		SPEC = BUILDER.build();
	}
}
