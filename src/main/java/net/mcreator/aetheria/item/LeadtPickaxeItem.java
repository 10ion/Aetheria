
package net.mcreator.aetheria.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.aetheria.itemgroup.AetheriaToolsItemGroup;
import net.mcreator.aetheria.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class LeadtPickaxeItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:leadpickaxe")
	public static final Item block = null;
	public LeadtPickaxeItem(AetheriaModElements instance) {
		super(instance, 428);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 40;
			}

			public float getEfficiency() {
				return 1.5f;
			}

			public float getAttackDamage() {
				return -1f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 7;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(LeadItem.block, (int) (1)));
			}
		}, 1, -2.8f, new Item.Properties().group(AetheriaToolsItemGroup.tab)) {
		}.setRegistryName("leadpickaxe"));
	}
}
