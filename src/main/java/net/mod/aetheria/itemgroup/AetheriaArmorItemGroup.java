
package net.mod.aetheria.itemgroup;

import net.mod.aetheria.item.ObsidianArmorItem;
import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@AetheriaModElements.ModElement.Tag
public class AetheriaArmorItemGroup extends AetheriaModElements.ModElement {
	public AetheriaArmorItemGroup(AetheriaModElements instance) {
		super(instance, 367);
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
