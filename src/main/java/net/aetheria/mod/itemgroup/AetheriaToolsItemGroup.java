
package net.aetheria.mod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.aetheria.mod.item.EndersteelToolsPickaxeItem;
import net.aetheria.mod.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class AetheriaToolsItemGroup extends AetheriaModElements.ModElement {
	public AetheriaToolsItemGroup(AetheriaModElements instance) {
		super(instance, 396);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaetheriatools") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(EndersteelToolsPickaxeItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
