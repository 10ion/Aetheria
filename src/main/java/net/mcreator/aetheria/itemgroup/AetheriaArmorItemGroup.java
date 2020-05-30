
package net.mcreator.aetheria.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.aetheria.item.ObsidianArmorItem;
import net.mcreator.aetheria.AetheriaModElements;

@AetheriaModElements.ModElement.Tag
public class AetheriaArmorItemGroup extends AetheriaModElements.ModElement {
	public AetheriaArmorItemGroup(AetheriaModElements instance) {
		super(instance, 400);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabaetheriaarmor") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ObsidianArmorItem.body, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
