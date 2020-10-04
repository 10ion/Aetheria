package net.mod.aetheria.procedures;

import net.mod.aetheria.AetheriaModVariables;
import net.mod.aetheria.AetheriaModElements;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@AetheriaModElements.ModElement.Tag
public class AbilityUse1CommandExecutedProcedure extends AetheriaModElements.ModElement {
	public AbilityUse1CommandExecutedProcedure(AetheriaModElements instance) {
		super(instance, 827);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AbilityUse1CommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		String Ability = "";
		Ability = (String) ((entity.getCapability(AetheriaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new AetheriaModVariables.PlayerVariables())).Ability1);
		if ((((Ability)).equals("None"))) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You do not have an ability in this slot!"), (true));
			}
		} else if ((((Ability)).equals("Dash"))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 2, (int) 5, (true), (false)));
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("This ability does not exist!"), (true));
			}
		}
	}
}
