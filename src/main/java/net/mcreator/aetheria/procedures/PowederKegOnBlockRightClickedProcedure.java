package net.mcreator.aetheria.procedures;

@AetheriaModElements.ModElement.Tag
public class PowederKegOnBlockRightClickedProcedure extends AetheriaModElements.ModElement {

	public PowederKegOnBlockRightClickedProcedure(AetheriaModElements instance) {
		super(instance, 452);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure PowederKegOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure PowederKegOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure PowederKegOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure PowederKegOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure PowederKegOnBlockRightClicked!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");

		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(Items.FLINT_AND_STEEL, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(Items.FLINT_AND_STEEL, (int) (1)).getItem()))) {
			if (!world.isRemote) {
				world.createExplosion(null, (int) x, (int) y, (int) z, (float) 10, Explosion.Mode.BREAK);
			}
		}

	}

}