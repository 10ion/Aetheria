
package net.mcreator.aetheria.item;

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

import net.mcreator.aetheria.procedures.FastCommandExecutedProcedure;
import net.mcreator.aetheria.itemgroup.AetheriaWeaponsItemGroup;
import net.mcreator.aetheria.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class ScytheItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:scythe")
	public static final Item block = null;
	public ScytheItem(AetheriaModElements instance) {
		super(instance, 453);
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
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					FastCommandExecutedProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("scythe"));
	}
}
