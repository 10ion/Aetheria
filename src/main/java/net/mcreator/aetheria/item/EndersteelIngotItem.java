
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class EndersteelIngotItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:endersteel_ingot")
	public static final Item block = null;

	public EndersteelIngotItem(AetheriaModElements instance) {
		super(instance, 598);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AetheriaMaterialsItemGroup.tab).maxStackSize(64));
			setRegistryName("endersteel_ingot");
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
