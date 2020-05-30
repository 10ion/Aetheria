
package net.mcreator.aetheria.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.aetheria.item.GemwroughtSwordItem;
import net.mcreator.aetheria.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class AetheriaWeaponsItemGroup extends AetheriaModElements.ModElement {
	public AetheriaWeaponsItemGroup(AetheriaModElements instance) {
		super(instance, 403);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaetheriaweapons") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(GemwroughtSwordItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
