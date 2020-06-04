
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class SpaceBattleItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:spacebattle")
	public static final Item block = null;

	public SpaceBattleItem(AetheriaModElements instance) {
		super(instance, 452);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, AetheriaModElements.sounds.get(new ResourceLocation("aetheria:space-battle")),
					new Item.Properties().group(AetheriaMusicItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("spacebattle");
		}

	}

}
