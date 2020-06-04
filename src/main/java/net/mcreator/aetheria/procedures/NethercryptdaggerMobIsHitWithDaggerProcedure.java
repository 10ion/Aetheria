package net.mcreator.aetheria.procedures;

@AetheriaModElements.ModElement.Tag
public class NethercryptdaggerMobIsHitWithDaggerProcedure extends AetheriaModElements.ModElement {

	public NethercryptdaggerMobIsHitWithDaggerProcedure(AetheriaModElements instance) {
		super(instance, 202);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure NethercryptdaggerMobIsHitWithDagger!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 35, (int) 10, (false), (true)));

	}

}
