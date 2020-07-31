package net.mcreator.aetheria.procedures;

@AetheriaModElements.ModElement.Tag
public class StormberryCookieFoodEatenProcedure extends AetheriaModElements.ModElement {

	public StormberryCookieFoodEatenProcedure(AetheriaModElements instance) {
		super(instance, 535);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure StormberryCookieFoodEaten!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Omnessence1Potion.potion, (int) 1800, (int) 1));

	}

}
