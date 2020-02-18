package net.mcreator.aetheria;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

@Elementsaetheria.ModElement.Tag
public class MCreatorGemwroughtHoe extends Elementsaetheria.ModElement {
	@ObjectHolder("aetheria:gemwroughthoe")
	public static final Item block = null;

	public MCreatorGemwroughtHoe(Elementsaetheria instance) {
		super(instance, 100);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 504;
			}

			public float getEfficiency() {
				return 8f;
			}

			public float getAttackDamage() {
				return 1f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 23;
			}

			public Ingredient getRepairMaterial() {
				return null;
			}
		}, 8f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("gemwroughthoe"));
	}
}
