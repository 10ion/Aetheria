package net.mcreator.aetheria.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Blocks;

import net.mcreator.aetheria.block.PowederKegBlock;
import net.mcreator.aetheria.AetheriaModElements;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

@AetheriaModElements.ModElement.Tag
public class AeonguicodeProcedure extends AetheriaModElements.ModElement {
	public AeonguicodeProcedure(AetheriaModElements instance) {
		super(instance, 397);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Aeonguicode!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Aeonguicode!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Aeonguicode!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Aeonguicode!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((((new Object() {
			public int getAmount(BlockPos pos, int sltid) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).getCount());
					});
				}
				return _retval.get();
			}
		}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (0))) < 64) && ((((new Object() {
			public ItemStack getItemStack(BlockPos pos, int sltid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
				}
				return _retval.get();
			}
		}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1))).getItem() == new ItemStack(Blocks.OAK_PLANKS, (int) (1)).getItem())
				&& (((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (2))).getItem() == new ItemStack(Blocks.RAIL, (int) (1)).getItem())
						&& (((new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (3))).getItem() == new ItemStack(Blocks.RAIL, (int) (1))
								.getItem()) && (((new Object() {
									public ItemStack getItemStack(BlockPos pos, int sltid) {
										AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
										}
										return _retval.get();
									}
								}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (4))).getItem() == new ItemStack(Blocks.RAIL, (int) (1))
										.getItem()) && (((new Object() {
											public ItemStack getItemStack(BlockPos pos, int sltid) {
												AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
												TileEntity _ent = world.getTileEntity(pos);
												if (_ent != null) {
													_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
														_retval.set(capability.getStackInSlot(sltid).copy());
													});
												}
												return _retval.get();
											}
										}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (5)))
												.getItem() == new ItemStack(Blocks.OAK_PLANKS, (int) (1)).getItem()) && (((new Object() {
													public ItemStack getItemStack(BlockPos pos, int sltid) {
														AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
														TileEntity _ent = world.getTileEntity(pos);
														if (_ent != null) {
															_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																	.ifPresent(capability -> {
																		_retval.set(capability.getStackInSlot(sltid).copy());
																	});
														}
														return _retval.get();
													}
												}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (6)))
														.getItem() == new ItemStack(Blocks.RAIL, (int) (1)).getItem()) && (((new Object() {
															public ItemStack getItemStack(BlockPos pos, int sltid) {
																AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
																TileEntity _ent = world.getTileEntity(pos);
																if (_ent != null) {
																	_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																			.ifPresent(capability -> {
																				_retval.set(capability.getStackInSlot(sltid).copy());
																			});
																}
																return _retval.get();
															}
														}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (7)))
																.getItem() == new ItemStack(Items.GUNPOWDER, (int) (1)).getItem())
																&& (((new Object() {
																	public ItemStack getItemStack(BlockPos pos, int sltid) {
																		AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
																		TileEntity _ent = world.getTileEntity(pos);
																		if (_ent != null) {
																			_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																					.ifPresent(capability -> {
																						_retval.set(capability.getStackInSlot(sltid).copy());
																					});
																		}
																		return _retval.get();
																	}
																}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (8)))
																		.getItem() == new ItemStack(Items.GUNPOWDER, (int) (1)).getItem())
																		&& (((new Object() {
																			public ItemStack getItemStack(BlockPos pos, int sltid) {
																				AtomicReference<ItemStack> _retval = new AtomicReference<>(
																						ItemStack.EMPTY);
																				TileEntity _ent = world.getTileEntity(pos);
																				if (_ent != null) {
																					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,
																							null).ifPresent(capability -> {
																								_retval.set(capability.getStackInSlot(sltid).copy());
																							});
																				}
																				return _retval.get();
																			}
																		}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (9)))
																				.getItem() == new ItemStack(Items.GUNPOWDER, (int) (1)).getItem())
																				&& (((new Object() {
																					public ItemStack getItemStack(BlockPos pos, int sltid) {
																						AtomicReference<ItemStack> _retval = new AtomicReference<>(
																								ItemStack.EMPTY);
																						TileEntity _ent = world.getTileEntity(pos);
																						if (_ent != null) {
																							_ent.getCapability(
																									CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,
																									null).ifPresent(capability -> {
																										_retval.set(capability.getStackInSlot(sltid)
																												.copy());
																									});
																						}
																						return _retval.get();
																					}
																				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (10)))
																						.getItem() == new ItemStack(Blocks.RAIL, (int) (1)).getItem())
																						&& (((new Object() {
																							public ItemStack getItemStack(BlockPos pos, int sltid) {
																								AtomicReference<ItemStack> _retval = new AtomicReference<>(
																										ItemStack.EMPTY);
																								TileEntity _ent = world.getTileEntity(pos);
																								if (_ent != null) {
																									_ent.getCapability(
																											CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,
																											null).ifPresent(capability -> {
																												_retval.set(capability
																														.getStackInSlot(sltid)
																														.copy());
																											});
																								}
																								return _retval.get();
																							}
																						}.getItemStack(new BlockPos((int) x, (int) y, (int) z),
																								(int) (11)))
																										.getItem() == new ItemStack(Blocks.RAIL,
																												(int) (1)).getItem())
																								&& (((new Object() {
																									public ItemStack getItemStack(BlockPos pos,
																											int sltid) {
																										AtomicReference<ItemStack> _retval = new AtomicReference<>(
																												ItemStack.EMPTY);
																										TileEntity _ent = world.getTileEntity(pos);
																										if (_ent != null) {
																											_ent.getCapability(
																													CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,
																													null).ifPresent(capability -> {
																														_retval.set(capability
																																.getStackInSlot(sltid)
																																.copy());
																													});
																										}
																										return _retval.get();
																									}
																								}.getItemStack(
																										new BlockPos((int) x, (int) y, (int) z),
																										(int) (12)))
																												.getItem() == new ItemStack(
																														Items.GUNPOWDER, (int) (1))
																																.getItem())
																										&& (((new Object() {
																											public ItemStack getItemStack(
																													BlockPos pos, int sltid) {
																												AtomicReference<ItemStack> _retval = new AtomicReference<>(
																														ItemStack.EMPTY);
																												TileEntity _ent = world
																														.getTileEntity(pos);
																												if (_ent != null) {
																													_ent.getCapability(
																															CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,
																															null)
																															.ifPresent(capability -> {
																																_retval.set(capability
																																		.getStackInSlot(
																																				sltid)
																																		.copy());
																															});
																												}
																												return _retval.get();
																											}
																										}.getItemStack(
																												new BlockPos((int) x, (int) y,
																														(int) z),
																												(int) (13)))
																														.getItem() == new ItemStack(
																																Blocks.TNT, (int) (1))
																																		.getItem())
																												&& (((new Object() {
																													public ItemStack getItemStack(
																															BlockPos pos, int sltid) {
																														AtomicReference<ItemStack> _retval = new AtomicReference<>(
																																ItemStack.EMPTY);
																														TileEntity _ent = world
																																.getTileEntity(pos);
																														if (_ent != null) {
																															_ent.getCapability(
																																	CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,
																																	null).ifPresent(
																																			capability -> {
																																				_retval.set(
																																						capability
																																								.getStackInSlot(
																																										sltid)
																																								.copy());
																																			});
																														}
																														return _retval.get();
																													}
																												}.getItemStack(
																														new BlockPos((int) x, (int) y,
																																(int) z),
																														(int) (14)))
																																.getItem() == new ItemStack(
																																		Items.GUNPOWDER,
																																		(int) (1))
																																				.getItem())
																														&& (((new Object() {
																															public ItemStack getItemStack(
																																	BlockPos pos,
																																	int sltid) {
																																AtomicReference<ItemStack> _retval = new AtomicReference<>(
																																		ItemStack.EMPTY);
																																TileEntity _ent = world
																																		.getTileEntity(
																																				pos);
																																if (_ent != null) {
																																	_ent.getCapability(
																																			CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,
																																			null)
																																			.ifPresent(
																																					capability -> {
																																						_retval.set(
																																								capability
																																										.getStackInSlot(
																																												sltid)
																																										.copy());
																																					});
																																}
																																return _retval.get();
																															}
																														}.getItemStack(
																																new BlockPos((int) x,
																																		(int) y,
																																		(int) z),
																																(int) (15)))
																																		.getItem() == new ItemStack(
																																				Blocks.RAIL,
																																				(int) (1))
																																						.getItem())
																																&& (((new Object() {
																																	public ItemStack getItemStack(
																																			BlockPos pos,
																																			int sltid) {
																																		AtomicReference<ItemStack> _retval = new AtomicReference<>(
																																				ItemStack.EMPTY);
																																		TileEntity _ent = world
																																				.getTileEntity(
																																						pos);
																																		if (_ent != null) {
																																			_ent.getCapability(
																																					CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,
																																					null)
																																					.ifPresent(
																																							capability -> {
																																								_retval.set(
																																										capability
																																												.getStackInSlot(
																																														sltid)
																																												.copy());
																																							});
																																		}
																																		return _retval
																																				.get();
																																	}
																																}.getItemStack(
																																		new BlockPos(
																																				(int) x,
																																				(int) y,
																																				(int) z),
																																		(int) (16)))
																																				.getItem() == new ItemStack(
																																						Blocks.RAIL,
																																						(int) (1))
																																								.getItem())
																																		&& (((new Object() {
																																			public ItemStack getItemStack(
																																					BlockPos pos,
																																					int sltid) {
																																				AtomicReference<ItemStack> _retval = new AtomicReference<>(
																																						ItemStack.EMPTY);
																																				TileEntity _ent = world
																																						.getTileEntity(
																																								pos);
																																				if (_ent != null) {
																																					_ent.getCapability(
																																							CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,
																																							null)
																																							.ifPresent(
																																									capability -> {
																																										_retval.set(
																																												capability
																																														.getStackInSlot(
																																																sltid)
																																														.copy());
																																									});
																																				}
																																				return _retval
																																						.get();
																																			}
																																		}.getItemStack(
																																				new BlockPos(
																																						(int) x,
																																						(int) y,
																																						(int) z),
																																				(int) (17)))
																																						.getItem() == new ItemStack(
																																								Items.GUNPOWDER,
																																								(int) (1))
																																										.getItem())
																																				&& (((new Object() {
																																					public ItemStack getItemStack(
																																							BlockPos pos,
																																							int sltid) {
																																						AtomicReference<ItemStack> _retval = new AtomicReference<>(
																																								ItemStack.EMPTY);
																																						TileEntity _ent = world
																																								.getTileEntity(
																																										pos);
																																						if (_ent != null) {
																																							_ent.getCapability(
																																									CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,
																																									null)
																																									.ifPresent(
																																											capability -> {
																																												_retval.set(
																																														capability
																																																.getStackInSlot(
																																																		sltid)
																																																.copy());
																																											});
																																						}
																																						return _retval
																																								.get();
																																					}
																																				}.getItemStack(
																																						new BlockPos(
																																								(int) x,
																																								(int) y,
																																								(int) z),
																																						(int) (18)))
																																								.getItem() == new ItemStack(
																																										Items.GUNPOWDER,
																																										(int) (1))
																																												.getItem())
																																						&& (((new Object() {
																																							public ItemStack getItemStack(
																																									BlockPos pos,
																																									int sltid) {
																																								AtomicReference<ItemStack> _retval = new AtomicReference<>(
																																										ItemStack.EMPTY);
																																								TileEntity _ent = world
																																										.getTileEntity(
																																												pos);
																																								if (_ent != null) {
																																									_ent.getCapability(
																																											CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,
																																											null)
																																											.ifPresent(
																																													capability -> {
																																														_retval.set(
																																																capability
																																																		.getStackInSlot(
																																																				sltid)
																																																		.copy());
																																													});
																																								}
																																								return _retval
																																										.get();
																																							}
																																						}.getItemStack(
																																								new BlockPos(
																																										(int) x,
																																										(int) y,
																																										(int) z),
																																								(int) (19)))
																																										.getItem() == new ItemStack(
																																												Items.GUNPOWDER,
																																												(int) (1))
																																														.getItem())
																																								&& (((new Object() {
																																									public ItemStack getItemStack(
																																											BlockPos pos,
																																											int sltid) {
																																										AtomicReference<ItemStack> _retval = new AtomicReference<>(
																																												ItemStack.EMPTY);
																																										TileEntity _ent = world
																																												.getTileEntity(
																																														pos);
																																										if (_ent != null) {
																																											_ent.getCapability(
																																													CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,
																																													null)
																																													.ifPresent(
																																															capability -> {
																																																_retval.set(
																																																		capability
																																																				.getStackInSlot(
																																																						sltid)
																																																				.copy());
																																															});
																																										}
																																										return _retval
																																												.get();
																																									}
																																								}.getItemStack(
																																										new BlockPos(
																																												(int) x,
																																												(int) y,
																																												(int) z),
																																										(int) (20)))
																																												.getItem() == new ItemStack(
																																														Blocks.RAIL,
																																														(int) (1))
																																																.getItem())
																																										&& (((new Object() {
																																											public ItemStack getItemStack(
																																													BlockPos pos,
																																													int sltid) {
																																												AtomicReference<ItemStack> _retval = new AtomicReference<>(
																																														ItemStack.EMPTY);
																																												TileEntity _ent = world
																																														.getTileEntity(
																																																pos);
																																												if (_ent != null) {
																																													_ent.getCapability(
																																															CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,
																																															null)
																																															.ifPresent(
																																																	capability -> {
																																																		_retval.set(
																																																				capability
																																																						.getStackInSlot(
																																																								sltid)
																																																						.copy());
																																																	});
																																												}
																																												return _retval
																																														.get();
																																											}
																																										}.getItemStack(
																																												new BlockPos(
																																														(int) x,
																																														(int) y,
																																														(int) z),
																																												(int) (21)))
																																														.getItem() == new ItemStack(
																																																Blocks.OAK_PLANKS,
																																																(int) (1))
																																																		.getItem())
																																												&& (((new Object() {
																																													public ItemStack getItemStack(
																																															BlockPos pos,
																																															int sltid) {
																																														AtomicReference<ItemStack> _retval = new AtomicReference<>(
																																																ItemStack.EMPTY);
																																														TileEntity _ent = world
																																																.getTileEntity(
																																																		pos);
																																														if (_ent != null) {
																																															_ent.getCapability(
																																																	CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,
																																																	null)
																																																	.ifPresent(
																																																			capability -> {
																																																				_retval.set(
																																																						capability
																																																								.getStackInSlot(
																																																										sltid)
																																																								.copy());
																																																			});
																																														}
																																														return _retval
																																																.get();
																																													}
																																												}.getItemStack(
																																														new BlockPos(
																																																(int) x,
																																																(int) y,
																																																(int) z),
																																														(int) (22)))
																																																.getItem() == new ItemStack(
																																																		Blocks.RAIL,
																																																		(int) (1))
																																																				.getItem())
																																														&& (((new Object() {
																																															public ItemStack getItemStack(
																																																	BlockPos pos,
																																																	int sltid) {
																																																AtomicReference<ItemStack> _retval = new AtomicReference<>(
																																																		ItemStack.EMPTY);
																																																TileEntity _ent = world
																																																		.getTileEntity(
																																																				pos);
																																																if (_ent != null) {
																																																	_ent.getCapability(
																																																			CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,
																																																			null)
																																																			.ifPresent(
																																																					capability -> {
																																																						_retval.set(
																																																								capability
																																																										.getStackInSlot(
																																																												sltid)
																																																										.copy());
																																																					});
																																																}
																																																return _retval
																																																		.get();
																																															}
																																														}.getItemStack(
																																																new BlockPos(
																																																		(int) x,
																																																		(int) y,
																																																		(int) z),
																																																(int) (23)))
																																																		.getItem() == new ItemStack(
																																																				Blocks.RAIL,
																																																				(int) (1))
																																																						.getItem())
																																																&& (((new Object() {
																																																	public ItemStack getItemStack(
																																																			BlockPos pos,
																																																			int sltid) {
																																																		AtomicReference<ItemStack> _retval = new AtomicReference<>(
																																																				ItemStack.EMPTY);
																																																		TileEntity _ent = world
																																																				.getTileEntity(
																																																						pos);
																																																		if (_ent != null) {
																																																			_ent.getCapability(
																																																					CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,
																																																					null)
																																																					.ifPresent(
																																																							capability -> {
																																																								_retval.set(
																																																										capability
																																																												.getStackInSlot(
																																																														sltid)
																																																												.copy());
																																																							});
																																																		}
																																																		return _retval
																																																				.get();
																																																	}
																																																}.getItemStack(
																																																		new BlockPos(
																																																				(int) x,
																																																				(int) y,
																																																				(int) z),
																																																		(int) (24)))
																																																				.getItem() == new ItemStack(
																																																						Blocks.RAIL,
																																																						(int) (1))
																																																								.getItem())
																																																		&& ((new Object() {
																																																			public ItemStack getItemStack(
																																																					BlockPos pos,
																																																					int sltid) {
																																																				AtomicReference<ItemStack> _retval = new AtomicReference<>(
																																																						ItemStack.EMPTY);
																																																				TileEntity _ent = world
																																																						.getTileEntity(
																																																								pos);
																																																				if (_ent != null) {
																																																					_ent.getCapability(
																																																							CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,
																																																							null)
																																																							.ifPresent(
																																																									capability -> {
																																																										_retval.set(
																																																												capability
																																																														.getStackInSlot(
																																																																sltid)
																																																														.copy());
																																																									});
																																																				}
																																																				return _retval
																																																						.get();
																																																			}
																																																		}.getItemStack(
																																																				new BlockPos(
																																																						(int) x,
																																																						(int) y,
																																																						(int) z),
																																																				(int) (25)))
																																																						.getItem() == new ItemStack(
																																																								Blocks.OAK_PLANKS,
																																																								(int) (1))
																																																										.getItem())))))))))))))))))))))))))
				&& ((((new Object() {
					public int getAmount(BlockPos pos, int sltid) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).getCount());
							});
						}
						return _retval.get();
					}
				}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (0))) <= 63) && ((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(PowederKegBlock.block, (int) (1))
						.getItem())) || ((new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0)))
								.getItem() == new ItemStack(PowederKegBlock.block, (int) (1)).getItem()))))) {
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (0);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (1);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (2);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (3);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (4);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (5);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (6);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (7);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (8);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (9);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (10);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (11);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (12);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (13);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (14);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (15);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (16);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (17);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (18);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (19);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (20);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (21);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (22);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (23);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (24);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (25);
					final int _amount = (int) 1;
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							ItemStack _stk = capability.getStackInSlot(_sltid).copy();
							_stk.shrink(_amount);
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
						}
					});
				}
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (_ent != null) {
					final int _sltid = (int) (0);
					final ItemStack _setstack = new ItemStack(PowederKegBlock.block, (int) (1));
					_setstack.setCount((int) ((new Object() {
						public int getAmount(BlockPos pos, int sltid) {
							AtomicInteger _retval = new AtomicInteger(0);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).getCount());
								});
							}
							return _retval.get();
						}
					}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (0))) + 1));
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
						}
					});
				}
			}
		}
	}
}
