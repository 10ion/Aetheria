
package net.mod.aetheria.item;

import net.mod.aetheria.itemgroup.AetheriaMaterialsItemGroup;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@AetheriaModElements.ModElement.Tag
public class BismuthBronzeIngotItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:bismuth_bronze_ingot")
	public static final Item block = null;
	public BismuthBronzeIngotItem(AetheriaModElements instance) {
		super(instance, 22);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(AetheriaMaterialsItemGroup.tab).maxStackSize(64));
			setRegistryName("bismuth_bronze_ingot");
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
