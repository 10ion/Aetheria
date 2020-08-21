
package net.mod.aetheria.itemgroup;

import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Blocks;

@AetheriaModElements.ModElement.Tag
public class AetheriaEntitiesItemGroup extends AetheriaModElements.ModElement {
	public AetheriaEntitiesItemGroup(AetheriaModElements instance) {
		super(instance, 390);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaetheriaentities") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.SPAWNER, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
