
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class SapphireAxeItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:sapphire_axe")
	public static final Item block = null;

	public SapphireAxeItem(AetheriaModElements instance) {
		super(instance, 206);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1900;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 7f;
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
		}, 1, -3f, new Item.Properties().group(AetheriaToolsItemGroup.tab)) {

		}.setRegistryName("sapphire_axe"));
	}

}
