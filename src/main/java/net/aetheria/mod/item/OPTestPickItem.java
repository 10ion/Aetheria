
package net.aetheria.mod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.aetheria.mod.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class OPTestPickItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:op_test_pick")
	public static final Item block = null;
	public OPTestPickItem(AetheriaModElements instance) {
		super(instance, 454);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 0;
			}

			public float getEfficiency() {
				return 15f;
			}

			public float getAttackDamage() {
				return 18f;
			}

			public int getHarvestLevel() {
				return 50;
			}

			public int getEnchantability() {
				return 100000;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, 46f, new Item.Properties().group(null)) {
		}.setRegistryName("op_test_pick"));
	}
}
