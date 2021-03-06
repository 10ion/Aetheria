
package net.aetheria.mod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.aetheria.mod.itemgroup.AetheriaWeaponsItemGroup;
import net.aetheria.mod.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class EndersteelToolsSwordItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:endersteeltoolssword")
	public static final Item block = null;
	public EndersteelToolsSwordItem(AetheriaModElements instance) {
		super(instance, 85);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1164;
			}

			public float getEfficiency() {
				return 0f;
			}

			public float getAttackDamage() {
				return 7f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 42;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(EndersteelIngotItem.block, (int) (1)));
			}
		}, 3, -3.35f, new Item.Properties().group(AetheriaWeaponsItemGroup.tab)) {
		}.setRegistryName("endersteeltoolssword"));
	}
}
