
package net.mcreator.aetheria.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.aetheria.itemgroup.AetheriaToolsItemGroup;
import net.mcreator.aetheria.AetheriaElements;

@AetheriaElements.ModElement.Tag
public class EndersteelToolsShovelItem extends AetheriaElements.ModElement {
	@ObjectHolder("aetheria:endersteeltoolsshovel")
	public static final Item block = null;
	public EndersteelToolsShovelItem(AetheriaElements instance) {
		super(instance, 140);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 1164;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 6;
			}

			public int getEnchantability() {
				return 42;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(EndersteelItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(AetheriaToolsItemGroup.tab)) {
		}.setRegistryName("endersteeltoolsshovel"));
	}
}
