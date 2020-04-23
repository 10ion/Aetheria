
package net.mcreator.aetheria.itemgroup;

@AetheriaElements.ModElement.Tag
public class AetheriaCraftingItemGroup extends AetheriaElements.ModElement {

	public AetheriaCraftingItemGroup(AetheriaElements instance) {
		super(instance, 404);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaetheriacrafting") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(AeonForgeBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
