
package net.mcreator.aetheria.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.aetheria.item.RedsteelingotItem;
import net.mcreator.aetheria.AetheriaElements;

@AetheriaElements.ModElement.Tag
public class AetheriaMaterialsItemGroup extends AetheriaElements.ModElement {
	public AetheriaMaterialsItemGroup(AetheriaElements instance) {
		super(instance, 398);
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