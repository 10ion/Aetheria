
package net.mcreator.aetheria.world.dimension;

import org.jline.terminal.Size;

import org.apache.logging.log4j.util.Supplier;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.server.TicketType;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.layer.traits.IC0Transformer;
import net.minecraft.world.gen.layer.ZoomLayer;
import net.minecraft.world.gen.layer.VoroniZoomLayer;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.IslandLayer;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.NetherGenSettings;
import net.minecraft.world.gen.NetherChunkGenerator;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.world.Teleporter;
import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.ColumnPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.potion.EffectInstance;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.NetherPortalBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.aetheria.item.Dim99Item;
import net.mcreator.aetheria.block.StyxWaterBlock;
import net.mcreator.aetheria.AetheriaModElements;

import javax.annotation.Nullable;

import java.util.function.LongFunction;
import java.util.function.BiFunction;
import java.util.Set;
import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.Collections;

import it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2LongMap;

import com.google.common.collect.Sets;
import com.google.common.collect.Maps;
import com.google.common.cache.LoadingCache;

@AetheriaModElements.ModElement.Tag
public class Dim99Dimension extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:dim_9_9")
	public static final ModDimension dimension = null;
	@ObjectHolder("aetheria:dim_9_9_portal")
	public static final CustomPortalBlock portal = null;
	public static DimensionType type = null;
	private static Biome[] dimensionBiomes;
	public Dim99Dimension(AetheriaModElements instance) {
		super(instance, 501);
		MinecraftForge.EVENT_BUS.register(this);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerDimension(RegistryEvent.Register<ModDimension> event) {
		event.getRegistry().register(new CustomModDimension().setRegistryName("dim_9_9"));
	}

	@SubscribeEvent
	public void onRegisterDimensionsEvent(RegisterDimensionsEvent event) {
		if (DimensionType.byName(new ResourceLocation("aetheria:dim_9_9")) == null) {
			DimensionManager.registerDimension(new ResourceLocation("aetheria:dim_9_9"), dimension, null, false);
		}
		type = DimensionType.byName(new ResourceLocation("aetheria:dim_9_9"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		dimensionBiomes = new Biome[]{ForgeRegistries.BIOMES.getValue(new ResourceLocation("aetheria:soulless_plains")),};
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomPortalBlock());
		elements.items.add(() -> new Dim99Item().setRegistryName("dim_9_9"));
	}
	public static class CustomPortalBlock extends NetherPortalBlock {
		public CustomPortalBlock() {
			super(Block.Properties.create(Material.PORTAL).doesNotBlockMovement().tickRandomly().hardnessAndResistance(-1.0F).sound(SoundType.GLASS)
					.lightValue(0).noDrops());
			setRegistryName("dim_9_9_portal");
		}

		@Override
		public void tick(BlockState state, World world, BlockPos pos, Random random) {
		}

		public void portalSpawn(World world, BlockPos pos) {
			CustomPortalBlock.Size portalsize = this.isValid(world, pos);
			if (portalsize != null)
				portalsize.placePortalBlocks();
		}

		@Nullable
		public CustomPortalBlock.Size isValid(IWorld p_201816_1_, BlockPos p_201816_2_) {
			CustomPortalBlock.Size netherportalblock$size = new CustomPortalBlock.Size(p_201816_1_, p_201816_2_, Direction.Axis.X);
			if (netherportalblock$size.isValid() && netherportalblock$size.portalBlockCount == 0) {
				return netherportalblock$size;
			} else {
				CustomPortalBlock.Size netherportalblock$size1 = new CustomPortalBlock.Size(p_201816_1_, p_201816_2_, Direction.Axis.Z);
				return netherportalblock$size1.isValid() && netherportalblock$size1.portalBlockCount == 0 ? netherportalblock$size1 : null;
			}
		}

		@Override
		public BlockPattern.PatternHelper createPatternHelper(IWorld worldIn, BlockPos p_181089_2_) {
			Direction.Axis direction$axis = Direction.Axis.Z;
			CustomPortalBlock.Size netherportalblock$size = new CustomPortalBlock.Size(worldIn, p_181089_2_, Direction.Axis.X);
			LoadingCache<BlockPos, CachedBlockInfo> loadingcache = BlockPattern.createLoadingCache(worldIn, true);
			if (!netherportalblock$size.isValid()) {
				direction$axis = Direction.Axis.X;
				netherportalblock$size = new CustomPortalBlock.Size(worldIn, p_181089_2_, Direction.Axis.Z);
			}
			if (!netherportalblock$size.isValid()) {
				return new BlockPattern.PatternHelper(p_181089_2_, Direction.NORTH, Direction.UP, loadingcache, 1, 1, 1);
			} else {
				int[] aint = new int[Direction.AxisDirection.values().length];
				Direction direction = netherportalblock$size.rightDir.rotateYCCW();
				BlockPos blockpos = netherportalblock$size.bottomLeft.up(netherportalblock$size.getHeight() - 1);
				for (Direction.AxisDirection direction$axisdirection : Direction.AxisDirection.values()) {
					BlockPattern.PatternHelper blockpattern$patternhelper = new BlockPattern.PatternHelper(
							direction.getAxisDirection() == direction$axisdirection
									? blockpos
									: blockpos.offset(netherportalblock$size.rightDir, netherportalblock$size.getWidth() - 1),
							Direction.getFacingFromAxis(direction$axisdirection, direction$axis), Direction.UP, loadingcache,
							netherportalblock$size.getWidth(), netherportalblock$size.getHeight(), 1);
					for (int i = 0; i < netherportalblock$size.getWidth(); ++i) {
						for (int j = 0; j < netherportalblock$size.getHeight(); ++j) {
							CachedBlockInfo cachedblockinfo = blockpattern$patternhelper.translateOffset(i, j, 1);
							if (!cachedblockinfo.getBlockState().isAir()) {
								++aint[direction$axisdirection.ordinal()];
							}
						}
					}
				}
				Direction.AxisDirection direction$axisdirection1 = Direction.AxisDirection.POSITIVE;
				for (Direction.AxisDirection direction$axisdirection2 : Direction.AxisDirection.values()) {
					if (aint[direction$axisdirection2.ordinal()] < aint[direction$axisdirection1.ordinal()]) {
						direction$axisdirection1 = direction$axisdirection2;
					}
				}
				return new BlockPattern.PatternHelper(
						direction.getAxisDirection() == direction$axisdirection1
								? blockpos
								: blockpos.offset(netherportalblock$size.rightDir, netherportalblock$size.getWidth() - 1),
						Direction.getFacingFromAxis(direction$axisdirection1, direction$axis), Direction.UP, loadingcache,
						netherportalblock$size.getWidth(), netherportalblock$size.getHeight(), 1);
			}
		}

		@Override /**
					 * Update the provided state given the provided neighbor facing and neighbor
					 * state, returning a new state. For example, fences make their connections to
					 * the passed in state if possible, and wet concrete powder immediately returns
					 * its solidified counterpart. Note that this method should ideally consider
					 * only the specific face passed in.
					 */
		public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos,
				BlockPos facingPos) {
			Direction.Axis direction$axis = facing.getAxis();
			Direction.Axis direction$axis1 = stateIn.get(AXIS);
			boolean flag = direction$axis1 != direction$axis && direction$axis.isHorizontal();
			return !flag && facingState.getBlock() != this && !(new CustomPortalBlock.Size(worldIn, currentPos, direction$axis1)).func_208508_f()
					? Blocks.AIR.getDefaultState()
					: super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
			for (int i = 0; i < 4; i++) {
				double px = pos.getX() + random.nextFloat();
				double py = pos.getY() + random.nextFloat();
				double pz = pos.getZ() + random.nextFloat();
				double vx = (random.nextFloat() - 0.5) / 2f;
				double vy = (random.nextFloat() - 0.5) / 2f;
				double vz = (random.nextFloat() - 0.5) / 2f;
				int j = random.nextInt(4) - 1;
				if (world.getBlockState(pos.west()).getBlock() != this && world.getBlockState(pos.east()).getBlock() != this) {
					px = pos.getX() + 0.5 + 0.25 * j;
					vx = random.nextFloat() * 2 * j;
				} else {
					pz = pos.getZ() + 0.5 + 0.25 * j;
					vz = random.nextFloat() * 2 * j;
				}
				world.addParticle(ParticleTypes.PORTAL, px, py, pz, vx, vy, vz);
			}
			if (random.nextInt(110) == 0)
				world.playSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(("block.portal.ambient"))),
						SoundCategory.BLOCKS, 0.5f, random.nextFloat() * 0.4F + 0.8F, false);
		}

		public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
			if (!world.isRemote && !entity.isPassenger() && !entity.isBeingRidden() && entity instanceof ServerPlayerEntity) {
				ServerPlayerEntity player = (ServerPlayerEntity) entity;
				if (player.timeUntilPortal > 0) {
					player.timeUntilPortal = 10;
				} else if (player.dimension != type) {
					player.timeUntilPortal = 10;
					teleportToDimension(player, type);
				} else {
					player.timeUntilPortal = 10;
					teleportToDimension(player, DimensionType.OVERWORLD);
				}
			}
		}

		private void teleportToDimension(ServerPlayerEntity player, DimensionType destinationType) {
			ObfuscationReflectionHelper.setPrivateValue(ServerPlayerEntity.class, player, true, "field_184851_cj");
			ServerWorld nextWorld = player.getServer().getWorld(destinationType);
			TeleporterDimensionMod teleporter = getTeleporterForDimension(player, player.getPosition(), nextWorld);
			player.connection.sendPacket(new SChangeGameStatePacket(4, 0));
			if (!teleporter.func_222268_a(player, player.rotationYaw)) {
				teleporter.makePortal(player);
				teleporter.func_222268_a(player, player.rotationYaw);
			}
			player.teleport(nextWorld, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ(), player.rotationYaw,
					player.rotationPitch);
			player.connection.sendPacket(new SPlayerAbilitiesPacket(player.abilities));
			for (EffectInstance effectinstance : player.getActivePotionEffects()) {
				player.connection.sendPacket(new SPlayEntityEffectPacket(player.getEntityId(), effectinstance));
			}
			player.connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
		}

		private TeleporterDimensionMod getTeleporterForDimension(Entity entity, BlockPos pos, ServerWorld nextWorld) {
			BlockPattern.PatternHelper bph = portal.createPatternHelper(entity.world, new BlockPos(pos));
			double d0 = bph.getForwards().getAxis() == Direction.Axis.X
					? (double) bph.getFrontTopLeft().getZ()
					: (double) bph.getFrontTopLeft().getX();
			double d1 = bph.getForwards().getAxis() == Direction.Axis.X ? entity.posZ : entity.posX;
			d1 = Math.abs(MathHelper.pct(d1 - (double) (bph.getForwards().rotateY().getAxisDirection() == Direction.AxisDirection.NEGATIVE ? 1 : 0),
					d0, d0 - (double) bph.getWidth()));
			double d2 = MathHelper.pct(entity.posY - 1, (double) bph.getFrontTopLeft().getY(),
					(double) (bph.getFrontTopLeft().getY() - bph.getHeight()));
			return new TeleporterDimensionMod(nextWorld, new Vec3d(d1, d2, 0), bph.getForwards());
		}
		public static class Size {
			private final IWorld world;
			private final Direction.Axis axis;
			private final Direction rightDir;
			private final Direction leftDir;
			private int portalBlockCount;
			@Nullable
			private BlockPos bottomLeft;
			private int height;
			private int width;
			public Size(IWorld p_i48740_1_, BlockPos p_i48740_2_, Direction.Axis p_i48740_3_) {
				this.world = p_i48740_1_;
				this.axis = p_i48740_3_;
				if (p_i48740_3_ == Direction.Axis.X) {
					this.leftDir = Direction.EAST;
					this.rightDir = Direction.WEST;
				} else {
					this.leftDir = Direction.NORTH;
					this.rightDir = Direction.SOUTH;
				}
				for (BlockPos blockpos = p_i48740_2_; p_i48740_2_.getY() > blockpos.getY() - 21 && p_i48740_2_.getY() > 0
						&& this.func_196900_a(p_i48740_1_.getBlockState(p_i48740_2_.down())); p_i48740_2_ = p_i48740_2_.down()) {
					;
				}
				int i = this.getDistanceUntilEdge(p_i48740_2_, this.leftDir) - 1;
				if (i >= 0) {
					this.bottomLeft = p_i48740_2_.offset(this.leftDir, i);
					this.width = this.getDistanceUntilEdge(this.bottomLeft, this.rightDir);
					if (this.width < 2 || this.width > 21) {
						this.bottomLeft = null;
						this.width = 0;
					}
				}
				if (this.bottomLeft != null) {
					this.height = this.calculatePortalHeight();
				}
			}

			protected int getDistanceUntilEdge(BlockPos p_180120_1_, Direction p_180120_2_) {
				int i;
				for (i = 0; i < 22; ++i) {
					BlockPos blockpos = p_180120_1_.offset(p_180120_2_, i);
					if (!this.func_196900_a(this.world.getBlockState(blockpos))
							|| !(this.world.getBlockState(blockpos.down()).getBlock() == Blocks.SOUL_SAND.getDefaultState().getBlock())) {
						break;
					}
				}
				BlockPos framePos = p_180120_1_.offset(p_180120_2_, i);
				return (this.world.getBlockState(framePos).getBlock() == Blocks.SOUL_SAND.getDefaultState().getBlock()) ? i : 0;
			}

			public int getHeight() {
				return this.height;
			}

			public int getWidth() {
				return this.width;
			}

			protected int calculatePortalHeight() {
				label56 : for (this.height = 0; this.height < 21; ++this.height) {
					for (int i = 0; i < this.width; ++i) {
						BlockPos blockpos = this.bottomLeft.offset(this.rightDir, i).up(this.height);
						BlockState blockstate = this.world.getBlockState(blockpos);
						if (!this.func_196900_a(blockstate)) {
							break label56;
						}
						Block block = blockstate.getBlock();
						if (block == portal) {
							++this.portalBlockCount;
						}
						if (i == 0) {
							BlockPos framePos = blockpos.offset(this.leftDir);
							if (!(this.world.getBlockState(framePos).getBlock() == Blocks.SOUL_SAND.getDefaultState().getBlock())) {
								break label56;
							}
						} else if (i == this.width - 1) {
							BlockPos framePos = blockpos.offset(this.rightDir);
							if (!(this.world.getBlockState(framePos).getBlock() == Blocks.SOUL_SAND.getDefaultState().getBlock())) {
								break label56;
							}
						}
					}
				}
				for (int j = 0; j < this.width; ++j) {
					BlockPos framePos = this.bottomLeft.offset(this.rightDir, j).up(this.height);
					if (!(this.world.getBlockState(framePos).getBlock() == Blocks.SOUL_SAND.getDefaultState().getBlock())) {
						this.height = 0;
						break;
					}
				}
				if (this.height <= 21 && this.height >= 3) {
					return this.height;
				} else {
					this.bottomLeft = null;
					this.width = 0;
					this.height = 0;
					return 0;
				}
			}

			protected boolean func_196900_a(BlockState p_196900_1_) {
				Block block = p_196900_1_.getBlock();
				return p_196900_1_.isAir() || block == Blocks.FIRE || block == portal;
			}

			public boolean isValid() {
				return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
			}

			public void placePortalBlocks() {
				for (int i = 0; i < this.width; ++i) {
					BlockPos blockpos = this.bottomLeft.offset(this.rightDir, i);
					for (int j = 0; j < this.height; ++j) {
						this.world.setBlockState(blockpos.up(j), portal.getDefaultState().with(NetherPortalBlock.AXIS, this.axis), 18);
					}
				}
			}

			private boolean func_196899_f() {
				return this.portalBlockCount >= this.width * this.height;
			}

			public boolean func_208508_f() {
				return this.isValid() && this.func_196899_f();
			}
		}
	}

	public static class TeleporterDimensionMod extends Teleporter {
		private static final Logger LOGGER = LogManager.getLogger();
		private Vec3d lastPortalVec;
		private Direction teleportDirection;
		protected final ServerWorld world;
		protected final Random random;
		protected final Map<ColumnPos, TeleporterDimensionMod.PortalPosition> destinationCoordinateCache = Maps.newHashMapWithExpectedSize(4096);
		private final Object2LongMap<ColumnPos> field_222275_f = new Object2LongOpenHashMap();
		public TeleporterDimensionMod(ServerWorld worldServer, Vec3d lastPortalVec, Direction teleportDirection) {
			super(worldServer);
			this.world = worldServer;
			this.random = new Random(worldServer.getSeed());
			this.lastPortalVec = lastPortalVec;
			this.teleportDirection = teleportDirection;
			worldServer.customTeleporters.add(this);
		}

		@Override
		public boolean makePortal(Entity entityIn) {
			int i = 16;
			double d0 = -1.0D;
			int j = MathHelper.floor(entityIn.posX);
			int k = MathHelper.floor(entityIn.posY);
			int l = MathHelper.floor(entityIn.posZ);
			int i1 = j;
			int j1 = k;
			int k1 = l;
			int l1 = 0;
			int i2 = this.random.nextInt(4);
			BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
			for (int j2 = j - 16; j2 <= j + 16; ++j2) {
				double d1 = (double) j2 + 0.5D - entityIn.posX;
				for (int l2 = l - 16; l2 <= l + 16; ++l2) {
					double d2 = (double) l2 + 0.5D - entityIn.posZ;
					label276 : for (int j3 = this.world.getActualHeight() - 1; j3 >= 0; --j3) {
						if (this.world.isAirBlock(blockpos$mutableblockpos.setPos(j2, j3, l2))) {
							while (j3 > 0 && this.world.isAirBlock(blockpos$mutableblockpos.setPos(j2, j3 - 1, l2))) {
								--j3;
							}
							for (int k3 = i2; k3 < i2 + 4; ++k3) {
								int l3 = k3 % 2;
								int i4 = 1 - l3;
								if (k3 % 4 >= 2) {
									l3 = -l3;
									i4 = -i4;
								}
								for (int j4 = 0; j4 < 3; ++j4) {
									for (int k4 = 0; k4 < 4; ++k4) {
										for (int l4 = -1; l4 < 4; ++l4) {
											int i5 = j2 + (k4 - 1) * l3 + j4 * i4;
											int j5 = j3 + l4;
											int k5 = l2 + (k4 - 1) * i4 - j4 * l3;
											blockpos$mutableblockpos.setPos(i5, j5, k5);
											if (l4 < 0 && !this.world.getBlockState(blockpos$mutableblockpos).getMaterial().isSolid()
													|| l4 >= 0 && !this.world.isAirBlock(blockpos$mutableblockpos)) {
												continue label276;
											}
										}
									}
								}
								double d5 = (double) j3 + 0.5D - entityIn.posY;
								double d7 = d1 * d1 + d5 * d5 + d2 * d2;
								if (d0 < 0.0D || d7 < d0) {
									d0 = d7;
									i1 = j2;
									j1 = j3;
									k1 = l2;
									l1 = k3 % 4;
								}
							}
						}
					}
				}
			}
			if (d0 < 0.0D) {
				for (int l5 = j - 16; l5 <= j + 16; ++l5) {
					double d3 = (double) l5 + 0.5D - entityIn.posX;
					for (int j6 = l - 16; j6 <= l + 16; ++j6) {
						double d4 = (double) j6 + 0.5D - entityIn.posZ;
						label214 : for (int i7 = this.world.getActualHeight() - 1; i7 >= 0; --i7) {
							if (this.world.isAirBlock(blockpos$mutableblockpos.setPos(l5, i7, j6))) {
								while (i7 > 0 && this.world.isAirBlock(blockpos$mutableblockpos.setPos(l5, i7 - 1, j6))) {
									--i7;
								}
								for (int l7 = i2; l7 < i2 + 2; ++l7) {
									int l8 = l7 % 2;
									int k9 = 1 - l8;
									for (int i10 = 0; i10 < 4; ++i10) {
										for (int k10 = -1; k10 < 4; ++k10) {
											int i11 = l5 + (i10 - 1) * l8;
											int j11 = i7 + k10;
											int k11 = j6 + (i10 - 1) * k9;
											blockpos$mutableblockpos.setPos(i11, j11, k11);
											if (k10 < 0 && !this.world.getBlockState(blockpos$mutableblockpos).getMaterial().isSolid()
													|| k10 >= 0 && !this.world.isAirBlock(blockpos$mutableblockpos)) {
												continue label214;
											}
										}
									}
									double d6 = (double) i7 + 0.5D - entityIn.posY;
									double d8 = d3 * d3 + d6 * d6 + d4 * d4;
									if (d0 < 0.0D || d8 < d0) {
										d0 = d8;
										i1 = l5;
										j1 = i7;
										k1 = j6;
										l1 = l7 % 2;
									}
								}
							}
						}
					}
				}
			}
			int i6 = i1;
			int k2 = j1;
			int k6 = k1;
			int l6 = l1 % 2;
			int i3 = 1 - l6;
			if (l1 % 4 >= 2) {
				l6 = -l6;
				i3 = -i3;
			}
			if (d0 < 0.0D) {
				j1 = MathHelper.clamp(j1, 70, this.world.getActualHeight() - 10);
				k2 = j1;
				for (int j7 = -1; j7 <= 1; ++j7) {
					for (int i8 = 1; i8 < 3; ++i8) {
						for (int i9 = -1; i9 < 3; ++i9) {
							int l9 = i6 + (i8 - 1) * l6 + j7 * i3;
							int j10 = k2 + i9;
							int l10 = k6 + (i8 - 1) * i3 - j7 * l6;
							boolean flag = i9 < 0;
							blockpos$mutableblockpos.setPos(l9, j10, l10);
							this.world.setBlockState(blockpos$mutableblockpos,
									flag ? Blocks.SOUL_SAND.getDefaultState().getBlock().getDefaultState() : Blocks.AIR.getDefaultState());
						}
					}
				}
			}
			for (int k7 = -1; k7 < 3; ++k7) {
				for (int j8 = -1; j8 < 4; ++j8) {
					if (k7 == -1 || k7 == 2 || j8 == -1 || j8 == 3) {
						blockpos$mutableblockpos.setPos(i6 + k7 * l6, k2 + j8, k6 + k7 * i3);
						this.world.setBlockState(blockpos$mutableblockpos, Blocks.SOUL_SAND.getDefaultState().getBlock().getDefaultState(), 3);
					}
				}
			}
			BlockState blockstate = portal.getDefaultState().with(NetherPortalBlock.AXIS, l6 == 0 ? Direction.Axis.Z : Direction.Axis.X);
			for (int k8 = 0; k8 < 2; ++k8) {
				for (int j9 = 0; j9 < 3; ++j9) {
					blockpos$mutableblockpos.setPos(i6 + k8 * l6, k2 + j9, k6 + k8 * i3);
					this.world.setBlockState(blockpos$mutableblockpos, blockstate, 18);
				}
			}
			return true;
		}

		@Override
		@Nullable
		public BlockPattern.PortalInfo func_222272_a(BlockPos p_222272_1_, Vec3d p_222272_2_, Direction p_222272_3_, double p_222272_4_,
				double p_222272_6_, boolean p_222272_8_) {
			int i = 128;
			boolean flag = true;
			BlockPos blockpos = null;
			ColumnPos columnpos = new ColumnPos(p_222272_1_);
			if (!p_222272_8_ && this.field_222275_f.containsKey(columnpos)) {
				return null;
			} else {
				TeleporterDimensionMod.PortalPosition teleporter$portalposition = this.destinationCoordinateCache.get(columnpos);
				if (teleporter$portalposition != null) {
					blockpos = teleporter$portalposition.field_222267_a;
					teleporter$portalposition.lastUpdateTime = this.world.getGameTime();
					flag = false;
				} else {
					double d0 = Double.MAX_VALUE;
					for (int j = -128; j <= 128; ++j) {
						BlockPos blockpos2;
						for (int k = -128; k <= 128; ++k) {
							for (BlockPos blockpos1 = p_222272_1_.add(j, this.world.getActualHeight() - 1 - p_222272_1_.getY(), k); blockpos1
									.getY() >= 0; blockpos1 = blockpos2) {
								blockpos2 = blockpos1.down();
								if (this.world.getBlockState(blockpos1).getBlock() == portal) {
									for (blockpos2 = blockpos1.down(); this.world.getBlockState(blockpos2).getBlock() == portal; blockpos2 = blockpos2
											.down()) {
										blockpos1 = blockpos2;
									}
									double d1 = blockpos1.distanceSq(p_222272_1_);
									if (d0 < 0.0D || d1 < d0) {
										d0 = d1;
										blockpos = blockpos1;
									}
								}
							}
						}
					}
				}
				if (blockpos == null) {
					long l = this.world.getGameTime() + 300L;
					this.field_222275_f.put(columnpos, l);
					return null;
				} else {
					if (flag) {
						this.destinationCoordinateCache.put(columnpos, new TeleporterDimensionMod.PortalPosition(blockpos, this.world.getGameTime()));
						Logger logger = LOGGER;
						Supplier[] asupplier = new Supplier[2];
						Dimension dimension = this.world.getDimension();
						asupplier[0] = dimension::getType;
						asupplier[1] = () -> {
							return columnpos;
						};
						logger.debug("Adding nether portal ticket for {}:{}", asupplier);
						this.world.getChunkProvider().func_217228_a(TicketType.PORTAL, new ChunkPos(blockpos), 3, columnpos);
					}
					BlockPattern.PatternHelper blockpattern$patternhelper = portal.createPatternHelper(this.world, blockpos);
					return blockpattern$patternhelper.func_222504_a(p_222272_3_, blockpos, p_222272_6_, p_222272_2_, p_222272_4_);
				}
			}
		}

		@Override
		public boolean func_222268_a(Entity p_222268_1_, float p_222268_2_) {
			Vec3d vec3d = lastPortalVec;
			Direction direction = teleportDirection;
			BlockPattern.PortalInfo blockpattern$portalinfo = this.func_222272_a(new BlockPos(p_222268_1_), p_222268_1_.getMotion(), direction,
					vec3d.x, vec3d.y, p_222268_1_ instanceof PlayerEntity);
			if (blockpattern$portalinfo == null) {
				return false;
			} else {
				Vec3d vec3d1 = blockpattern$portalinfo.field_222505_a;
				Vec3d vec3d2 = blockpattern$portalinfo.field_222506_b;
				p_222268_1_.setMotion(vec3d2);
				p_222268_1_.rotationYaw = p_222268_2_ + (float) blockpattern$portalinfo.field_222507_c;
				if (p_222268_1_ instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) p_222268_1_).connection.setPlayerLocation(vec3d1.x, vec3d1.y, vec3d1.z, p_222268_1_.rotationYaw,
							p_222268_1_.rotationPitch);
					((ServerPlayerEntity) p_222268_1_).connection.captureCurrentPosition();
				} else {
					p_222268_1_.setLocationAndAngles(vec3d1.x, vec3d1.y, vec3d1.z, p_222268_1_.rotationYaw, p_222268_1_.rotationPitch);
				}
				return true;
			}
		}
		public static class PortalPosition {
			public final BlockPos field_222267_a;
			public long lastUpdateTime;
			public PortalPosition(BlockPos p_i50813_1_, long p_i50813_2_) {
				this.field_222267_a = p_i50813_1_;
				this.lastUpdateTime = p_i50813_2_;
			}
		}
	}

	public static class CustomModDimension extends ModDimension {
		@Override
		public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
			return CustomDimension::new;
		}
	}

	public static class CustomDimension extends Dimension {
		private BiomeProviderCustom biomeProviderCustom = null;
		public CustomDimension(World world, DimensionType type) {
			super(world, type);
			this.nether = true;
		}

		@Override
		public void calculateInitialWeather() {
		}

		@Override
		public void updateWeather(Runnable defaultWeather) {
		}

		@Override
		public boolean canDoLightning(Chunk chunk) {
			return false;
		}

		@Override
		public boolean canDoRainSnowIce(Chunk chunk) {
			return false;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public Vec3d getFogColor(float cangle, float ticks) {
			return new Vec3d(0.4, 0, 0);
		}

		@Override
		public ChunkGenerator<?> createChunkGenerator() {
			if (this.biomeProviderCustom == null) {
				this.biomeProviderCustom = new BiomeProviderCustom(this.world);
			}
			return new ChunkProviderModded(this.world, this.biomeProviderCustom);
		}

		@Override
		public boolean isSurfaceWorld() {
			return false;
		}

		@Override
		public boolean canRespawnHere() {
			return false;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public boolean doesXZShowFog(int x, int z) {
			return false;
		}

		@Override
		public SleepResult canSleepAt(PlayerEntity player, BlockPos pos) {
			return SleepResult.BED_EXPLODES;
		}

		@Nullable
		public BlockPos findSpawn(ChunkPos chunkPos, boolean checkValid) {
			return null;
		}

		@Nullable
		public BlockPos findSpawn(int x, int z, boolean checkValid) {
			return null;
		}

		@Override
		public boolean doesWaterVaporize() {
			return true;
		}

		@Override /**
					 * Calculates the angle of sun and moon in the sky relative to a specified time
					 * (usually worldTime)
					 */
		public float calculateCelestialAngle(long worldTime, float partialTicks) {
			double d0 = MathHelper.frac((double) worldTime / 24000.0D - 0.25D);
			double d1 = 0.5D - Math.cos(d0 * Math.PI) / 2.0D;
			return (float) (d0 * 2.0D + d1) / 3.0F;
		}
	}

	public static class ChunkProviderModded extends NetherChunkGenerator {
		public ChunkProviderModded(World world, BiomeProvider provider) {
			super(world, provider, new NetherGenSettings() {
				public BlockState getDefaultBlock() {
					return Blocks.SOUL_SAND.getDefaultState();
				}

				public BlockState getDefaultFluid() {
					return StyxWaterBlock.block.getDefaultState();
				}
			});
			this.randomSeed.skip(9716);
		}

		@Override
		public List<Biome.SpawnListEntry> getPossibleCreatures(EntityClassification creatureType, BlockPos pos) {
			return this.world.getBiome(pos).getSpawns(creatureType);
		}
	}

	public static class BiomeLayerCustom implements IC0Transformer {
		@Override
		public int apply(INoiseRandom context, int value) {
			return Registry.BIOME.getId(dimensionBiomes[context.random(dimensionBiomes.length)]);
		}
	}

	public static class BiomeProviderCustom extends BiomeProvider {
		private final Layer genBiomes;
		private final Layer biomeFactoryLayer;
		private final Biome[] biomes;
		public BiomeProviderCustom(World world) {
			Layer[] aLayer = makeTheWorld(world.getSeed());
			this.genBiomes = aLayer[0];
			this.biomeFactoryLayer = aLayer[1];
			this.biomes = dimensionBiomes;
		}

		private Layer[] makeTheWorld(long seed) {
			LongFunction<IExtendedNoiseRandom<LazyArea>> contextFactory = l -> new LazyAreaLayerContext(25, seed, l);
			IAreaFactory<LazyArea> parentLayer = IslandLayer.INSTANCE.apply(contextFactory.apply(1));
			IAreaFactory<LazyArea> biomeLayer = (new BiomeLayerCustom()).apply(contextFactory.apply(200), parentLayer);
			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1000), biomeLayer);
			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1001), biomeLayer);
			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1002), biomeLayer);
			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1003), biomeLayer);
			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1004), biomeLayer);
			biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1005), biomeLayer);
			IAreaFactory<LazyArea> voronoizoom = VoroniZoomLayer.INSTANCE.apply(contextFactory.apply(10), biomeLayer);
			return new Layer[]{new Layer(biomeLayer), new Layer(voronoizoom)};
		}

		@Override /**
					 * Gets the biome from the provided coordinates
					 */
		public Biome getBiome(int x, int y) {
			return this.biomeFactoryLayer.func_215738_a(x, y);
		}

		@Override
		public Biome func_222366_b(int p_222366_1_, int p_222366_2_) {
			return this.genBiomes.func_215738_a(p_222366_1_, p_222366_2_);
		}

		@Override
		public Biome[] getBiomes(int x, int z, int width, int length, boolean cacheFlag) {
			return this.biomeFactoryLayer.generateBiomes(x, z, width, length);
		}

		@Override
		public Set<Biome> getBiomesInSquare(int centerX, int centerZ, int sideLength) {
			int i = centerX - sideLength >> 2;
			int j = centerZ - sideLength >> 2;
			int k = centerX + sideLength >> 2;
			int l = centerZ + sideLength >> 2;
			int i1 = k - i + 1;
			int j1 = l - j + 1;
			Set<Biome> set = Sets.newHashSet();
			Collections.addAll(set, this.genBiomes.generateBiomes(i, j, i1, j1));
			return set;
		}

		@Override
		@Nullable
		public BlockPos findBiomePosition(int x, int z, int range, List<Biome> biomes, Random random) {
			int i = x - range >> 2;
			int j = z - range >> 2;
			int k = x + range >> 2;
			int l = z + range >> 2;
			int i1 = k - i + 1;
			int j1 = l - j + 1;
			Biome[] abiome = this.genBiomes.generateBiomes(i, j, i1, j1);
			BlockPos blockpos = null;
			int k1 = 0;
			for (int l1 = 0; l1 < i1 * j1; ++l1) {
				int i2 = i + l1 % i1 << 2;
				int j2 = j + l1 / i1 << 2;
				if (biomes.contains(abiome[l1])) {
					if (blockpos == null || random.nextInt(k1 + 1) == 0) {
						blockpos = new BlockPos(i2, 0, j2);
					}
					++k1;
				}
			}
			return blockpos;
		}

		@Override
		public boolean hasStructure(Structure<?> structureIn) {
			return this.hasStructureCache.computeIfAbsent(structureIn, (p_205006_1_) -> {
				for (Biome biome : this.biomes) {
					if (biome.hasStructure(p_205006_1_)) {
						return true;
					}
				}
				return false;
			});
		}

		@Override
		public Set<BlockState> getSurfaceBlocks() {
			if (this.topBlocksCache.isEmpty()) {
				for (Biome biome : this.biomes) {
					this.topBlocksCache.add(biome.getSurfaceBuilderConfig().getTop());
				}
			}
			return this.topBlocksCache;
		}
	}
}
