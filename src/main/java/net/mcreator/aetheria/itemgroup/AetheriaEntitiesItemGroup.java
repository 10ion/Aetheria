
package net.mcreator.aetheria.itemgroup;

@AetheriaElements.ModElement.Tag
public class AetheriaEntitiesItemGroup extends AetheriaElements.ModElement {

	public AetheriaEntitiesItemGroup(AetheriaElements instance) {
		super(instance, 429);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaetheriaentities") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.SPAWNER, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
