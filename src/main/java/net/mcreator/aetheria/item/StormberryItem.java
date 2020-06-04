
package net.mcreator.aetheria.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.aetheria.itemgroup.AetheriaFoodItemsItemGroup;
import net.mcreator.aetheria.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class StormberryItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:stormberry")
	public static final Item block = null;
	public StormberryItem(AetheriaModElements instance) {
		super(instance, 91);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(AetheriaFoodItemsItemGroup.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(1).saturation(0.3f).setAlwaysEdible().build()));
			setRegistryName("stormberry");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}
	}
}
