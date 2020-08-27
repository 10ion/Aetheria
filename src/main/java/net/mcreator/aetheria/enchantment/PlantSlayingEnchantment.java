
package net.mcreator.aetheria.enchantment;

@AetheriaModElements.ModElement.Tag
public class PlantSlayingEnchantment extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:plant_slaying")
	public static final Enchantment enchantment = null;

	public PlantSlayingEnchantment(AetheriaModElements instance) {
		super(instance, 745);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("plant_slaying"));
	}

	public static class CustomEnchantment extends Enchantment {

		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.COMMON, EnchantmentType.WEAPON, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 7;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}

	}

}
