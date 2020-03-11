//Made with Blockbench
//Paste this code into your mod.

public static class Modelcustom_model extends ModelBase {
	private final ModelRenderer Animation1;

	public Modelcustom_model() {
		textureWidth = 32;
		textureHeight = 32;

		Animation1 = new ModelRenderer(this);
		Animation1.setRotationPoint(0.0F, 24.0F, 0.0F);
		Animation1.cubeList.add(new ModelBox(Animation1, 0, 13, -1.0F, -3.0F,
				2.0F, 1, 3, 2, 0.0F, false));
		Animation1.cubeList.add(new ModelBox(Animation1, 0, 0, -1.0F, -3.0F,
				-3.0F, 1, 3, 2, 0.0F, false));
		Animation1.cubeList.add(new ModelBox(Animation1, 0, 0, -4.0F, -9.0F,
				-3.0F, 7, 6, 7, 0.0F, false));
		Animation1.cubeList.add(new ModelBox(Animation1, 0, 13, -4.0F, -10.0F,
				-3.0F, 5, 1, 7, 0.0F, false));
		Animation1.cubeList.add(new ModelBox(Animation1, 0, 5, -5.0F, -7.0F,
				0.0F, 1, 1, 1, 0.0F, false));
		Animation1.cubeList.add(new ModelBox(Animation1, 0, 23, -4.0F, -11.0F,
				-1.0F, 1, 1, 3, 0.0F, false));
		Animation1.cubeList.add(new ModelBox(Animation1, 21, 0, -3.0F, -12.0F,
				-1.0F, 1, 1, 3, 0.0F, false));
		Animation1.cubeList.add(new ModelBox(Animation1, 20, 21, -3.0F, -7.0F,
				-4.0F, 4, 1, 1, 0.0F, false));
		Animation1.cubeList.add(new ModelBox(Animation1, 10, 21, -3.0F, -6.0F,
				-5.0F, 4, 1, 1, 0.0F, false));
		Animation1.cubeList.add(new ModelBox(Animation1, 0, 21, -3.0F, -5.0F,
				-6.0F, 4, 1, 1, 0.0F, false));
		Animation1.cubeList.add(new ModelBox(Animation1, 17, 15, -3.0F, -7.0F,
				4.0F, 4, 1, 1, 0.0F, false));
		Animation1.cubeList.add(new ModelBox(Animation1, 17, 13, -3.0F, -6.0F,
				5.0F, 4, 1, 1, 0.0F, false));
		Animation1.cubeList.add(new ModelBox(Animation1, 17, 17, -3.0F, -5.0F,
				6.0F, 4, 1, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		Animation1.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y,
			float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}