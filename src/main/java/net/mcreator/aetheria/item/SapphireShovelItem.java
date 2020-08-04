
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class SapphireShovelItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:sapphire_shovel")
	public static final Item block = null;

	public SapphireShovelItem(AetheriaModElements instance) {
		super(instance, 740);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
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
		}, 1, -3f, new Item.Properties().group(AetheriaToolsItemGroup.tab)) {

		}.setRegistryName("sapphire_shovel"));
	}

}
