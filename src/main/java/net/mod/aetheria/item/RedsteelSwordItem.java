
package net.mod.aetheria.item;

import net.mod.aetheria.itemgroup.AetheriaWeaponsItemGroup;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@AetheriaModElements.ModElement.Tag
public class RedsteelSwordItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:redsteelsword")
	public static final Item block = null;
	public RedsteelSwordItem(AetheriaModElements instance) {
		super(instance, 88);
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
