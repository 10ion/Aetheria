
package net.mod.aetheria.item;

import net.mod.aetheria.itemgroup.AetheriaFoodItemsItemGroup;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

@AetheriaModElements.ModElement.Tag
public class PizzasliceItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:pizza_slice")
	public static final Item block = null;
	public PizzasliceItem(AetheriaModElements instance) {
		super(instance, 171);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(AetheriaFoodItemsItemGroup.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(8).saturation(0.3f).setAlwaysEdible().build()));
			setRegistryName("pizza_slice");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}
	}
}
