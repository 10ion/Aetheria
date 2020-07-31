
package net.mcreator.aetheria.potion;

@AetheriaModElements.ModElement.Tag
public class AntiCheatPotion extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:anti_cheat")
	public static final Effect potion = null;

	public AntiCheatPotion(AetheriaModElements instance) {
		super(instance, 504);

		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerEffect(RegistryEvent.Register<Effect> event) {
		event.getRegistry().register(new EffectCustom());
	}

	public static class EffectCustom extends Effect {

		private final ResourceLocation potionIcon;

		public EffectCustom() {
			super(EffectType.NEUTRAL, -13369549);
			setRegistryName("anti_cheat");
			potionIcon = new ResourceLocation("aetheria:textures/placeholder.png");
		}

		@Override
		public String getName() {
			return "effect.anti_cheat";
		}

		@Override
		public boolean isBeneficial() {
			return false;
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

				AntiCheatOnPotionActiveTickProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}

	}

}
