
package net.mod.aetheria.item;

import net.mod.aetheria.procedures.FastCommandExecutedProcedure;
import net.mod.aetheria.itemgroup.AetheriaWeaponsItemGroup;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.Blocks;

import java.util.Map;
import java.util.HashMap;

@AetheriaModElements.ModElement.Tag
public class ScytheItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:scythe")
	public static final Item block = null;
	public ScytheItem(AetheriaModElements instance) {
		super(instance, 161);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 7500;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 8f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 12;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Blocks.IRON_BLOCK, (int) (1)));
			}
		}, 3, -3f, new Item.Properties().group(AetheriaWeaponsItemGroup.tab)) {
			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = retval.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					FastCommandExecutedProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("scythe"));
	}
}
