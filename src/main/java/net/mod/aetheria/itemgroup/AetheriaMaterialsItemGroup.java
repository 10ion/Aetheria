
package net.mod.aetheria.itemgroup;

import net.mod.aetheria.item.RedsteelingotItem;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@AetheriaModElements.ModElement.Tag
public class AetheriaMaterialsItemGroup extends AetheriaModElements.ModElement {
	public AetheriaMaterialsItemGroup(AetheriaModElements instance) {
		super(instance, 365);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaetheriamaterials") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(RedsteelingotItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
