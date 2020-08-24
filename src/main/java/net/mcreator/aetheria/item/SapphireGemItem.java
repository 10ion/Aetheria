
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class SapphireGemItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:sapphire")
	public static final Item block = null;

	public SapphireGemItem(AetheriaModElements instance) {
		super(instance, 228);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64));
			setRegistryName("sapphire");
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
