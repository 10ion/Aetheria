
package net.mod.aetheria.item;

import net.mod.aetheria.procedures.NethercryptdaggerMobIsHitWithDaggerProcedure;
import net.mod.aetheria.itemgroup.AetheriaWeaponsItemGroup;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;

import java.util.Map;
import java.util.HashMap;

@AetheriaModElements.ModElement.Tag
public class NethercryptdaggerItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:nethercryptdagger")
	public static final Item block = null;
	public NethercryptdaggerItem(AetheriaModElements instance) {
		super(instance, 159);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1;
			}

			public float getEfficiency() {
				return 0f;
			}

			public float getAttackDamage() {
				return 5.5f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 5;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3f, new Item.Properties().group(AetheriaWeaponsItemGroup.tab)) {
			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					NethercryptdaggerMobIsHitWithDaggerProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("nethercryptdagger"));
	}
}
