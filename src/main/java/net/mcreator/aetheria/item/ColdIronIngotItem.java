
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class ColdIronIngotItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:cold_iron_ingot")
	public static final Item block = null;

	public ColdIronIngotItem(AetheriaModElements instance) {
		super(instance, 604);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AetheriaMaterialsItemGroup.tab).maxStackSize(64));
			setRegistryName("cold_iron_ingot");
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
