
package yum.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class YumyumItem extends Item {
	public YumyumItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
