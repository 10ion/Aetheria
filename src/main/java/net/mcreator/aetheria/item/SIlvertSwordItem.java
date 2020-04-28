
package net.mcreator.aetheria.item;

@AetheriaElements.ModElement.Tag
public class SIlvertSwordItem extends AetheriaElements.ModElement {

	@ObjectHolder("aetheria:silversword")
	public static final Item block = null;

	public SIlvertSwordItem(AetheriaElements instance) {
		super(instance, 441);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 50;
			}

			public float getEfficiency() {
				return 3f;
			}

			public float getAttackDamage() {
				return 3f;
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
		}, 3, -2.8f, new Item.Properties().group(AetheriaWeaponsItemGroup.tab)) {

		}.setRegistryName("silversword"));
	}

}
