
package net.mcreator.aetheria.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.RestrictSunGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.aetheria.itemgroup.AetheriaEntitiesItemGroup;
import net.mcreator.aetheria.AetheriaModElements;

import com.mojang.blaze3d.platform.GlStateManager;

@AetheriaModElements.ModElement.Tag
public class MummyEntity extends AetheriaModElements.ModElement {
	public static EntityType entity = null;
	public MummyEntity(AetheriaModElements instance) {
		super(instance, 489);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("mummy")
						.setRegistryName("mummy");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -3618716, -16777216, new Item.Properties().group(AetheriaEntitiesItemGroup.tab))
				.setRegistryName("mummy"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("desert")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("desert_hills")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 5, 1, 4));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::func_223315_a);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(CustomEntity.class, renderManager -> {
			return new MobRenderer(renderManager, new Modelundead(), 0.5f) {
				{
					this.addLayer(new GlowingLayer<>(this));
				}
				@Override
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("aetheria:textures/mummy.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 10;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new RestrictSunGoal(this));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.8));
			this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, false));
			this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1, true));
			this.targetSelector.addGoal(5, new HurtByTargetGoal(this).setCallsForHelp(this.getClass()));
			this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEAD;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.husk.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.husk.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.husk.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(6);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5);
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
		private static final ResourceLocation GLOW_TEXTURE = new ResourceLocation("aetheria:textures/mummyoverlay.png");
		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(T entityIn, float l1, float l2, float l3, float l4, float l5, float l6, float l7) {
			this.bindTexture(GLOW_TEXTURE);
			GlStateManager.enableBlend();
			GlStateManager.disableAlphaTest();
			GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
			if (entityIn.isInvisible())
				GlStateManager.depthMask(false);
			else
				GlStateManager.depthMask(true);
			int i = 61680;
			int j = i % 65536;
			int k = i / 65536;
			com.mojang.blaze3d.platform.GLX.glMultiTexCoord2f(com.mojang.blaze3d.platform.GLX.GL_TEXTURE1, (float) j, (float) k);
			GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			GameRenderer gamerenderer = Minecraft.getInstance().gameRenderer;
			gamerenderer.setupFogColor(true);
			((EntityModel<T>) this.getEntityModel()).render(entityIn, l1, l2, l4, l5, l6, l7);
			gamerenderer.setupFogColor(false);
			i = entityIn.getBrightnessForRender();
			j = i % 65536;
			k = i / 65536;
			com.mojang.blaze3d.platform.GLX.glMultiTexCoord2f(com.mojang.blaze3d.platform.GLX.GL_TEXTURE1, (float) j, (float) k);
			this.func_215334_a(entityIn);
			GlStateManager.depthMask(true);
			GlStateManager.disableBlend();
			GlStateManager.enableAlphaTest();
		}

		public boolean shouldCombineTextures() {
			return false;
		}
	}

	// Made with Blockbench 3.5.4
	// Exported for Minecraft version 1.14
	// Paste this class into your mod and generate all required imports
	public static class Modelundead extends EntityModel {
		private final RendererModel body;
		private final RendererModel head;
		private final RendererModel rightArm;
		private final RendererModel leftArm;
		private final RendererModel rightLeg;
		private final RendererModel leftLeg;
		public Modelundead() {
			textureWidth = 128;
			textureHeight = 128;
			body = new RendererModel(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.cubeList.add(new ModelBox(body, 0, 32, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, false));
			body.cubeList.add(new ModelBox(body, 28, 28, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.25F, false));
			head = new RendererModel(this);
			head.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.cubeList.add(new ModelBox(head, 0, 16, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F, false));
			rightArm = new RendererModel(this);
			rightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
			setRotationAngle(rightArm, -1.3963F, 0.0F, 0.0F);
			rightArm.cubeList.add(new ModelBox(rightArm, 52, 52, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));
			rightArm.cubeList.add(new ModelBox(rightArm, 52, 28, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F, false));
			rightArm.cubeList.add(new ModelBox(rightArm, 16, 32, -3.0F, 10.0F, 1.0F, 4, 0, 4, 0.0F, false));
			rightArm.cubeList.add(new ModelBox(rightArm, 28, 24, -3.0F, 8.0304F, 1.3473F, 4, 0, 4, 0.0F, false));
			rightArm.cubeList.add(new ModelBox(rightArm, 28, 20, -3.0F, 5.8871F, 0.7098F, 4, 0, 4, 0.0F, false));
			rightArm.cubeList.add(new ModelBox(rightArm, 28, 16, -3.0F, 3.9175F, 1.0571F, 4, 0, 4, 0.0F, false));
			leftArm = new RendererModel(this);
			leftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
			setRotationAngle(leftArm, -1.3963F, 0.0F, 0.0F);
			leftArm.cubeList.add(new ModelBox(leftArm, 52, 52, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));
			leftArm.cubeList.add(new ModelBox(leftArm, 0, 48, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F, false));
			leftArm.cubeList.add(new ModelBox(leftArm, 20, 16, -1.0F, 3.9175F, 1.0571F, 4, 0, 4, 0.0F, false));
			leftArm.cubeList.add(new ModelBox(leftArm, 20, 4, -1.0F, 10.0F, 1.0F, 4, 0, 4, 0.0F, false));
			leftArm.cubeList.add(new ModelBox(leftArm, 20, 0, -1.0F, 8.0304F, 1.3473F, 4, 0, 4, 0.0F, false));
			leftArm.cubeList.add(new ModelBox(leftArm, 20, 20, -1.0F, 5.8871F, 0.7098F, 4, 0, 4, 0.0F, false));
			rightLeg = new RendererModel(this);
			rightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
			rightLeg.cubeList.add(new ModelBox(rightLeg, 44, 12, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
			rightLeg.cubeList.add(new ModelBox(rightLeg, 36, 44, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F, false));
			leftLeg = new RendererModel(this);
			leftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
			leftLeg.cubeList.add(new ModelBox(leftLeg, 20, 44, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
			leftLeg.cubeList.add(new ModelBox(leftLeg, 32, 0, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			body.render(f5);
			head.render(f5);
			rightArm.render(f5);
			leftArm.render(f5);
			rightLeg.render(f5);
			leftLeg.render(f5);
		}

		public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4, float f5) {
			super.setRotationAngles(e, f, f1, f2, f3, f4, f5);
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.rightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
