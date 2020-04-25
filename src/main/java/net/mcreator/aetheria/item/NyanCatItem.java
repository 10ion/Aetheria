
package net.mcreator.aetheria.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

import net.mcreator.aetheria.AetheriaElements;

@AetheriaElements.ModElement.Tag
public class NyanCatItem extends AetheriaElements.ModElement {
	@ObjectHolder("aetheria:nyancat")
	public static final Item block = null;
	public NyanCatItem(AetheriaElements instance) {
		super(instance, 424);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, AetheriaElements.sounds.get(new ResourceLocation("aetheria:nyan-cat")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("nyancat");
		}
	}
}
