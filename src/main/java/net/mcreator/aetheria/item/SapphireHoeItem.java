
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class SapphireHoeItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:sapphire_hoe")
	public static final Item block = null;

	public SapphireHoeItem(AetheriaModElements instance) {
		super(instance, 741);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
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
		}, 0f, new Item.Properties().group(AetheriaToolsItemGroup.tab)) {

		}.setRegistryName("sapphire_hoe"));
	}

}
