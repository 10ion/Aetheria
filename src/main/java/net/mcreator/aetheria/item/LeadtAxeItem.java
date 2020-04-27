
package net.mcreator.aetheria.item;

@AetheriaElements.ModElement.Tag
public class LeadtAxeItem extends AetheriaElements.ModElement {

	@ObjectHolder("aetheria:leadaxe")
	public static final Item block = null;

	public LeadtAxeItem(AetheriaElements instance) {
		super(instance, 429);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 40;
			}

			public float getEfficiency() {
				return 2f;
			}

			public float getAttackDamage() {
				return 1f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3.4f, new Item.Properties().group(AetheriaToolsItemGroup.tab)) {

		}.setRegistryName("leadaxe"));
	}

}
