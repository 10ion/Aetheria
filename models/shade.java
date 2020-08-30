// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class shade extends ModelBase {
	private final ModelRenderer bb_main;
	private final ModelRenderer right_arm;
	private final ModelRenderer bone4;
	private final ModelRenderer bone6;
	private final ModelRenderer bone5;
	private final ModelRenderer ghostthings;
	private final ModelRenderer leftarm;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;
	private final ModelRenderer bone10;

	public shade() {
		textureWidth = 64;
		textureHeight = 64;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bb_main, 0.0873F, 0.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -4.0F, -32.0F, -2.0F, 8, 8, 8, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 16, -4.0F, -24.0F, 0.0F, 8, 13, 4, 0.0F, false));

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(-9.0F, 24.0F, 0.0F);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone4, -1.5708F, 0.0F, 0.0F);
		right_arm.addChild(bone4);
		bone4.cubeList.add(new ModelBox(bone4, 32, 0, 3.0F, -2.0F, -24.0F, 2, 15, 3, 0.0F, false));

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 0.0F, 0.0F);
		right_arm.addChild(bone6);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 0.0F, 0.0F);
		right_arm.addChild(bone5);

		ghostthings = new ModelRenderer(this);
		ghostthings.setRotationPoint(0.0F, 21.0F, 4.0F);
		setRotationAngle(ghostthings, 0.5236F, 0.0F, 0.0F);
		ghostthings.cubeList.add(new ModelBox(ghostthings, 14, 33, -1.0F, -9.0F, 2.0F, 1, 10, 0, 0.0F, false));
		ghostthings.cubeList.add(new ModelBox(ghostthings, 0, 33, -2.0F, -9.0F, 0.0F, 1, 10, 0, 0.0F, false));
		ghostthings.cubeList.add(new ModelBox(ghostthings, 24, 16, -2.0F, -9.0F, 3.0F, 1, 10, 0, 0.0F, false));
		ghostthings.cubeList.add(new ModelBox(ghostthings, 10, 33, 1.0F, -9.0F, 2.0F, 1, 10, 0, 0.0F, false));
		ghostthings.cubeList.add(new ModelBox(ghostthings, 2, 33, 0.0F, -9.0F, 0.0F, 1, 10, 0, 0.0F, false));
		ghostthings.cubeList.add(new ModelBox(ghostthings, 26, 16, 0.0F, -9.0F, 3.0F, 1, 10, 0, 0.0F, false));
		ghostthings.cubeList.add(new ModelBox(ghostthings, 8, 33, 3.0F, -9.0F, 2.0F, 1, 10, 0, 0.0F, false));
		ghostthings.cubeList.add(new ModelBox(ghostthings, 4, 33, 2.0F, -9.0F, 0.0F, 1, 10, 0, 0.0F, false));
		ghostthings.cubeList.add(new ModelBox(ghostthings, 30, 16, 2.0F, -9.0F, 3.0F, 1, 10, 0, 0.0F, false));
		ghostthings.cubeList.add(new ModelBox(ghostthings, 12, 33, -3.0F, -9.0F, 2.0F, 1, 10, 0, 0.0F, false));
		ghostthings.cubeList.add(new ModelBox(ghostthings, 6, 33, -4.0F, -9.0F, 0.0F, 1, 10, 0, 0.0F, false));
		ghostthings.cubeList.add(new ModelBox(ghostthings, 32, 17, -4.0F, -9.0F, 3.0F, 1, 10, 0, 0.0F, false));

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(0.0F, 24.0F, 0.0F);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone8, -1.3963F, 0.0F, 0.0F);
		leftarm.addChild(bone8);
		bone8.cubeList.add(new ModelBox(bone8, 24, 24, 4.0F, -6.0F, -23.0F, 2, 15, 3, 0.0F, false));

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftarm.addChild(bone9);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftarm.addChild(bone10);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bb_main.render(f5);
		right_arm.render(f5);
		ghostthings.render(f5);
		leftarm.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}