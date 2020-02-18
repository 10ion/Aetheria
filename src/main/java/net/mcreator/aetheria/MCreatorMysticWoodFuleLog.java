package net.mcreator.aetheria;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

@Elementsaetheria.ModElement.Tag
public class MCreatorMysticWoodFuleLog extends Elementsaetheria.ModElement {
	public MCreatorMysticWoodFuleLog(Elementsaetheria instance) {
		super(instance, 63);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(MCreatorMysticallog.block, (int) (1)).getItem())
			event.setBurnTime(1600);
	}
}
