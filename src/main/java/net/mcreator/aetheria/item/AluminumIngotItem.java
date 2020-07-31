
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class AluminumIngotItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:aluminum_ingot")
	public static final Item block = null;

	public AluminumIngotItem(AetheriaModElements instance) {
		super(instance, 644);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AetheriaMaterialsItemGroup.tab).maxStackSize(64));
			setRegistryName("aluminum_ingot");
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
