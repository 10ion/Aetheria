
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class StormberryCakeItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:stormberry_cake")
	public static final Item block = null;

	public StormberryCakeItem(AetheriaModElements instance) {
		super(instance, 536);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).food((new Food.Builder()).hunger(10).saturation(0.3f)

					.build()));
			setRegistryName("stormberry_cake");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

	}

}
