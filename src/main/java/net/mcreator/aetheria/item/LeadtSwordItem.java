
package net.mcreator.aetheria.item;

@AetheriaElements.ModElement.Tag
public class LeadtSwordItem extends AetheriaElements.ModElement {

	@ObjectHolder("aetheria:leadsword")
	public static final Item block = null;

	public LeadtSwordItem(AetheriaElements instance) {
		super(instance, 430);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 40;
			}

			public float getEfficiency() {
				return 2f;
			}

			public float getAttackDamage() {
				return 3f;
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
		}, 3, -3.2000000000000001f, new Item.Properties().group(ItemGroup.COMBAT)) {

		}.setRegistryName("leadsword"));
	}

}
