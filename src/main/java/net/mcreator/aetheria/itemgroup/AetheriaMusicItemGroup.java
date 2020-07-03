
package net.mcreator.aetheria.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.aetheria.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class AetheriaMusicItemGroup extends AetheriaModElements.ModElement {
	public AetheriaMusicItemGroup(AetheriaModElements instance) {
		super(instance, 422);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaetheriamusic") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.MUSIC_DISC_CHIRP, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
