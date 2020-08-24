
package net.mod.aetheria.item;

import net.mod.aetheria.itemgroup.QuestItemsItemGroup;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@AetheriaModElements.ModElement.Tag
public class GlowmossItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:glowmoss")
	public static final Item block = null;
	public GlowmossItem(AetheriaModElements instance) {
		super(instance, 235);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(QuestItemsItemGroup.tab).maxStackSize(64));
			setRegistryName("glowmoss");
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
