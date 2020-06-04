
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class GemwroughtGemItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:gemwroughtgem")
	public static final Item block = null;

	public GemwroughtGemItem(AetheriaModElements instance) {
		super(instance, 152);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AetheriaMiscItemGroup.tab).maxStackSize(64));
			setRegistryName("gemwroughtgem");
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
