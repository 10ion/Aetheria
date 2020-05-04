
package net.mcreator.aetheria.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.aetheria.itemgroup.AetheriaToolsItemGroup;
import net.mcreator.aetheria.AetheriaElements;

@AetheriaElements.ModElement.Tag
public class ObamiumPickaxeItem extends AetheriaElements.ModElement {
	@ObjectHolder("aetheria:obamiumpickaxe")
	public static final Item block = null;
	public ObamiumPickaxeItem(AetheriaElements instance) {
		super(instance, 441);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 4000;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 3f;
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
		}, 1, -2f, new Item.Properties().group(AetheriaToolsItemGroup.tab)) {
		}.setRegistryName("obamiumpickaxe"));
	}
}
