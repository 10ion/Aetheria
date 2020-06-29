
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class GlowshroomItemItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:glowshroom_item")
	public static final Item block = null;

	public GlowshroomItemItem(AetheriaModElements instance) {
		super(instance, 471);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64));
			setRegistryName("glowshroom_item");
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

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

	}

}
