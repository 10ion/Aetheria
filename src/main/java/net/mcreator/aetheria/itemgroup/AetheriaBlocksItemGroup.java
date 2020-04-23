
package net.mcreator.aetheria.itemgroup;

@AetheriaElements.ModElement.Tag
public class AetheriaBlocksItemGroup extends AetheriaElements.ModElement {

	public AetheriaBlocksItemGroup(AetheriaElements instance) {
		super(instance, 403);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaetheriablocks") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(BlueleafBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
