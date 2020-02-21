package net.mcreator.aetheria;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@Elementsaetheria.ModElement.Tag
public class MCreatorRedsteelSword extends Elementsaetheria.ModElement {
	@ObjectHolder("aetheria:redsteelsword")
	public static final Item block = null;

	public MCreatorRedsteelSword(Elementsaetheria instance) {
		super(instance, 119);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1750;
			}

			public float getEfficiency() {
				return 0f;
			}

			public float getAttackDamage() {
				return 3.8f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 28;
			}

			public Ingredient getRepairMaterial() {
				return null;
			}
		}, 3, -3.35F, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("redsteelsword"));
	}
}
