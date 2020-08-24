
package net.mod.aetheria.fuel;

import net.mod.aetheria.block.MysticalPlanksBlock;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

@AetheriaModElements.ModElement.Tag
public class MysticwoodfuelFuel extends AetheriaModElements.ModElement {
	public MysticwoodfuelFuel(AetheriaModElements instance) {
		super(instance, 252);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(MysticalPlanksBlock.block, (int) (1)).getItem())
			event.setBurnTime(1600);
	}
}
