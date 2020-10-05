package net.mod.aetheria.procedures;

import net.mod.aetheria.entity.CakeSlimeEntity;
import net.mod.aetheria.enchantment.PlantSlayingEnchantment;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import java.util.Map;
import java.util.HashMap;

@AetheriaModElements.ModElement.Tag
public class PlantSlayingProcedureProcedure extends AetheriaModElements.ModElement {
	public PlantSlayingProcedureProcedure(AetheriaModElements instance) {
		super(instance, 746);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure PlantSlayingProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack MainHand = ItemStack.EMPTY;
		MainHand = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
		if ((((entity instanceof CreeperEntity) || ((entity instanceof SlimeEntity) || (entity instanceof CakeSlimeEntity.CustomEntity)))
				&& (((MainHand)).isEnchanted()))) {
			entity.attackEntityFrom(DamageSource.GENERIC,
					(float) (2.5 * (EnchantmentHelper.getEnchantmentLevel(PlantSlayingEnchantment.enchantment, (MainHand)))));
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
