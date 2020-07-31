
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class TungstenIngotItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:tungsten_ingot")
	public static final Item block = null;

	public TungstenIngotItem(AetheriaModElements instance) {
		super(instance, 628);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AetheriaMaterialsItemGroup.tab).maxStackSize(64));
			setRegistryName("tungsten_ingot");
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
