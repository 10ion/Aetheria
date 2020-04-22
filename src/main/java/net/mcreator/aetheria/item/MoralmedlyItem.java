
package net.mcreator.aetheria.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.aetheria.procedures.StormberryrollFoodEatenProcedure;
import net.mcreator.aetheria.itemgroup.AetheriaFoodItemsItemGroup;
import net.mcreator.aetheria.AetheriaElements;

@AetheriaElements.ModElement.Tag
public class MoralmedlyItem extends AetheriaElements.ModElement {
	@ObjectHolder("aetheria:moralmedly")
	public static final Item block = null;
	public MoralmedlyItem(AetheriaElements instance) {
		super(instance, 77);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(AetheriaFoodItemsItemGroup.tab).maxStackSize(1)
					.food((new Food.Builder()).hunger(20).saturation(0.3f).setAlwaysEdible().build()));
			setRegistryName("moralmedly");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.DRINK;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				StormberryrollFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
