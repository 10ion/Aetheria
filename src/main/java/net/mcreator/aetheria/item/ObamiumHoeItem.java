
package net.mcreator.aetheria.item;

@AetheriaElements.ModElement.Tag
public class ObamiumHoeItem extends AetheriaElements.ModElement {

	@ObjectHolder("aetheria:obamiumhoe")
	public static final Item block = null;

	public ObamiumHoeItem(AetheriaElements instance) {
		super(instance, 445);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 4000;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 3f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 10;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(ObamiumItem.block, (int) (1)));
			}
		}, -2f, new Item.Properties().group(AetheriaToolsItemGroup.tab)) {

		}.setRegistryName("obamiumhoe"));
	}

}
