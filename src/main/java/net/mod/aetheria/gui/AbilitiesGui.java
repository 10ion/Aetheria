
package net.mod.aetheria.gui;

import org.lwjgl.opengl.GL11;

import net.mod.aetheria.AetheriaModVariables;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

@AetheriaModElements.ModElement.Tag
public class AbilitiesGui extends AetheriaModElements.ModElement {
	public static HashMap guistate = new HashMap();
	private static ContainerType<GuiContainerMod> containerType = null;
	public AbilitiesGui(AetheriaModElements instance) {
		super(instance, 623);
		elements.addNetworkMessage(ButtonPressedMessage.class, ButtonPressedMessage::buffer, ButtonPressedMessage::new,
				ButtonPressedMessage::handler);
		elements.addNetworkMessage(GUISlotChangedMessage.class, GUISlotChangedMessage::buffer, GUISlotChangedMessage::new,
				GUISlotChangedMessage::handler);
		containerType = new ContainerType<>(new GuiContainerModFactory());
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@OnlyIn(Dist.CLIENT)
	public void initElements() {
		DeferredWorkQueue.runLater(() -> ScreenManager.registerFactory(containerType, GuiWindow::new));
	}

	@SubscribeEvent
	public void registerContainer(RegistryEvent.Register<ContainerType<?>> event) {
		event.getRegistry().register(containerType.setRegistryName("abilities"));
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
		private IItemHandler internal;
		private Map<Integer, Slot> customSlots = new HashMap<>();
		private boolean bound = false;
		public GuiContainerMod(int id, PlayerInventory inv, PacketBuffer extraData) {
			super(containerType, id);
			this.entity = inv.player;
			this.world = inv.player.world;
			this.internal = new ItemStackHandler(0);
			BlockPos pos = null;
			if (extraData != null) {
				pos = extraData.readBlockPos();
				this.x = pos.getX();
				this.y = pos.getY();
				this.z = pos.getZ();
			}
		}

		public Map<Integer, Slot> get() {
			return customSlots;
		}

		@Override
		public boolean canInteractWith(PlayerEntity player) {
			return true;
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
			this.xSize = 172;
			this.ySize = 238;
		}
		private static final ResourceLocation texture = new ResourceLocation("aetheria:textures/abilities.png");
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
		public boolean keyPressed(int key, int b, int c) {
			if (key == 256) {
				this.minecraft.player.closeScreen();
				return true;
			}
			return super.keyPressed(key, b, c);
		}

		@Override
		public void tick() {
			super.tick();
		}

		@Override
		protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
			this.font.drawString("" + ((entity.getCapability(AetheriaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new AetheriaModVariables.PlayerVariables())).Ability1) + "", 33, 32, -11447983);
			this.font.drawString("" + ((entity.getCapability(AetheriaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new AetheriaModVariables.PlayerVariables())).Ability2) + "", 33, 46, -11447983);
			this.font.drawString("" + ((entity.getCapability(AetheriaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new AetheriaModVariables.PlayerVariables())).Ability3) + "", 33, 60, -11447983);
			this.font.drawString("" + ((entity.getCapability(AetheriaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new AetheriaModVariables.PlayerVariables())).Ability4) + "", 33, 74, -11447983);
			this.font.drawString("" + ((entity.getCapability(AetheriaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new AetheriaModVariables.PlayerVariables())).Ability5) + "", 33, 88, -11447983);
			this.font.drawString("" + ((entity.getCapability(AetheriaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new AetheriaModVariables.PlayerVariables())).Ability6) + "", 33, 102, -11447983);
			this.font.drawString("" + ((entity.getCapability(AetheriaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new AetheriaModVariables.PlayerVariables())).Ability7) + "", 33, 116, -11447983);
			this.font.drawString("" + ((entity.getCapability(AetheriaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new AetheriaModVariables.PlayerVariables())).Ability8) + "", 33, 130, -11447983);
			this.font.drawString("" + ((entity.getCapability(AetheriaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new AetheriaModVariables.PlayerVariables())).Ability9) + "", 33, 144, -11447983);
			this.font.drawString("" + ((entity.getCapability(AetheriaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new AetheriaModVariables.PlayerVariables())).Ability10) + "", 33, 158, -11447983);
			this.font.drawString("" + ((entity.getCapability(AetheriaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new AetheriaModVariables.PlayerVariables())).Ultimate1) + "", 33, 193, -11447983);
			this.font.drawString("" + ((entity.getCapability(AetheriaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new AetheriaModVariables.PlayerVariables())).Ultimate2) + "", 33, 207, -11447983);
			this.font.drawString("Abilities", 61, 11, -11447983);
			this.font.drawString("Ultimates", 61, 172, -11447983);
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
