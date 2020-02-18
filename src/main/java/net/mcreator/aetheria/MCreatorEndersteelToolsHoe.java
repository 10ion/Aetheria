package net.mcreator.aetheria;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

@Elementsaetheria.ModElement.Tag
public class MCreatorEndersteelToolsHoe extends Elementsaetheria.ModElement {
	@ObjectHolder("aetheria:endersteeltoolshoe")
	public static final Item block = null;

	public MCreatorEndersteelToolsHoe(Elementsaetheria instance) {
		super(instance, 84);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
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
				return Ingredient.fromStacks(new ItemStack(MCreatorEndersteel.block, (int) (1)));
			}
		}, 12f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("endersteeltoolshoe"));
	}
}
