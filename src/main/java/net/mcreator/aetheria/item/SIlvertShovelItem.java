
package net.mcreator.aetheria.item;

@AetheriaElements.ModElement.Tag
public class SIlvertShovelItem extends AetheriaElements.ModElement {

	@ObjectHolder("aetheria:silvershovel")
	public static final Item block = null;

	public SIlvertShovelItem(AetheriaElements instance) {
		super(instance, 442);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 50;
			}

			public float getEfficiency() {
				return 3f;
			}

			public float getAttackDamage() {
				return -1f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 30;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -2.8f, new Item.Properties().group(AetheriaToolsItemGroup.tab)) {

		}.setRegistryName("silvershovel"));
	}

}
