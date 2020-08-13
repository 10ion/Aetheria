
package net.aetheria.mod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.aetheria.mod.procedures.StormberryrollFoodEatenProcedure;
import net.aetheria.mod.itemgroup.AetheriaFoodItemsItemGroup;
import net.aetheria.mod.AetheriaModElements;

import java.util.Map;
import java.util.HashMap;

@AetheriaModElements.ModElement.Tag
public class StormberryrollItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:stormberryroll")
	public static final Item block = null;
	public StormberryrollItem(AetheriaModElements instance) {
		super(instance, 90);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(AetheriaFoodItemsItemGroup.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(5).saturation(0.3f).setAlwaysEdible().build()));
			setRegistryName("stormberryroll");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
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
