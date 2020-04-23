
package net.mcreator.aetheria.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.aetheria.item.ObsidianArmorItem;
import net.mcreator.aetheria.AetheriaElements;

@AetheriaElements.ModElement.Tag
public class AetheriaArmorItemGroup extends AetheriaElements.ModElement {
	public AetheriaArmorItemGroup(AetheriaElements instance) {
		super(instance, 397);
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
