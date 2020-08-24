
package net.mod.aetheria.item;

import net.mod.aetheria.AetheriaModElements;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@AetheriaModElements.ModElement.Tag
public class BedrockBreakerItem extends AetheriaModElements.ModElement {
	@ObjectHolder("aetheria:bedrock_breaker")
	public static final Item block = null;
	public BedrockBreakerItem(AetheriaModElements instance) {
		super(instance, 212);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 124;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 2.5f;
			}

			public int getHarvestLevel() {
				return 7;
			}

			public int getEnchantability() {
				return 0;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(null)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}
		}.setRegistryName("bedrock_breaker"));
	}
}
