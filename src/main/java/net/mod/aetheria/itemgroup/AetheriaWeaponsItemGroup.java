
package net.mod.aetheria.itemgroup;

import net.mod.aetheria.item.EndersteelToolsSwordItem;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@AetheriaModElements.ModElement.Tag
public class AetheriaWeaponsItemGroup extends AetheriaModElements.ModElement {
	public AetheriaWeaponsItemGroup(AetheriaModElements instance) {
		super(instance, 370);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaetheriaweapons") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(EndersteelToolsSwordItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
