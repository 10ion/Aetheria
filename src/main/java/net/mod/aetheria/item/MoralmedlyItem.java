
package net.mod.aetheria.item;

import net.mod.aetheria.procedures.StormberryrollFoodEatenProcedure;
import net.mod.aetheria.itemgroup.AetheriaFoodItemsItemGroup;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import java.util.Map;
import java.util.HashMap;

@AetheriaModElements.ModElement.Tag
public class MoralmedlyItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:moralmedly")
	public static final Item block = null;
	public MoralmedlyItem(AetheriaModElements instance) {
		super(instance, 99);
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
		public net.minecraft.util.SoundEvent getEatSound() {
			return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				StormberryrollFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
