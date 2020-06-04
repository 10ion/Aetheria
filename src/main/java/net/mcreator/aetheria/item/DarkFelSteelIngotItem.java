
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class DarkFelSteelIngotItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:darkfelsteelingot")
	public static final Item block = null;

	public DarkFelSteelIngotItem(AetheriaModElements instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AetheriaMaterialsItemGroup.tab).maxStackSize(64));
			setRegistryName("darkfelsteelingot");
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
