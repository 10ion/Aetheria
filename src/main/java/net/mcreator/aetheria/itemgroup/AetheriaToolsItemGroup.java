
package net.mcreator.aetheria.itemgroup;

@AetheriaElements.ModElement.Tag
public class AetheriaToolsItemGroup extends AetheriaElements.ModElement {

	public AetheriaToolsItemGroup(AetheriaElements instance) {
		super(instance, 401);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaetheriatools") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(EndersteelToolsPickaxeItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
