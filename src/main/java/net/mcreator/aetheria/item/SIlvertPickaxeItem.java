
package net.mcreator.aetheria.item;

@AetheriaElements.ModElement.Tag
public class SIlvertPickaxeItem extends AetheriaElements.ModElement {

	@ObjectHolder("aetheria:silverpickaxe")
	public static final Item block = null;

	public SIlvertPickaxeItem(AetheriaElements instance) {
		super(instance, 439);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 50;
			}

			public float getEfficiency() {
				return 3f;
			}

			public float getAttackDamage() {
				return -1f;
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
		}, 1, -2.5999999999999999f, new Item.Properties().group(AetheriaToolsItemGroup.tab)) {

		}.setRegistryName("silverpickaxe"));
	}

}
