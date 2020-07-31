
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class ParasolMushroomItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:parasol_mushroom")
	public static final Item block = null;

	public ParasolMushroomItem(AetheriaModElements instance) {
		super(instance, 722);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(AetheriaFoodItemsItemGroup.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(3).saturation(0.4f).setAlwaysEdible()

							.build()));
			setRegistryName("parasol_mushroom");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 20;
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

	}

}
