
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class BronzeIngotItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:bronze_ingot")
	public static final Item block = null;

	public BronzeIngotItem(AetheriaModElements instance) {
		super(instance, 622);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AetheriaMaterialsItemGroup.tab).maxStackSize(64));
			setRegistryName("bronze_ingot");
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
