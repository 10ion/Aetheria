
package net.aetheria.mod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Blocks;

import net.aetheria.mod.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class AetheriaEntitiesItemGroup extends AetheriaModElements.ModElement {
	public AetheriaEntitiesItemGroup(AetheriaModElements instance) {
		super(instance, 429);
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
