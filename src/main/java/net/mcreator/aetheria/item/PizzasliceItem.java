
package net.mcreator.aetheria.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.aetheria.itemgroup.AetheriaFoodItemsItemGroup;
import net.mcreator.aetheria.AetheriaElements;

@AetheriaElements.ModElement.Tag
public class PizzasliceItem extends AetheriaElements.ModElement {
	@ObjectHolder("aetheria:pizzaslice")
	public static final Item block = null;
	public PizzasliceItem(AetheriaElements instance) {
		super(instance, 79);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(AetheriaFoodItemsItemGroup.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(8).saturation(0.3f).setAlwaysEdible().build()));
			setRegistryName("pizzaslice");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}
	}
}
