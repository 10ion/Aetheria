
package net.aetheria.mod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.aetheria.mod.item.GemwroughtGemItem;
import net.aetheria.mod.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class AetheriaMiscItemGroup extends AetheriaModElements.ModElement {
	public AetheriaMiscItemGroup(AetheriaModElements instance) {
		super(instance, 399);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaetheriamisc") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(GemwroughtGemItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
