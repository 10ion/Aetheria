
package net.mcreator.aetheria.potion;

@AetheriaModElements.ModElement.Tag
public class MilkbottlePotion extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:milkbottle")
	public static final Effect potion = null;

	@ObjectHolder("aetheria:milkbottle")
	public static final Potion potionType = null;

	public MilkbottlePotion(AetheriaModElements instance) {
		super(instance, 203);

		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerEffect(RegistryEvent.Register<Effect> event) {
		event.getRegistry().register(new EffectCustom());
	}

	@SubscribeEvent
	public void registerPotion(RegistryEvent.Register<Potion> event) {
		event.getRegistry().register(new PotionCustom());
	}

	public static class PotionCustom extends Potion {

		public PotionCustom() {
			super(new EffectInstance(potion, 3600));
			setRegistryName("milkbottle");
		}

	}

	public static class EffectCustom extends Effect {

		private final ResourceLocation potionIcon;

		public EffectCustom() {
			super(EffectType.NEUTRAL, -1);
			setRegistryName("milkbottle");
			potionIcon = new ResourceLocation("aetheria:textures/cakeslimefront.png");
		}

		@Override
		public String getName() {
			return "effect.milkbottle";
		}

		@Override
		public boolean isBeneficial() {
			return false;
		}

		@Override
		public boolean isInstant() {
			return true;
		}

		@Override
		public boolean shouldRenderInvText(EffectInstance effect) {
			return false;
		}

		@Override
		public boolean shouldRender(EffectInstance effect) {
			return false;
		}

		@Override
		public boolean shouldRenderHUD(EffectInstance effect) {
			return false;
		}

		@Override
		public void affectEntity(Entity source, Entity indirectSource, LivingEntity entity, int amplifier, double health) {
			World world = entity.world;
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);

				MilkbottlePotionStartedappliedProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}

	}

}
