
package net.mod.aetheria.itemgroup;

import net.mod.aetheria.item.GlowmossItem;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@AetheriaModElements.ModElement.Tag
public class QuestItemsItemGroup extends AetheriaModElements.ModElement {
	public QuestItemsItemGroup(AetheriaModElements instance) {
		super(instance, 394);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabquest_items") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(GlowmossItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
