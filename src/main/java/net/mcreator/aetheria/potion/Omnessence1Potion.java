
package net.mcreator.aetheria.potion;

@AetheriaModElements.ModElement.Tag
public class Omnessence1Potion extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:omnessence1")
	public static final Effect potion = null;

	public Omnessence1Potion(AetheriaModElements instance) {
		super(instance, 211);

		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerEffect(RegistryEvent.Register<Effect> event) {
		event.getRegistry().register(new EffectCustom());
	}

	public static class EffectCustom extends Effect {

		private final ResourceLocation potionIcon;

		public EffectCustom() {
			super(EffectType.BENEFICIAL, -6684928);
			setRegistryName("omnessence1");
			potionIcon = new ResourceLocation("aetheria:textures/omnessence.png");
		}

		@Override
		public String getName() {
			return "effect.omnessence1";
		}

		@Override
		public boolean isBeneficial() {
			return true;
		}

		@Override
		public boolean isInstant() {
			return false;
		}

		@Override
		public boolean shouldRenderInvText(EffectInstance effect) {
			return true;
		}

		@Override
		public boolean shouldRender(EffectInstance effect) {
			return true;
		}

		@Override
		public boolean shouldRenderHUD(EffectInstance effect) {
			return true;
		}

		@Override
		public void performEffect(LivingEntity entity, int amplifier) {
			World world = entity.world;
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);

				Omnessence1OnPotionActiveTickProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}

	}

}
