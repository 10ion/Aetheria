
package net.mcreator.aetheria.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

import net.mcreator.aetheria.AetheriaElements;

@AetheriaElements.ModElement.Tag
public class LeadtHoeItem extends AetheriaElements.ModElement {
	@ObjectHolder("aetheria:leadhoe")
	public static final Item block = null;
	public LeadtHoeItem(AetheriaElements instance) {
		super(instance, 432);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
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
		}, -3.3f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("leadhoe"));
	}
}
