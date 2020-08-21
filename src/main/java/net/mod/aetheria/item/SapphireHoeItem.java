
package net.mod.aetheria.item;

import net.mod.aetheria.itemgroup.AetheriaToolsItemGroup;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

@AetheriaModElements.ModElement.Tag
public class SapphireHoeItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:sapphire_hoe")
	public static final Item block = null;
	public SapphireHoeItem(AetheriaModElements instance) {
		super(instance, 201);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 1900;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 9;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SapphireGemItem.block, (int) (1)));
			}
		}, 0f, new Item.Properties().group(AetheriaToolsItemGroup.tab)) {
		}.setRegistryName("sapphire_hoe"));
	}
}
