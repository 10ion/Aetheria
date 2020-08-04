
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class SapphireSwordItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:sapphire_sword")
	public static final Item block = null;

	public SapphireSwordItem(AetheriaModElements instance) {
		super(instance, 739);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1900;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 9;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SapphireGemItem.block, (int) (1)));
			}
		}, 3, -2.4f, new Item.Properties().group(AetheriaWeaponsItemGroup.tab)) {

		}.setRegistryName("sapphire_sword"));
	}

}
