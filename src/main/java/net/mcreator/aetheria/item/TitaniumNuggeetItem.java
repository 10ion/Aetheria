
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class TitaniumNuggeetItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:titanium_nuggeet")
	public static final Item block = null;

	public TitaniumNuggeetItem(AetheriaModElements instance) {
		super(instance, 634);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AetheriaMaterialsItemGroup.tab).maxStackSize(64));
			setRegistryName("titanium_nuggeet");
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
		public void onCreated(ItemStack itemstack, World world, PlayerEntity entity) {
			super.onCreated(itemstack, world, entity);
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);

				TitaniumIItemIsCraftedsmeltedProcedure.executeProcedure($_dependencies);
			}
		}

	}

}
