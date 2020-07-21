
package net.mcreator.aetheria.entity;

@AetheriaModElements.ModElement.Tag
public class MyconEntity extends AetheriaModElements.ModElement {

	public static EntityType entity = null;

	public MyconEntity(AetheriaModElements instance) {
		super(instance, 513);

		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.95f)).build("mycon")
						.setRegistryName("mycon");

		elements.entities.add(() -> entity);

		elements.items.add(() -> new SpawnEggItem(entity, -65485, -1650754, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("mycon"));

	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("aetheria:voidplanes")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("aetheria:extremevoidplanes")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;

			biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(entity, 25, 1, 7));
		}

		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				AnimalEntity::func_223315_a);

	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(CustomEntity.class,
				renderManager -> new MobRenderer(renderManager, new VillagerModel(0), 0.5f) {

					@Override
					protected ResourceLocation getEntityTexture(Entity entity1) {
						return new ResourceLocation("aetheria:textures/placeholder.png");
					}
				});

	}

	public static class CustomEntity extends CreatureEntity {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);

		}

		@Override
		protected void registerGoals() {
			super.registerGoals();

			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(3, new SwimGoal(this));

		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wandering_trader.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wandering_trader.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();

			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);

			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(32);

			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);

			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);

		}

	}

}
