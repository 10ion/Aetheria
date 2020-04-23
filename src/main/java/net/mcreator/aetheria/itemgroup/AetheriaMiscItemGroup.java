
package net.mcreator.aetheria.itemgroup;

@AetheriaElements.ModElement.Tag
public class AetheriaMiscItemGroup extends AetheriaElements.ModElement {

	public AetheriaMiscItemGroup(AetheriaElements instance) {
		super(instance, 400);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaetheriamisc") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(GemwroughtGemItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
