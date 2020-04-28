
package net.mcreator.aetheria.item;

@AetheriaElements.ModElement.Tag
public class ObamiumItem extends AetheriaElements.ModElement {

	@ObjectHolder("aetheria:obamium")
	public static final Item block = null;

	public ObamiumItem(AetheriaElements instance) {
		super(instance, 440);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AetheriaMaterialsItemGroup.tab).maxStackSize(64));
			setRegistryName("obamium");
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
			return 2F;
		}

	}

}
