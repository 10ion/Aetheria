
package net.mod.aetheria.item;

import net.mod.aetheria.itemgroup.AetheriaFoodItemsItemGroup;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

@AetheriaModElements.ModElement.Tag
public class FireberryItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:fireberry")
	public static final Item block = null;
	public FireberryItem(AetheriaModElements instance) {
		super(instance, 167);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(AetheriaFoodItemsItemGroup.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(1).saturation(0.3f).setAlwaysEdible().build()));
			setRegistryName("fireberry");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}
	}
}
