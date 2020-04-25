
package net.mcreator.aetheria.itemgroup;

@AetheriaElements.ModElement.Tag
public class AetheriaMusicItemGroup extends AetheriaElements.ModElement {

	public AetheriaMusicItemGroup(AetheriaElements instance) {
		super(instance, 422);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaetheriamusic") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(RickrollItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
