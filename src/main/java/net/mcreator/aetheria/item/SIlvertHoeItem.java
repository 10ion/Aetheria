
package net.mcreator.aetheria.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

import net.mcreator.aetheria.itemgroup.AetheriaToolsItemGroup;
import net.mcreator.aetheria.AetheriaElements;

@AetheriaElements.ModElement.Tag
public class SIlvertHoeItem extends AetheriaElements.ModElement {
	@ObjectHolder("aetheria:silverhoe")
	public static final Item block = null;
	public SIlvertHoeItem(AetheriaElements instance) {
		super(instance, 443);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 30;
			}

			public float getEfficiency() {
				return 3f;
			}

			public float getAttackDamage() {
				return -1f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 30;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, -2.8f, new Item.Properties().group(AetheriaToolsItemGroup.tab)) {
		}.setRegistryName("silverhoe"));
	}
}
