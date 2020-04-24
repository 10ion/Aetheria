
package net.mcreator.aetheria.itemgroup;

@AetheriaElements.ModElement.Tag
public class AetheriaFoodItemsItemGroup extends AetheriaElements.ModElement {

	public AetheriaFoodItemsItemGroup(AetheriaElements instance) {
		super(instance, 402);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaetheriafooditems") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(PizzasliceItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
