
package net.aetheria.mod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.aetheria.mod.itemgroup.AetheriaMaterialsItemGroup;
import net.aetheria.mod.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class RedBrassIngotItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:red_brass_ingot")
	public static final Item block = null;
	public RedBrassIngotItem(AetheriaModElements instance) {
		super(instance, 38);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(AetheriaMaterialsItemGroup.tab).maxStackSize(64));
			setRegistryName("red_brass_ingot");
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
