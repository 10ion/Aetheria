
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class GrassStewItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:grass_stew")
	public static final Item block = null;

	public GrassStewItem(AetheriaModElements instance) {
		super(instance, 523);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1).food((new Food.Builder()).hunger(4).saturation(0.2f)

					.build()));
			setRegistryName("grass_stew");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

	}

}
