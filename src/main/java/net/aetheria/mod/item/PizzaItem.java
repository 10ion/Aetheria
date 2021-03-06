
package net.aetheria.mod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.aetheria.mod.itemgroup.AetheriaFoodItemsItemGroup;
import net.aetheria.mod.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class PizzaItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:pizza")
	public static final Item block = null;
	public PizzaItem(AetheriaModElements instance) {
		super(instance, 96);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(AetheriaFoodItemsItemGroup.tab).maxStackSize(64));
			setRegistryName("pizza");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
