
package net.mcreator.aetheria.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.aetheria.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class ApplePieItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:apple_pie")
	public static final Item block = null;
	public ApplePieItem(AetheriaModElements instance) {
		super(instance, 521);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1).food((new Food.Builder()).hunger(14).saturation(1.6f).build()));
			setRegistryName("apple_pie");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 40;
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}
	}
}
