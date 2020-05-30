
package net.mcreator.aetheria.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.aetheria.block.MysticalPlanksBlock;
import net.mcreator.aetheria.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class MysticwoodfuelFuel extends AetheriaModElements.ModElement {
	public MysticwoodfuelFuel(AetheriaModElements instance) {
		super(instance, 170);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(MysticalPlanksBlock.block, (int) (1)).getItem())
			event.setBurnTime(1600);
	}
}
