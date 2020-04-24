
package net.mcreator.aetheria.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

import net.mcreator.aetheria.itemgroup.AetheriaToolsItemGroup;
import net.mcreator.aetheria.AetheriaElements;

@AetheriaElements.ModElement.Tag
public class RedsteelHoeItem extends AetheriaElements.ModElement {
	@ObjectHolder("aetheria:redsteelhoe")
	public static final Item block = null;
	public RedsteelHoeItem(AetheriaElements instance) {
		super(instance, 149);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
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
		}, -3f, new Item.Properties().group(AetheriaToolsItemGroup.tab)) {
		}.setRegistryName("redsteelhoe"));
	}
}
