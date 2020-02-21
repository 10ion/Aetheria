package net.mcreator.aetheria;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@Elementsaetheria.ModElement.Tag
public class MCreatorGemwroughtShovel extends Elementsaetheria.ModElement {
	@ObjectHolder("aetheria:gemwroughtshovel")
	public static final Item block = null;

	public MCreatorGemwroughtShovel(Elementsaetheria instance) {
		super(instance, 99);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
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
		}, 1, -2F, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("gemwroughtshovel"));
	}
}
