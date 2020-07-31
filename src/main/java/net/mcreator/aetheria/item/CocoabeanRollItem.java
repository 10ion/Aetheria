
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class CocoabeanRollItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:cocoabean_roll")
	public static final Item block = null;

	public CocoabeanRollItem(AetheriaModElements instance) {
		super(instance, 531);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).food((new Food.Builder()).hunger(7).saturation(1.3f)

					.build()));
			setRegistryName("cocoabean_roll");
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
