
package net.mcreator.aetheria.itemgroup;

@AetheriaElements.ModElement.Tag
public class AetheriaMaterialsItemGroup extends AetheriaElements.ModElement {

	public AetheriaMaterialsItemGroup(AetheriaElements instance) {
		super(instance, 399);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaetheriamaterials") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(RedsteelingotItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
