
package net.aetheria.mod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.aetheria.mod.itemgroup.AetheriaToolsItemGroup;
import net.aetheria.mod.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class RedsteelPickaxeItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:redsteelpickaxe")
	public static final Item block = null;
	public RedsteelPickaxeItem(AetheriaModElements instance) {
		super(instance, 146);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
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
		}.setRegistryName("redsteelpickaxe"));
	}
}
