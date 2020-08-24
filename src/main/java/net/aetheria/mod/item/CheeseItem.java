
package net.aetheria.mod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.aetheria.mod.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class CheeseItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:cheese")
	public static final Item block = null;
	public CheeseItem(AetheriaModElements instance) {
		super(instance, 520);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(16).food((new Food.Builder()).hunger(3).saturation(0.6f).build()));
			setRegistryName("cheese");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}
	}
}
