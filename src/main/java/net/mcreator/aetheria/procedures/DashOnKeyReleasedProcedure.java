package net.mcreator.aetheria.procedures;

@AetheriaModElements.ModElement.Tag
public class DashOnKeyReleasedProcedure extends AetheriaModElements.ModElement {

	public DashOnKeyReleasedProcedure(AetheriaModElements instance) {
		super(instance, 492);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DashOnKeyReleased!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"execute at @s tp @s ^ ^ ^1");
			}
		}

	}

}
