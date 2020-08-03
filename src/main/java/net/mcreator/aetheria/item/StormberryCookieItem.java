
package net.mcreator.aetheria.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.aetheria.procedures.StormberryCookieFoodEatenProcedure;
import net.mcreator.aetheria.AetheriaModElements;

import java.util.Map;
import java.util.HashMap;

@AetheriaModElements.ModElement.Tag
public class StormberryCookieItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:stormberry_cookie")
	public static final Item block = null;
	public StormberryCookieItem(AetheriaModElements instance) {
		super(instance, 533);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).food((new Food.Builder()).hunger(4).saturation(0.7f).build()));
			setRegistryName("stormberry_cookie");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 26;
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
			double x = entity.posX;
			double y = entity.posY;
			double z = entity.posZ;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				StormberryCookieFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
