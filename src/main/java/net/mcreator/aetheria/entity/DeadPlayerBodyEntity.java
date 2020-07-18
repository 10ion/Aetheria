
package net.mcreator.aetheria.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.aetheria.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class DeadPlayerBodyEntity extends AetheriaModElements.ModElement {
	public static EntityType entity = null;
	public DeadPlayerBodyEntity(AetheriaModElements instance) {
		super(instance, 467);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.AMBIENT).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(0.6f, 0.8f))
						.build("dead_player_body").setRegistryName("dead_player_body");
		elements.entities.add(() -> entity);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(CustomEntity.class, renderManager -> {
			return new MobRenderer(renderManager, new Modeldeadbody(), 0.5f) {
				@Override
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("aetheria:textures/deadbody.png");
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
			experienceValue = 0;
			setNoAI(true);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
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
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof ArrowEntity)
				return false;
			if (source.getImmediateSource() instanceof PotionEntity)
				return false;
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}
	}

	// Made with Blockbench 3.5.4
	// Exported for Minecraft version 1.14
	// Paste this class into your mod and generate all required imports
	public static class Modeldeadbody extends EntityModel {
		private final RendererModel Head;
		private final RendererModel Body;
		private final RendererModel RightArm;
		private final RendererModel LeftArm;
		private final RendererModel RightLeg;
		private final RendererModel LeftLeg;
		public Modeldeadbody() {
			textureWidth = 64;
			textureHeight = 64;
			Head = new RendererModel(this);
			Head.setRotationPoint(0.0F, 0.0F, 0.0F);
			setRotationAngle(Head, -1.6755F, 0.0873F, 0.3491F);
			Head.cubeList.add(new ModelBox(Head, 0, 0, 2.8144F, -11.5519F, 14.5241F, 8, 8, 8, 0.0F, false));
			Body = new RendererModel(this);
			Body.setRotationPoint(0.0F, 0.0F, 3.0F);
			setRotationAngle(Body, -1.3963F, 0.0F, 0.0F);
			Body.cubeList.add(new ModelBox(Body, 16, 16, -4.0F, 3.9176F, 16.3526F, 8, 12, 4, 0.0F, false));
			RightArm = new RendererModel(this);
			RightArm.setRotationPoint(-9.0F, 2.0F, 0.0F);
			setRotationAngle(RightArm, 0.0F, 2.7053F, 1.3963F);
			RightArm.cubeList.add(new ModelBox(RightArm, 40, 16, -18.7937F, -2.8192F, 5.3647F, 4, 12, 4, 0.0F, false));
			LeftArm = new RendererModel(this);
			LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
			setRotationAngle(LeftArm, 0.2094F, 0.0F, -1.4835F);
			LeftArm.cubeList.add(new ModelBox(LeftArm, 32, 48, -20.1047F, 0.2661F, -2.4817F, 4, 12, 4, 0.0F, false));
			RightLeg = new RendererModel(this);
			RightLeg.setRotationPoint(-1.9F, 1.0F, -10.0F);
			setRotationAngle(RightLeg, 1.501F, -2.7925F, 0.0349F);
			RightLeg.cubeList.add(new ModelBox(RightLeg, 0, 16, -2.6231F, 0.1571F, -21.9264F, 4, 12, 4, 0.0F, false));
			LeftLeg = new RendererModel(this);
			LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
			setRotationAngle(LeftLeg, -1.5708F, -0.5236F, -0.2094F);
			LeftLeg.cubeList.add(new ModelBox(LeftLeg, 16, 48, -7.7456F, 7.1316F, 7.9894F, 4, 12, 4, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			Head.render(f5);
			Body.render(f5);
			RightArm.render(f5);
			LeftArm.render(f5);
			RightLeg.render(f5);
			LeftLeg.render(f5);
		}

		public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4, float f5) {
			super.setRotationAngles(e, f, f1, f2, f3, f4, f5);
		}
	}
}
