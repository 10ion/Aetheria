
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class CroissantItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:croissant")
	public static final Item block = null;

	public CroissantItem(AetheriaModElements instance) {
		super(instance, 526);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).food((new Food.Builder()).hunger(8).saturation(1.5f)

					.build()));
			setRegistryName("croissant");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

	}

}
