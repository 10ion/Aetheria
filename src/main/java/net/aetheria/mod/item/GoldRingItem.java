
package net.aetheria.mod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.aetheria.mod.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class GoldRingItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:gold_ring")
	public static final Item block = null;
	public GoldRingItem(AetheriaModElements instance) {
		super(instance, 529);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1));
			setRegistryName("gold_ring");
		}

		@Override
		public int getItemEnchantability() {
			return 10;
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
