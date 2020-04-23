
package net.mcreator.aetheria.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.aetheria.itemgroup.AetheriaWeaponsItemGroup;
import net.mcreator.aetheria.AetheriaElements;

@AetheriaElements.ModElement.Tag
public class RedsteelSwordItem extends AetheriaElements.ModElement {
	@ObjectHolder("aetheria:redsteelsword")
	public static final Item block = null;
	public RedsteelSwordItem(AetheriaElements instance) {
		super(instance, 51);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1750;
			}

			public float getEfficiency() {
				return 0f;
			}

			public float getAttackDamage() {
				return 3.8f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 28;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3.35f, new Item.Properties().group(AetheriaWeaponsItemGroup.tab)) {
		}.setRegistryName("redsteelsword"));
	}
}
