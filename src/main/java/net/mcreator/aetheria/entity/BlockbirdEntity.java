
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
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockState;

import net.mcreator.aetheria.itemgroup.AetheriaEntitiesItemGroup;
import net.mcreator.aetheria.AetheriaModElements;

import java.util.Random;

@AetheriaModElements.ModElement.Tag
public class BlockbirdEntity extends AetheriaModElements.ModElement {
	public static EntityType entity = null;
	public BlockbirdEntity(AetheriaModElements instance) {
		super(instance, 156);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("blockbird")
						.setRegistryName("blockbird");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -3407821, -3407668, new Item.Properties().group(AetheriaEntitiesItemGroup.tab))
				.setRegistryName("blockbird"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("forest")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("taiga")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(entity, 20, 1, 5));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos,
						random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(CustomEntity.class, renderManager -> {
			return new MobRenderer(renderManager, new blockbird(), 0.5f) {
				@Override
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("aetheria:textures/blockbirdtexture.png");
				}
			};
		});
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 5;
			setNoAI(false);
			this.moveController = new FlyingMovementController(this);
			this.navigator = new FlyingPathNavigator(this, this.world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.8, 20) {
				@Override
				protected Vec3d getPosition() {
					Random random = CustomEntity.this.getRNG();
					double dir_x = CustomEntity.this.posX + ((random.nextFloat() * 2 - 1) * 16);
					double dir_y = CustomEntity.this.posY + ((random.nextFloat() * 2 - 1) * 16);
					double dir_z = CustomEntity.this.posZ + ((random.nextFloat() * 2 - 1) * 16);
					return new Vec3d(dir_x, dir_y, dir_z);
				}
			});
			this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(4, new SwimGoal(this));
			this.goalSelector.addGoal(5, new LeapAtTargetGoal(this, (float) 0.8));
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
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("aetheria:keekuu"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.parrot.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.parrot.death"));
		}

		@Override
		public void fall(float l, float d) {
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
			if (this.getAttribute(SharedMonsterAttributes.FLYING_SPEED) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
			this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.3);
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}

		public void livingTick() {
			super.livingTick();
			this.setNoGravity(true);
		}
	}

	// Made with Blockbench 3.5.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public class blockbird extends EntityModel<Entity> {
		private final RendererModel blockbird;
		private final RendererModel bone;
		private final RendererModel rightwing;
		private final RendererModel leftwing;
		private final RendererModel rightleg;
		private final RendererModel leftleg;
		public blockbird() {
			textureWidth = 32;
			textureHeight = 32;
			blockbird = new RendererModel(this);
			blockbird.setRotationPoint(0.0F, 24.0F, 7.0F);
			blockbird.setTextureOffset(0, 2).addBox(-0.5F, -7.0F, -11.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			blockbird.setTextureOffset(0, 0).addBox(-3.5F, -9.0F, -10.0F, 7.0F, 6.0F, 7.0F, 0.0F, false);
			blockbird.setTextureOffset(0, 13).addBox(-3.5F, -10.0F, -10.0F, 7.0F, 1.0F, 5.0F, 0.0F, false);
			bone = new RendererModel(this);
			bone.setRotationPoint(0.0F, -10.0F, -9.0F);
			blockbird.addChild(bone);
			setRotationAngle(bone, 0.9599F, 0.0F, 0.0F);
			bone.setTextureOffset(0, 0).addBox(-1.1056F, -0.7149F, -0.5F, 2.0F, 0.0F, 2.0F, 0.0F, false);
			rightwing = new RendererModel(this);
			rightwing.setRotationPoint(-3.5F, -7.0F, -6.0F);
			blockbird.addChild(rightwing);
			rightwing.setTextureOffset(0, 19).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
			leftwing = new RendererModel(this);
			leftwing.setRotationPoint(3.5F, -7.0F, -6.0F);
			blockbird.addChild(leftwing);
			leftwing.setTextureOffset(0, 19).addBox(0.0F, 0.0F, -2.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
			rightleg = new RendererModel(this);
			rightleg.setRotationPoint(2.0F, -3.0F, -6.0F);
			blockbird.addChild(rightleg);
			rightleg.setTextureOffset(0, 4).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			rightleg.setTextureOffset(2, 2).addBox(-0.5F, 3.0F, -1.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
			leftleg = new RendererModel(this);
			leftleg.setRotationPoint(-2.0F, -3.0F, -6.0F);
			blockbird.addChild(leftleg);
			leftleg.setTextureOffset(2, 4).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
			leftleg.setTextureOffset(3, 3).addBox(-0.5F, 3.0F, -1.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			blockbird.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4, float f5) {
			super.setRotationAngles(e, f, f1, f2, f3, f4, f5);
			this.blockbird.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.blockbird.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.rightwing.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leftwing.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
