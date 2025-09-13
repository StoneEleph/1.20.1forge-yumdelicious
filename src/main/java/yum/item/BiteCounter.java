package yum.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.Objects;

//提供食物使用次数管理功能，支持自定义标签和最大使用次数
public class BiteCounter {
    private static final Logger LOGGER = LogManager.getLogger();
    
    // 配置常量
    private static final String DEFAULT_BITES_TAG = "yum:bites";
    private static final int DEFAULT_MAX_USES = 3;
    private static final int MAX_USES_LIMIT = 1000;
    private static final String VALID_TAG_PATTERN = "[a-zA-Z0-9_:-]+";
    
    // 序列化键
    private static final String SERIALIZE_TAG_KEY = "BiteTag";
    private static final String SERIALIZE_MAX_USES_KEY = "MaxUses";
    
    // 实例配置
    private final String bitesTag;
    private final int maxUses;
    
    // 使用默认配置创建BiteCounter实例
    public BiteCounter() {
        this(DEFAULT_BITES_TAG, DEFAULT_MAX_USES);
    }
    
    //用自定义配置创建BiteCounter实例
    // @param bitesTag NBT标签名称，不能为空或无效格式
    // @param maxUses 最大使用次数，必须在1-1000之间
    public BiteCounter(String bitesTag, int maxUses) {
        validateParameters(bitesTag, maxUses);
        this.bitesTag = normalizeTagName(bitesTag);
        this.maxUses = maxUses;
    }
    
