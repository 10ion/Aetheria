
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class SapphirePickaxeItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:sapphire_pickaxe")
	public static final Item block = null;

	public SapphirePickaxeItem(AetheriaModElements instance) {
		super(instance, 205);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1900;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 1f;
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
		}, 1, -2.8f, new Item.Properties().group(AetheriaToolsItemGroup.tab)) {

		}.setRegistryName("sapphire_pickaxe"));
	}

}
