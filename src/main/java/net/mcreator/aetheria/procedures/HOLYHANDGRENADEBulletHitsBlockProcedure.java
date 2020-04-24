package net.mcreator.aetheria.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.Explosion;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.server.MinecraftServer;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.aetheria.AetheriaElements;

@AetheriaElements.ModElement.Tag
public class HOLYHANDGRENADEBulletHitsBlockProcedure extends AetheriaElements.ModElement {
	public HOLYHANDGRENADEBulletHitsBlockProcedure(AetheriaElements instance) {
		super(instance, 240);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure HOLYHANDGRENADEBulletHitsBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure HOLYHANDGRENADEBulletHitsBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure HOLYHANDGRENADEBulletHitsBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure HOLYHANDGRENADEBulletHitsBlock!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		{
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().sendMessage(new StringTextComponent("BRING FORTH THE HOLY HAND GRENADE!"));
		}
		if (world instanceof ServerWorld)
			((ServerWorld) world).addLightningBolt(new LightningBoltEntity(world, (int) x, (int) y, (int) z, false));
		if (!world.isRemote) {
			world.createExplosion(null, (int) x, (int) y, (int) z, (float) 20, Explosion.Mode.BREAK);
		}
		if (!world.isRemote && world.getServer() != null) {
			world.getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.field_213139_a_, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), world.getServer(), null).withFeedbackDisabled(),
					"effect give @e[distance=..10] minecraft:instant_damage  1 4");
		}
		for (int _ct = 0; _ct < 7; _ct++) {
			world.addOptionalParticle(ParticleTypes.EXPLOSION, x, y, z, 3, 3, 3);
		}
		for (int _ct = 0; _ct < 7; _ct++) {
			world.addOptionalParticle(ParticleTypes.EXPLOSION_EMITTER, x, y, z, 3, 3, 3);
		}
		for (int _ct = 0; _ct < 7; _ct++) {
			world.addOptionalParticle(ParticleTypes.LAVA, x, y, z, 3, 3, 3);
		}
		for (int _ct = 0; _ct < 7; _ct++) {
			world.addOptionalParticle(ParticleTypes.FLAME, x, y, z, 3, 3, 3);
		}
	}
}
