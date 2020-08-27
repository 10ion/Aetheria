package net.mod.aetheria;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class AetheriaModVariables {
	public AetheriaModVariables(AetheriaModElements elements) {
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
	}
	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;
	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
			event.addCapability(new ResourceLocation("aetheria", "player_variables"), new PlayerVariablesProvider());
	}
	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(PLAYER_VARIABLES_CAPABILITY::getDefaultInstance);
		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new),
					null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null,
					nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putString("Race", instance.Race);
			nbt.putString("Ability1", instance.Ability1);
			nbt.putString("Ability2", instance.Ability2);
			nbt.putString("Ability3", instance.Ability3);
			nbt.putString("Ability4", instance.Ability4);
			nbt.putString("Ability5", instance.Ability5);
			nbt.putString("Ability6", instance.Ability6);
			nbt.putString("Ability7", instance.Ability7);
			nbt.putString("Ability8", instance.Ability8);
			nbt.putString("Ability9", instance.Ability9);
			nbt.putString("Ability10", instance.Ability10);
			nbt.putString("Ultimate1", instance.Ultimate1);
			nbt.putString("Ultimate2", instance.Ultimate2);
			nbt.putString("Class1", instance.Class1);
			nbt.putString("Class2", instance.Class2);
			nbt.putString("Class3", instance.Class3);
			nbt.putString("Class4", instance.Class4);
			nbt.putString("Class5", instance.Class5);
			nbt.putString("Class6", instance.Class6);
			nbt.putString("Class7", instance.Class7);
			nbt.putString("Class8", instance.Class8);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.Race = nbt.getString("Race");
			instance.Ability1 = nbt.getString("Ability1");
			instance.Ability2 = nbt.getString("Ability2");
			instance.Ability3 = nbt.getString("Ability3");
			instance.Ability4 = nbt.getString("Ability4");
			instance.Ability5 = nbt.getString("Ability5");
			instance.Ability6 = nbt.getString("Ability6");
			instance.Ability7 = nbt.getString("Ability7");
			instance.Ability8 = nbt.getString("Ability8");
			instance.Ability9 = nbt.getString("Ability9");
			instance.Ability10 = nbt.getString("Ability10");
			instance.Ultimate1 = nbt.getString("Ultimate1");
			instance.Ultimate2 = nbt.getString("Ultimate2");
			instance.Class1 = nbt.getString("Class1");
			instance.Class2 = nbt.getString("Class2");
			instance.Class3 = nbt.getString("Class3");
			instance.Class4 = nbt.getString("Class4");
			instance.Class5 = nbt.getString("Class5");
			instance.Class6 = nbt.getString("Class6");
			instance.Class7 = nbt.getString("Class7");
			instance.Class8 = nbt.getString("Class8");
		}
	}

	public static class PlayerVariables {
		public String Race = "Choose";
		public String Ability1 = "None";
		public String Ability2 = "None";
		public String Ability3 = "None";
		public String Ability4 = "None";
		public String Ability5 = "None";
		public String Ability6 = "None";
		public String Ability7 = "None";
		public String Ability8 = "None";
		public String Ability9 = "None";
		public String Ability10 = "None";
		public String Ultimate1 = "None";
		public String Ultimate2 = "None";
		public String Class1 = "Neophyte";
		public String Class2 = "None";
		public String Class3 = "None";
		public String Class4 = "None";
		public String Class5 = "None";
		public String Class6 = "None";
		public String Class7 = "None";
		public String Class8 = "None";
		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				AetheriaMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity),
						new PlayerVariablesSyncMessage(this));
		}
	}
	@SubscribeEvent
	public void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote)
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.getPlayer().world.isRemote)
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote)
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void clonePlayer(PlayerEvent.Clone event) {
		if (event.isWasDeath()) {
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			clone.Race = original.Race;
			clone.Ability1 = original.Ability1;
			clone.Ability2 = original.Ability2;
			clone.Ability3 = original.Ability3;
			clone.Ability4 = original.Ability4;
			clone.Ability5 = original.Ability5;
			clone.Ability6 = original.Ability6;
			clone.Ability7 = original.Ability7;
			clone.Ability8 = original.Ability8;
			clone.Ability9 = original.Ability9;
			clone.Ability10 = original.Ability10;
			clone.Ultimate1 = original.Ultimate1;
			clone.Ultimate2 = original.Ultimate2;
			clone.Class1 = original.Class1;
			clone.Class2 = original.Class2;
			clone.Class3 = original.Class3;
			clone.Class4 = original.Class4;
			clone.Class5 = original.Class5;
			clone.Class6 = original.Class6;
			clone.Class7 = original.Class7;
			clone.Class8 = original.Class8;
		}
	}
	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;
		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.Race = message.data.Race;
					variables.Ability1 = message.data.Ability1;
					variables.Ability2 = message.data.Ability2;
					variables.Ability3 = message.data.Ability3;
					variables.Ability4 = message.data.Ability4;
					variables.Ability5 = message.data.Ability5;
					variables.Ability6 = message.data.Ability6;
					variables.Ability7 = message.data.Ability7;
					variables.Ability8 = message.data.Ability8;
					variables.Ability9 = message.data.Ability9;
					variables.Ability10 = message.data.Ability10;
					variables.Ultimate1 = message.data.Ultimate1;
					variables.Ultimate2 = message.data.Ultimate2;
					variables.Class1 = message.data.Class1;
					variables.Class2 = message.data.Class2;
					variables.Class3 = message.data.Class3;
					variables.Class4 = message.data.Class4;
					variables.Class5 = message.data.Class5;
					variables.Class6 = message.data.Class6;
					variables.Class7 = message.data.Class7;
					variables.Class8 = message.data.Class8;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
