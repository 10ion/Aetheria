
package net.aetheria.mod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.aetheria.mod.block.AeonForgeBlock;
import net.aetheria.mod.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class AetheriaCraftingItemGroup extends AetheriaModElements.ModElement {
	public AetheriaCraftingItemGroup(AetheriaModElements instance) {
		super(instance, 399);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaetheriacrafting") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(AeonForgeBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
