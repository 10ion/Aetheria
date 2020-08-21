
package net.mod.aetheria.item;

import net.mod.aetheria.itemgroup.AetheriaToolsItemGroup;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@AetheriaModElements.ModElement.Tag
public class EndersteelToolsPickaxeItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:endersteeltoolspickaxe")
	public static final Item block = null;
	public EndersteelToolsPickaxeItem(AetheriaModElements instance) {
		super(instance, 175);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
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
				return Ingredient.fromStacks(new ItemStack(EndersteelIngotItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(AetheriaToolsItemGroup.tab)) {
		}.setRegistryName("endersteeltoolspickaxe"));
	}
}
