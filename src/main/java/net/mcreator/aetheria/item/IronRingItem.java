
package net.mcreator.aetheria.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.aetheria.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class IronRingItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:iron_ring")
	public static final Item block = null;
	public IronRingItem(AetheriaModElements instance) {
		super(instance, 573);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1));
			setRegistryName("iron_ring");
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
