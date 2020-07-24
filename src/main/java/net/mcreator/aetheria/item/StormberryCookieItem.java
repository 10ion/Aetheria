
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class StormberryCookieItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:stormberry_cookie")
	public static final Item block = null;

	public StormberryCookieItem(AetheriaModElements instance) {
		super(instance, 533);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).food((new Food.Builder()).hunger(4).saturation(0.7f)

					.build()));
			setRegistryName("stormberry_cookie");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 26;
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);

				StormberryCookieFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}

	}

}
