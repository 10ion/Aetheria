
package net.mcreator.aetheria.gui;

@AetheriaElements.ModElement.Tag
public class AeonForgeguiGui extends AetheriaElements.ModElement {

	public static HashMap guistate = new HashMap();

	private static ContainerType<GuiContainerMod> containerType = null;

	public AeonForgeguiGui(AetheriaElements instance) {
		super(instance, 396);

		elements.addNetworkMessage(ButtonPressedMessage.class, ButtonPressedMessage::buffer, ButtonPressedMessage::new,
				ButtonPressedMessage::handler);
		elements.addNetworkMessage(GUISlotChangedMessage.class, GUISlotChangedMessage::buffer, GUISlotChangedMessage::new,
				GUISlotChangedMessage::handler);

		containerType = new ContainerType<>(new GuiContainerModFactory());

		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@OnlyIn(Dist.CLIENT)
	public void initElements() {
		ScreenManager.registerFactory(containerType, GuiWindow::new);
	}

	@SubscribeEvent
	public void registerContainer(RegistryEvent.Register<ContainerType<?>> event) {
		event.getRegistry().register(containerType.setRegistryName("aeonforgegui"));
	}

	public static class GuiContainerModFactory implements IContainerFactory {

		public GuiContainerMod create(int id, PlayerInventory inv, PacketBuffer extraData) {
			return new GuiContainerMod(id, inv, extraData);
		}

	}

	public static class GuiContainerMod extends Container implements Supplier<Map<Integer, Slot>> {

		private World world;
		private PlayerEntity entity;
		private int x, y, z;

		private IInventory internal;

		private Map<Integer, Slot> customSlots = new HashMap<>();

		public GuiContainerMod(int id, PlayerInventory inv, PacketBuffer extraData) {
			super(containerType, id);

			this.entity = inv.player;
			this.world = inv.player.world;

			this.internal = new Inventory(26);

			if (extraData != null) {
				BlockPos pos = extraData.readBlockPos();
				this.x = pos.getX();
				this.y = pos.getY();
				this.z = pos.getZ();
				TileEntity ent = inv.player != null ? inv.player.world.getTileEntity(pos) : null;
				if (ent instanceof IInventory)
					this.internal = (IInventory) ent;
			}

			internal.openInventory(inv.player);

			this.customSlots.put(0, this.addSlot(new Slot(internal, 0, 134, 46) {

				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(1, this.addSlot(new Slot(internal, 1, 26, 10) {

			}));
			this.customSlots.put(2, this.addSlot(new Slot(internal, 2, 44, 10) {

			}));
			this.customSlots.put(3, this.addSlot(new Slot(internal, 3, 62, 10) {

			}));
			this.customSlots.put(4, this.addSlot(new Slot(internal, 4, 80, 10) {

			}));
			this.customSlots.put(5, this.addSlot(new Slot(internal, 5, 98, 10) {

			}));
			this.customSlots.put(6, this.addSlot(new Slot(internal, 6, 26, 28) {

			}));
			this.customSlots.put(7, this.addSlot(new Slot(internal, 7, 44, 28) {

			}));
			this.customSlots.put(8, this.addSlot(new Slot(internal, 8, 62, 28) {

			}));
			this.customSlots.put(9, this.addSlot(new Slot(internal, 9, 80, 28) {

			}));
			this.customSlots.put(10, this.addSlot(new Slot(internal, 10, 98, 28) {

			}));
			this.customSlots.put(11, this.addSlot(new Slot(internal, 11, 26, 46) {

			}));
			this.customSlots.put(12, this.addSlot(new Slot(internal, 12, 44, 46) {

			}));
			this.customSlots.put(13, this.addSlot(new Slot(internal, 13, 62, 46) {

			}));
			this.customSlots.put(14, this.addSlot(new Slot(internal, 14, 80, 46) {

			}));
			this.customSlots.put(15, this.addSlot(new Slot(internal, 15, 98, 46) {

			}));
			this.customSlots.put(16, this.addSlot(new Slot(internal, 16, 26, 64) {

			}));
			this.customSlots.put(17, this.addSlot(new Slot(internal, 17, 44, 64) {

			}));
			this.customSlots.put(18, this.addSlot(new Slot(internal, 18, 62, 64) {

			}));
			this.customSlots.put(19, this.addSlot(new Slot(internal, 19, 80, 64) {

			}));
			this.customSlots.put(20, this.addSlot(new Slot(internal, 20, 98, 64) {

			}));
			this.customSlots.put(21, this.addSlot(new Slot(internal, 21, 26, 82) {

			}));
			this.customSlots.put(22, this.addSlot(new Slot(internal, 22, 44, 82) {

			}));
			this.customSlots.put(23, this.addSlot(new Slot(internal, 23, 62, 82) {

			}));
			this.customSlots.put(24, this.addSlot(new Slot(internal, 24, 80, 82) {

			}));
			this.customSlots.put(25, this.addSlot(new Slot(internal, 25, 98, 82) {

			}));

			int si;
			int sj;

			for (si = 0; si < 3; ++si)
				for (sj = 0; sj < 9; ++sj)
					this.addSlot(new Slot(inv, sj + (si + 1) * 9, 1 + 8 + sj * 18, 25 + 84 + si * 18));

			for (si = 0; si < 9; ++si)
				this.addSlot(new Slot(inv, si, 1 + 8 + si * 18, 25 + 142));
		}

		public Map<Integer, Slot> get() {
			return customSlots;
		}

		@Override
		public boolean canInteractWith(PlayerEntity player) {
			return internal.isUsableByPlayer(player);
		}

		@Override
		public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
			ItemStack itemstack = ItemStack.EMPTY;
			Slot slot = (Slot) this.inventorySlots.get(index);

			if (slot != null && slot.getHasStack()) {
				ItemStack itemstack1 = slot.getStack();
				itemstack = itemstack1.copy();

				if (index < 26) {
					if (!this.mergeItemStack(itemstack1, 26, this.inventorySlots.size(), true)) {
						return ItemStack.EMPTY;
					}
					slot.onSlotChange(itemstack1, itemstack);
				} else if (!this.mergeItemStack(itemstack1, 0, 26, false)) {
					if (index < 26 + 27) {
						if (!this.mergeItemStack(itemstack1, 26 + 27, this.inventorySlots.size(), true)) {
							return ItemStack.EMPTY;
						}
					} else {
						if (!this.mergeItemStack(itemstack1, 26, 26 + 27, false)) {
							return ItemStack.EMPTY;
						}
					}
					return ItemStack.EMPTY;
				}

				if (itemstack1.getCount() == 0) {
					slot.putStack(ItemStack.EMPTY);
				} else {
					slot.onSlotChanged();
				}

				if (itemstack1.getCount() == itemstack.getCount()) {
					return ItemStack.EMPTY;
				}

				slot.onTake(playerIn, itemstack1);
			}
			return itemstack;
		}

		@Override /* failed to load code for net.minecraft.inventory.container.Container */

		@Override
		public void onContainerClosed(PlayerEntity playerIn) {
			super.onContainerClosed(playerIn);
			internal.closeInventory(playerIn);
			if ((internal instanceof Inventory) && (playerIn instanceof ServerPlayerEntity)) {
				this.clearContainer(playerIn, playerIn.world, internal);
			}
		}

		private void slotChanged(int slotid, int ctype, int meta) {
			if (this.world != null && this.world.isRemote) {
				Aetheria.PACKET_HANDLER.sendToServer(new GUISlotChangedMessage(slotid, x, y, z, ctype, meta));
				handleSlotAction(entity, slotid, ctype, meta, x, y, z);
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class GuiWindow extends ContainerScreen<GuiContainerMod> {

		private World world;
		private int x, y, z;
		private PlayerEntity entity;

		public GuiWindow(GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
			super(container, inventory, text);
			this.world = container.world;
			this.x = container.x;
			this.y = container.y;
			this.z = container.z;
			this.entity = container.entity;
			this.xSize = 177;
			this.ySize = 216;
		}

		private static final ResourceLocation texture = new ResourceLocation("aetheria:textures/aeonforgegui.png");

		@Override
		public void render(int mouseX, int mouseY, float partialTicks) {
			this.renderBackground();
			super.render(mouseX, mouseY, partialTicks);
			this.renderHoveredToolTip(mouseX, mouseY);

		}

		@Override
		protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

			Minecraft.getInstance().getTextureManager().bindTexture(texture);
			int k = (this.width - this.xSize) / 2;
			int l = (this.height - this.ySize) / 2;
			this.blit(k, l, 0, 0, this.xSize, this.ySize);

		}

		@Override
		public void tick() {
			super.tick();
		}

		@Override
		protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
			this.font.drawString("Aeon Forge", 60, 196, -10066330);
		}

		@Override
		public void removed() {
			super.removed();
			Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
		}

		@Override
		public void init(Minecraft minecraft, int width, int height) {
			super.init(minecraft, width, height);

			minecraft.keyboardListener.enableRepeatEvents(true);

		}

	}

	public static class ButtonPressedMessage {

		int buttonID, x, y, z;

		public ButtonPressedMessage(PacketBuffer buffer) {
			this.buttonID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
		}

		public ButtonPressedMessage(int buttonID, int x, int y, int z) {
			this.buttonID = buttonID;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public static void buffer(ButtonPressedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.buttonID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
		}

		public static void handler(ButtonPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;

				handleButtonAction(entity, buttonID, x, y, z);
			});
			context.setPacketHandled(true);
		}

	}

	public static class GUISlotChangedMessage {

		int slotID, x, y, z, changeType, meta;

		public GUISlotChangedMessage(int slotID, int x, int y, int z, int changeType, int meta) {
			this.slotID = slotID;
			this.x = x;
			this.y = y;
			this.z = z;
			this.changeType = changeType;
			this.meta = meta;
		}

		public GUISlotChangedMessage(PacketBuffer buffer) {
			this.slotID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
			this.changeType = buffer.readInt();
			this.meta = buffer.readInt();
		}

		public static void buffer(GUISlotChangedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.slotID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
			buffer.writeInt(message.changeType);
			buffer.writeInt(message.meta);
		}

		public static void handler(GUISlotChangedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int slotID = message.slotID;
				int changeType = message.changeType;
				int meta = message.meta;
				int x = message.x;
				int y = message.y;
				int z = message.z;

				handleSlotAction(entity, slotID, changeType, meta, x, y, z);
			});
			context.setPacketHandled(true);
		}

	}

	private static void handleButtonAction(PlayerEntity entity, int buttonID, int x, int y, int z) {
		World world = entity.world;

		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;

	}

	private static void handleSlotAction(PlayerEntity entity, int slotID, int changeType, int meta, int x, int y, int z) {
		World world = entity.world;

		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;

	}

}
