package net.mcreator.aetheria.procedures;

@AetheriaModElements.ModElement.Tag
public class AntiCheatOnPotionActiveTickProcedure extends AetheriaModElements.ModElement {

	public AntiCheatOnPotionActiveTickProcedure(AetheriaModElements instance) {
		super(instance, 505);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AntiCheatOnPotionActiveTick!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).setGameType(GameType.SURVIVAL);

	}

}
