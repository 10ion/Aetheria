
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class MagnegoldItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:magnegold")
	public static final Item block = null;

	public MagnegoldItem(AetheriaModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AetheriaMaterialsItemGroup.tab).maxStackSize(64));
			setRegistryName("magnegold");
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
