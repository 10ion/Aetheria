package net.mcreator.aetheria;

import net.minecraftforge.registries.ForgeRegistries;
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
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.FollowMobGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

@Elementsaetheria.ModElement.Tag
public class MCreatorCakeSlime extends Elementsaetheria.ModElement {
	public static EntityType entity = null;

	public MCreatorCakeSlime(Elementsaetheria instance) {
		super(instance, 139);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity> create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("cakeslime")
				.setRegistryName("cakeslime");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -8522647, -1, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("cakeslime"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(CustomEntity.class, renderManager -> {
			return new MobRenderer(renderManager, new Modelcustom_model(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("aetheria:textures/cakeslime.png");
				}
			};
		});
	}

	public static class CustomEntity extends SlimeEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 6;
			setNoAI(false);
			enablePersistence();
		}

		@Override
		protected void registerGoals() {
			this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, (float) 6));
			this.goalSelector.addGoal(3, new FollowMobGoal(this, (float) 2, 15, 5));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
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
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class Modelcustom_model extends EntityModel<Entity> {
		private final RendererModel Animation1;

		public Modelcustom_model() {
			textureWidth = 32;
			textureHeight = 32;
			Animation1 = new RendererModel(this);
			Animation1.setRotationPoint(0.0F, 24.0F, 0.0F);
			Animation1.cubeList.add(new ModelBox(Animation1, 0, 13, -1.0F, -3.0F, 2.0F, 1, 3, 2, 0.0F, false));
			Animation1.cubeList.add(new ModelBox(Animation1, 0, 0, -1.0F, -3.0F, -3.0F, 1, 3, 2, 0.0F, false));
			Animation1.cubeList.add(new ModelBox(Animation1, 0, 0, -4.0F, -9.0F, -3.0F, 7, 6, 7, 0.0F, false));
			Animation1.cubeList.add(new ModelBox(Animation1, 0, 13, -4.0F, -10.0F, -3.0F, 5, 1, 7, 0.0F, false));
			Animation1.cubeList.add(new ModelBox(Animation1, 0, 5, -5.0F, -7.0F, 0.0F, 1, 1, 1, 0.0F, false));
			Animation1.cubeList.add(new ModelBox(Animation1, 0, 23, -4.0F, -11.0F, -1.0F, 1, 1, 3, 0.0F, false));
			Animation1.cubeList.add(new ModelBox(Animation1, 21, 0, -3.0F, -12.0F, -1.0F, 1, 1, 3, 0.0F, false));
			Animation1.cubeList.add(new ModelBox(Animation1, 20, 21, -3.0F, -7.0F, -4.0F, 4, 1, 1, 0.0F, false));
			Animation1.cubeList.add(new ModelBox(Animation1, 10, 21, -3.0F, -6.0F, -5.0F, 4, 1, 1, 0.0F, false));
			Animation1.cubeList.add(new ModelBox(Animation1, 0, 21, -3.0F, -5.0F, -6.0F, 4, 1, 1, 0.0F, false));
			Animation1.cubeList.add(new ModelBox(Animation1, 17, 15, -3.0F, -7.0F, 4.0F, 4, 1, 1, 0.0F, false));
			Animation1.cubeList.add(new ModelBox(Animation1, 17, 13, -3.0F, -6.0F, 5.0F, 4, 1, 1, 0.0F, false));
			Animation1.cubeList.add(new ModelBox(Animation1, 17, 17, -3.0F, -5.0F, 6.0F, 4, 1, 1, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			Animation1.render(f5);
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
