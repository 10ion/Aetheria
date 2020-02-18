package net.mcreator.aetheria;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

@Elementsaetheria.ModElement.Tag
public class MCreatorRedsteelHoe extends Elementsaetheria.ModElement {
	@ObjectHolder("aetheria:redsteelhoe")
	public static final Item block = null;

	public MCreatorRedsteelHoe(Elementsaetheria instance) {
		super(instance, 121);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 660;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 28;
			}

			public Ingredient getRepairMaterial() {
				return null;
			}
		}, 9f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("redsteelhoe"));
	}
}
