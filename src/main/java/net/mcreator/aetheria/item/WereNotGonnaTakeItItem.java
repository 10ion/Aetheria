
package net.mcreator.aetheria.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import net.mcreator.aetheria.itemgroup.AetheriaMusicItemGroup;
import net.mcreator.aetheria.AetheriaElements;

@AetheriaElements.ModElement.Tag
public class WereNotGonnaTakeItItem extends AetheriaElements.ModElement {
	@ObjectHolder("aetheria:werenotgonnatakeit")
	public static final Item block = null;
	public WereNotGonnaTakeItItem(AetheriaElements instance) {
		super(instance, 423);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, AetheriaElements.sounds.get(new ResourceLocation("aetheria:werenotgonnatakeit")),
					new Item.Properties().group(AetheriaMusicItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("werenotgonnatakeit");
		}
	}
}