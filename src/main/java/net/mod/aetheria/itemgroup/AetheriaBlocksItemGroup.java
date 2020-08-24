
package net.mod.aetheria.itemgroup;

import net.mod.aetheria.block.BlueleafBlock;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@AetheriaModElements.ModElement.Tag
public class AetheriaBlocksItemGroup extends AetheriaModElements.ModElement {
	public AetheriaBlocksItemGroup(AetheriaModElements instance) {
		super(instance, 368);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaetheriablocks") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(BlueleafBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
