
package net.mod.aetheria.itemgroup;

import net.mod.aetheria.item.GemwroughtGemItem;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@AetheriaModElements.ModElement.Tag
public class AetheriaMiscItemGroup extends AetheriaModElements.ModElement {
	public AetheriaMiscItemGroup(AetheriaModElements instance) {
		super(instance, 366);
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
