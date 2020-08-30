package net.mod.aetheria.procedures;

import net.mod.aetheria.gui.AbilityAllocationGui;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.accesstransformer.Target;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

import io.netty.buffer.Unpooled;

@AetheriaModElements.ModElement.Tag
public class AbilityTeachProcedure extends AetheriaModElements.ModElement {
	public AbilityTeachProcedure(AetheriaModElements instance) {
		super(instance, 817);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("cmdparams") == null) {
			System.err.println("Failed to load dependency cmdparams for procedure AbilityTeach!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure AbilityTeach!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure AbilityTeach!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure AbilityTeach!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure AbilityTeach!");
			return;
		}
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		String Target = "";
		if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals(((world
				.getEntitiesWithinAABB(PlayerEntity.class, new AxisAlignedBB(x - 4 / 2, y - 4 / 2, z - 4 / 2, x + 4 / 2, y + 4 / 2, z + 4 / 2), null)
				.stream().sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z))).findFirst().orElse(null)).getDisplayName()
						.getString())))) {
			{
				Entity _ent = (world
						.getEntitiesWithinAABB(PlayerEntity.class,
								new AxisAlignedBB(x - 4 / 2, y - 4 / 2, z - 4 / 2, x + 4 / 2, y + 4 / 2, z + 4 / 2), null)
						.stream().sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z))).findFirst().orElse(null));
				if (_ent instanceof ServerPlayerEntity) {
					BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
					NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
						@Override
						public ITextComponent getDisplayName() {
							return new StringTextComponent("AbilityAllocation");
						}

						@Override
						public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
							return new AbilityAllocationGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
			Target = (String) ((world.getEntitiesWithinAABB(PlayerEntity.class,
					new AxisAlignedBB(x - 4 / 2, y - 4 / 2, z - 4 / 2, x + 4 / 2, y + 4 / 2, z + 4 / 2), null).stream()
					.sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z))).findFirst().orElse(null)).getDisplayName().getString());
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent((Target)));
			}
		}
	}
}
