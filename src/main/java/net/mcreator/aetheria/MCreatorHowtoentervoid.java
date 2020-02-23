package net.mcreator.aetheria;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

@Elementsaetheria.ModElement.Tag
public class MCreatorHowtoentervoid extends Elementsaetheria.ModElement {
	public MCreatorHowtoentervoid(Elementsaetheria instance) {
		super(instance, 144);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorHowtoentervoid!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.dimension.getId()) == (0)) && ((entity.posY) < 0))) {
			if (!entity.world.isRemote && entity instanceof ServerPlayerEntity) {
				DimensionType destinationType = MCreatorTheVoid.type;
				ObfuscationReflectionHelper.setPrivateValue(ServerPlayerEntity.class, (ServerPlayerEntity) entity, true, "field_184851_cj");
				ServerWorld nextWorld = entity.getServer().getWorld(destinationType);
				((ServerPlayerEntity) entity).connection.sendPacket(new SChangeGameStatePacket(4, 0));
				((ServerPlayerEntity) entity).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1, nextWorld
						.getSpawnPoint().getZ(), entity.rotationYaw, entity.rotationPitch);
				((ServerPlayerEntity) entity).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) entity).abilities));
				for (EffectInstance effectinstance : ((ServerPlayerEntity) entity).getActivePotionEffects()) {
					((ServerPlayerEntity) entity).connection.sendPacket(new SPlayEntityEffectPacket(entity.getEntityId(), effectinstance));
				}
				((ServerPlayerEntity) entity).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
			}
		}
		if ((((entity.dimension.getId()) == (-1)) && ((entity.posY) < 0))) {
			if (!entity.world.isRemote && entity instanceof ServerPlayerEntity) {
				DimensionType destinationType = MCreatorTheVoid.type;
				ObfuscationReflectionHelper.setPrivateValue(ServerPlayerEntity.class, (ServerPlayerEntity) entity, true, "field_184851_cj");
				ServerWorld nextWorld = entity.getServer().getWorld(destinationType);
				((ServerPlayerEntity) entity).connection.sendPacket(new SChangeGameStatePacket(4, 0));
				((ServerPlayerEntity) entity).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1, nextWorld
						.getSpawnPoint().getZ(), entity.rotationYaw, entity.rotationPitch);
				((ServerPlayerEntity) entity).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) entity).abilities));
				for (EffectInstance effectinstance : ((ServerPlayerEntity) entity).getActivePotionEffects()) {
					((ServerPlayerEntity) entity).connection.sendPacket(new SPlayEntityEffectPacket(entity.getEntityId(), effectinstance));
				}
				((ServerPlayerEntity) entity).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			int i = (int) entity.posX;
			int j = (int) entity.posY;
			int k = (int) entity.posZ;
			java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
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
