
package net.mcreator.aetheria.item;

@AetheriaElements.ModElement.Tag
public class SIlvertAxeItem extends AetheriaElements.ModElement {

	@ObjectHolder("aetheria:silveraxe")
	public static final Item block = null;

	public SIlvertAxeItem(AetheriaElements instance) {
		super(instance, 440);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 50;
			}

			public float getEfficiency() {
				return 3f;
			}

			public float getAttackDamage() {
				return 2f;
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

		}.setRegistryName("silveraxe"));
	}

}
