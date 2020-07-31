
package net.mcreator.aetheria.item;

@AetheriaModElements.ModElement.Tag
public class CopperArmorItem extends AetheriaModElements.ModElement {

	@ObjectHolder("aetheria:copper_armorhelmet")
	public static final Item helmet = null;

	@ObjectHolder("aetheria:copper_armorbody")
	public static final Item body = null;

	@ObjectHolder("aetheria:copper_armorlegs")
	public static final Item legs = null;

	@ObjectHolder("aetheria:copper_armorboots")
	public static final Item boots = null;

	public CopperArmorItem(AetheriaModElements instance) {
		super(instance, 713);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 14;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 4, 4, 2}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 18;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(CopperIngotItem.block, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "copper_armor";
			}

			public float getToughness() {
				return 0f;
			}
		};

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(AetheriaArmorItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "aetheria:textures/models/armor/copper_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("copper_armorhelmet"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(AetheriaArmorItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "aetheria:textures/models/armor/copper_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("copper_armorbody"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(AetheriaArmorItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "aetheria:textures/models/armor/copper_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("copper_armorlegs"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(AetheriaArmorItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "aetheria:textures/models/armor/copper_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("copper_armorboots"));
	}

}
