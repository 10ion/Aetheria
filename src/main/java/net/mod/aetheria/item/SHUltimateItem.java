
package net.mod.aetheria.item;

import net.mod.aetheria.itemgroup.AetheriaMiscItemGroup;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

@AetheriaModElements.ModElement.Tag
public class SHUltimateItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:sh_ultimate")
	public static final Item block = null;
	public SHUltimateItem(AetheriaModElements instance) {
		super(instance, 211);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, AetheriaModElements.sounds.get(new ResourceLocation("aetheria:sh_ultimate")),
					new Item.Properties().group(AetheriaMiscItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("sh_ultimate");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}
	}
}
