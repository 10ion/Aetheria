
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class TinIngotItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:tin_ingot")
	public static final Item block = null;

	public TinIngotItem(AetheriaModElements instance) {
		super(instance, 645);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AetheriaMaterialsItemGroup.tab).maxStackSize(64));
			setRegistryName("tin_ingot");
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
