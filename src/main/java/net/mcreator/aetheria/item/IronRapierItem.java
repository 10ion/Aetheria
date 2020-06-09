
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class IronRapierItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:ironrapier")
	public static final Item block = null;

	public IronRapierItem(AetheriaModElements instance) {
		super(instance, 463);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return -1f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -2f, new Item.Properties().group(ItemGroup.COMBAT)) {

		}.setRegistryName("ironrapier"));
	}

}
