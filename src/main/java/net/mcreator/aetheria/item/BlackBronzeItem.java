
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class BlackBronzeItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:blackbronze")
	public static final Item block = null;

	public BlackBronzeItem(AetheriaModElements instance) {
		super(instance, 27);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AetheriaMaterialsItemGroup.tab).maxStackSize(64));
			setRegistryName("blackbronze");
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
