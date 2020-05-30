
package net.mcreator.aetheria.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.aetheria.itemgroup.AetheriaToolsItemGroup;
import net.mcreator.aetheria.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class LeadtAxeItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:leadaxe")
	public static final Item block = null;
	public LeadtAxeItem(AetheriaModElements instance) {
		super(instance, 429);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 40;
			}

			public float getEfficiency() {
				return 2f;
			}

			public float getAttackDamage() {
				return 1f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3.4f, new Item.Properties().group(AetheriaToolsItemGroup.tab)) {
		}.setRegistryName("leadaxe"));
	}
}
