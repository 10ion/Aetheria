
package net.mcreator.aetheria.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.aetheria.block.MysticallogBlock;
import net.mcreator.aetheria.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class MysticWoodFuleLogFuel extends AetheriaModElements.ModElement {
	public MysticWoodFuleLogFuel(AetheriaModElements instance) {
		super(instance, 171);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(MysticallogBlock.block, (int) (1)).getItem())
			event.setBurnTime(1600);
	}
}
