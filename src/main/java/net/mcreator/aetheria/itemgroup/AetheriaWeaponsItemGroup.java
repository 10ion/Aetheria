
package net.mcreator.aetheria.itemgroup;

@AetheriaElements.ModElement.Tag
public class AetheriaWeaponsItemGroup extends AetheriaElements.ModElement {

	public AetheriaWeaponsItemGroup(AetheriaElements instance) {
		super(instance, 403);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaetheriaweapons") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(GemwroughtSwordItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
