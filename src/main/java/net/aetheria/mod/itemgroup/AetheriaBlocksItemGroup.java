
package net.aetheria.mod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.aetheria.mod.block.BlueleafBlock;
import net.aetheria.mod.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class AetheriaBlocksItemGroup extends AetheriaModElements.ModElement {
	public AetheriaBlocksItemGroup(AetheriaModElements instance) {
		super(instance, 401);
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
