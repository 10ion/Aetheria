
package net.mcreator.aetheria.item;

@AetheriaElements.ModElement.Tag
public class NIckelIngotItem extends AetheriaElements.ModElement {

	@ObjectHolder("aetheria:nickelingot")
	public static final Item block = null;

	public NIckelIngotItem(AetheriaElements instance) {
		super(instance, 40);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AetheriaMaterialsItemGroup.tab).maxStackSize(64));
			setRegistryName("nickelingot");
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
