
package net.mod.aetheria.item;

import net.mod.aetheria.itemgroup.AetheriaToolsItemGroup;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@AetheriaModElements.ModElement.Tag
public class RedsteelShovelItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:redsteelshovel")
	public static final Item block = null;
	public RedsteelShovelItem(AetheriaModElements instance) {
		super(instance, 192);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 660;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 28;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(AetheriaToolsItemGroup.tab)) {
		}.setRegistryName("redsteelshovel"));
	}
}
