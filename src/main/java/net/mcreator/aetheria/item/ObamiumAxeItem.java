
package net.mcreator.aetheria.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.aetheria.itemgroup.AetheriaToolsItemGroup;
import net.mcreator.aetheria.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class ObamiumAxeItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:obamiumaxe")
	public static final Item block = null;
	public ObamiumAxeItem(AetheriaModElements instance) {
		super(instance, 443);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 4000;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 10f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 10;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(ObamiumItem.block, (int) (1)));
			}
		}, 1, 0f, new Item.Properties().group(AetheriaToolsItemGroup.tab)) {
		}.setRegistryName("obamiumaxe"));
	}
}