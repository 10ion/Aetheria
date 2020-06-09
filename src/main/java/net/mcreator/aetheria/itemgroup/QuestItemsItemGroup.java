
package net.mcreator.aetheria.itemgroup;

@AetheriaModElements.ModElement.Tag
public class QuestItemsItemGroup extends AetheriaModElements.ModElement {

	public QuestItemsItemGroup(AetheriaModElements instance) {
		super(instance, 456);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabquest_items") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(GlowmossItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
