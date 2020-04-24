
package net.mcreator.aetheria.itemgroup;

@AetheriaElements.ModElement.Tag
public class AetheriaArmorItemGroup extends AetheriaElements.ModElement {

	public AetheriaArmorItemGroup(AetheriaElements instance) {
		super(instance, 400);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaetheriaarmor") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ObsidianArmorItem.body, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
