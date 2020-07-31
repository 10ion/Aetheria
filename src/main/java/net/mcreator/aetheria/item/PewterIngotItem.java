
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class PewterIngotItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:pewter_ingot")
	public static final Item block = null;

	public PewterIngotItem(AetheriaModElements instance) {
		super(instance, 616);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AetheriaMiscItemGroup.tab).maxStackSize(64));
			setRegistryName("pewter_ingot");
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
