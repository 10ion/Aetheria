
package net.mcreator.aetheria.item;

@AetheriaElements.ModElement.Tag
public class IridiumIngotItem extends AetheriaElements.ModElement {

	@ObjectHolder("aetheria:iridiumingot")
	public static final Item block = null;

	public IridiumIngotItem(AetheriaElements instance) {
		super(instance, 41);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AetheriaMaterialsItemGroup.tab).maxStackSize(64));
			setRegistryName("iridiumingot");
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
