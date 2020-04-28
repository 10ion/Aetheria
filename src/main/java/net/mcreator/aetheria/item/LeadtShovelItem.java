
package net.mcreator.aetheria.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.aetheria.AetheriaElements;

@AetheriaElements.ModElement.Tag
public class LeadtShovelItem extends AetheriaElements.ModElement {
	@ObjectHolder("aetheria:leadshovel")
	public static final Item block = null;
	public LeadtShovelItem(AetheriaElements instance) {
		super(instance, 431);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 40;
			}

			public float getEfficiency() {
				return 2f;
			}

			public float getAttackDamage() {
				return -1f;
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
		}, 1, -3.3f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("leadshovel"));
	}
}