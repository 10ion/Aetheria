
package net.mcreator.aetheria.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.aetheria.itemgroup.AetheriaWeaponsItemGroup;
import net.mcreator.aetheria.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class ObamiumSwordItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:obamiumsword")
	public static final Item block = null;
	public ObamiumSwordItem(AetheriaModElements instance) {
		super(instance, 442);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 4000;
			}

			public float getEfficiency() {
				return 3f;
			}

			public float getAttackDamage() {
				return 8f;
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
		}, 3, 4f, new Item.Properties().group(AetheriaWeaponsItemGroup.tab)) {
		}.setRegistryName("obamiumsword"));
	}
}
