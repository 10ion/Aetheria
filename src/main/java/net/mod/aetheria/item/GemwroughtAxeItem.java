
package net.mod.aetheria.item;

import net.mod.aetheria.itemgroup.AetheriaToolsItemGroup;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

@AetheriaModElements.ModElement.Tag
public class GemwroughtAxeItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:gemwroughtaxe")
	public static final Item block = null;
	public GemwroughtAxeItem(AetheriaModElements instance) {
		super(instance, 180);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1000;
			}

			public float getEfficiency() {
				return 8f;
			}

			public float getAttackDamage() {
				return 1f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 23;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -2f, new Item.Properties().group(AetheriaToolsItemGroup.tab)) {
		}.setRegistryName("gemwroughtaxe"));
	}
}
