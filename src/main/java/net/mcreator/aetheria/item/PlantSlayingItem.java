
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class PlantSlayingItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:plantslaying")
	public static final Item block = null;

	public PlantSlayingItem(AetheriaModElements instance) {
		super(instance, 461);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AetheriaWeaponsItemGroup.tab).maxStackSize(1));
			setRegistryName("plantslaying");
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

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("testing"));
		}

	}

}
