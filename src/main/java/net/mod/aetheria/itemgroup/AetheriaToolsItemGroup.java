
package net.mod.aetheria.itemgroup;

import net.mod.aetheria.item.EndersteelToolsPickaxeItem;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@AetheriaModElements.ModElement.Tag
public class AetheriaToolsItemGroup extends AetheriaModElements.ModElement {
	public AetheriaToolsItemGroup(AetheriaModElements instance) {
		super(instance, 363);
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
