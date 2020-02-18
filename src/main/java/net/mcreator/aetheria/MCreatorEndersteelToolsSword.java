package net.mcreator.aetheria;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@Elementsaetheria.ModElement.Tag
public class MCreatorEndersteelToolsSword extends Elementsaetheria.ModElement {
	@ObjectHolder("aetheria:endersteeltoolssword")
	public static final Item block = null;

	public MCreatorEndersteelToolsSword(Elementsaetheria instance) {
		super(instance, 82);
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
				return Ingredient.fromStacks(new ItemStack(MCreatorEndersteel.block, (int) (1)));
			}
		}, 3, -3.35F, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("endersteeltoolssword"));
	}
}
