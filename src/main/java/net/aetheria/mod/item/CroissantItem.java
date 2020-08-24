
package net.aetheria.mod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.aetheria.mod.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class CroissantItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:croissant")
	public static final Item block = null;
	public CroissantItem(AetheriaModElements instance) {
		super(instance, 526);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).food((new Food.Builder()).hunger(8).saturation(1.5f).build()));
			setRegistryName("croissant");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}
	}
}