    // 参数验证和规范化
    private void validateParameters(String tag, int uses) {
        if (uses <= 0 || uses > MAX_USES_LIMIT) {
            String errorMsg = String.format("最大使用次数必须在1-%d之间，提供值: %d", MAX_USES_LIMIT, uses);
            LOGGER.error(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }
        
        if (tag == null || tag.isEmpty() || !tag.matches(VALID_TAG_PATTERN)) {
            LOGGER.warn("提供的标签名称无效，使用默认值: {}", DEFAULT_BITES_TAG);
        }
    }
    
    private String normalizeTagName(String tag) {
        return (tag != null && !tag.isEmpty() && tag.matches(VALID_TAG_PATTERN)) 
                ? tag : DEFAULT_BITES_TAG;
    }
    
    // 核心功能方法
    // 增加使用次数（包含溢出保护）
    // @param itemStack 目标物品堆栈
    // @return 增加后的使用次数
    public int incrementBites(ItemStack itemStack) {
        Objects.requireNonNull(itemStack, "物品堆栈不能为空");
        
        CompoundTag nbt = itemStack.getOrCreateTag();
        int currentBites = getBitesFromTag(nbt);
        
        // 溢出保护
        if (currentBites < 0 || currentBites >= Integer.MAX_VALUE) {
            LOGGER.warn("使用次数值异常: {}", currentBites);
            return currentBites;
        }
        
        int newBites = currentBites + 1;
        nbt.putInt(bitesTag, newBites);
        return newBites;
    }
    
    // 获取当前使用次数
    // @param itemStack 目标物品堆栈
    // @return 当前使用次数
    public int getCurrentBites(ItemStack itemStack) {
        Objects.requireNonNull(itemStack, "物品堆栈不能为空");
        return itemStack.hasTag() ? getBitesFromTag(itemStack.getTag()) : 0;
    }
    
    // 内部辅助方法 - 从CompoundTag获取使用次数
    private int getBitesFromTag(CompoundTag nbt) {
        return (nbt != null && nbt.contains(bitesTag, Tag.TAG_INT)) 
                ? nbt.getInt(bitesTag) : 0;
    }
    
    // 检查是否已达到最大使用次数
    // @param itemStack 目标物品堆栈
    // @return 是否已达到最大使用次数
    public boolean isMaxUsesReached(ItemStack itemStack) {
        return getCurrentBites(itemStack) >= maxUses;
    }
    
    // 获取剩余使用次数
    // @param itemStack 目标物品堆栈
    // @return 剩余使用次数（非负）
    public int getRemainingUses(ItemStack itemStack) {
        Objects.requireNonNull(itemStack, "物品堆栈不能为空");
        
        int bites = 0;
        if (itemStack.hasTag()) {
            bites = getBitesFromTag(itemStack.getTag());
        }
        
        return Math.max(0, maxUses - bites);
    }
    
    // 获取使用百分比
    // @param itemStack 目标物品堆栈
    // @return 使用百分比 (0.0 - 1.0)
    public float getUsagePercentage(ItemStack itemStack) {
        int bites = getCurrentBites(itemStack);
        return Math.min(1.0f, (float) bites / maxUses);
    }
    
    // 检查是否可以使用
    // @param itemStack 目标物品堆栈
    // @return 是否还有剩余使用次数
    public boolean canUse(ItemStack itemStack) {
        return getRemainingUses(itemStack) > 0;
    }
    
    // 带检查的使用次数增加
    // @param itemStack 目标物品堆栈
    // @return 是否成功增加使用次数
    public boolean useWithCheck(ItemStack itemStack) {
        if (!canUse(itemStack)) {
            return false;
        }
        
        incrementBites(itemStack);
        return true;
    }
    
    // UI相关方法
    // 添加使用次数提示文本到物品提示信息
    // @param itemStack 目标物品堆栈
    // @param tooltip 提示信息列表
    // @param displayName 显示名称（如"食用次数"、"咬食次数"）
    // @param maxUses 最大使用次数
    public void appendBiteTooltip(ItemStack itemStack, List<Component> tooltip, String displayName, int maxUses) {
        Objects.requireNonNull(itemStack, "物品堆栈不能为空");
        Objects.requireNonNull(tooltip, "提示信息列表不能为空");
        
        int bites = getCurrentBites(itemStack);
        int remaining = Math.max(0, maxUses - bites);
        
        String status = String.format("%s: %d/%d", displayName, bites, maxUses);
        ChatFormatting color = remaining > 0 ? ChatFormatting.BLUE : ChatFormatting.RED;
        
        tooltip.add(Component.literal(status).withStyle(color));
    }
    
    // 重置使用次数
	// @param itemStack 目标物品堆栈
	public void resetBites(ItemStack itemStack) {
		Objects.requireNonNull(itemStack, "物品堆栈不能为空");
		itemStack.getOrCreateTag().putInt(bitesTag, 0);
	}
	
	// 处理堆叠物品的使用次数重置
	// @param itemStack 目标物品堆栈
	public void handleStackReset(ItemStack itemStack) {
		Objects.requireNonNull(itemStack, "物品堆栈不能为空");
		if (isMaxUsesReached(itemStack) && itemStack.getCount() > 0) {
			resetBites(itemStack);
		}
	}
    
    // 配置序列化和反序列化
    // 序列化配置
    // @return 包含配置的CompoundTag
    public CompoundTag serialize() {
        CompoundTag tag = new CompoundTag();
        tag.putString(SERIALIZE_TAG_KEY, bitesTag);
        tag.putInt(SERIALIZE_MAX_USES_KEY, maxUses);
        return tag;
    }
    
    // 从CompoundTag反序列化配置
    // @param tag 包含配置的CompoundTag
    // @return BiteCounter实例
    public static BiteCounter deserialize(CompoundTag tag) {
        Objects.requireNonNull(tag, "配置标签不能为空");
        
        String biteTag = tag.getString(SERIALIZE_TAG_KEY);
        int maxUses = tag.getInt(SERIALIZE_MAX_USES_KEY);
        
        return new BiteCounter(biteTag, maxUses);
    }
    
    // 工具方法
    // 创建配置相同的BiteCounter实例
    // @return 新的BiteCounter实例
    public BiteCounter copy() {
        return new BiteCounter(this.bitesTag, this.maxUses);
    }
    
    // 验证配置是否有效
    // @return 配置是否有效
    public boolean isValid() {
        return maxUses > 0 && maxUses <= MAX_USES_LIMIT && 
               bitesTag != null && !bitesTag.isEmpty() && 
               bitesTag.matches(VALID_TAG_PATTERN);
    }
    
    // Getter方法
    public String getBitesTag() {
        return bitesTag;
    }
    
    public int getMaxUses() {
        return maxUses;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        BiteCounter that = (BiteCounter) obj;
        return maxUses == that.maxUses && Objects.equals(bitesTag, that.bitesTag);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(bitesTag, maxUses);
    }
    
    @Override
    public String toString() {
        return String.format("BiteCounter{tag='%s', maxUses=%d}", bitesTag, maxUses);
    }
}