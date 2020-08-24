
package net.mod.aetheria.itemgroup;

import net.mod.aetheria.item.PizzasliceItem;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@AetheriaModElements.ModElement.Tag
public class AetheriaFoodItemsItemGroup extends AetheriaModElements.ModElement {
	public AetheriaFoodItemsItemGroup(AetheriaModElements instance) {
		super(instance, 369);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaetheriafooditems") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(PizzasliceItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
