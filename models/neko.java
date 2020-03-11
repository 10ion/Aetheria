// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class neko extends ModelBase {
	private final ModelRenderer tail;
	private final ModelRenderer tail2;
	private final ModelRenderer ears;

	public neko() {
		textureWidth = 32;
		textureHeight = 32;

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 12.0F, 2.0F);
		setRotationAngle(tail, -1.309F, 0.0F, 0.0F);
		tail.cubeList.add(new ModelBox(tail, 0, 0, -0.5F, -0.7753F, -0.2929F, 1, 1, 11, 0.0F, false));

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, 0.0F, 10.0F);
		setRotationAngle(tail2, 1.2217F, 0.0F, 0.0F);
		tail.addChild(tail2);
		tail2.cubeList.add(new ModelBox(tail2, 0, 12, -0.5F, -0.4664F, 0.5865F, 1, 1, 5, 0.0F, false));

		ears = new ModelRenderer(this);
		ears.setRotationPoint(0.0F, 0.0F, 0.0F);
		ears.cubeList.add(new ModelBox(ears, 0, 6, -3.5F, -8.0F, -3.0F, 1, 1, 1, 0.0F, false));
		ears.cubeList.add(new ModelBox(ears, 5, 1, -3.5F, -7.0F, -2.5F, 1, 1, 1, 0.0F, false));
		ears.cubeList.add(new ModelBox(ears, 4, 4, 2.5F, -7.0F, -2.5F, 1, 1, 1, 0.0F, false));
		ears.cubeList.add(new ModelBox(ears, 0, 4, 2.5F, -8.0F, -3.0F, 1, 1, 1, 0.0F, false));
		ears.cubeList.add(new ModelBox(ears, 0, 2, 2.0F, -7.0F, -3.0F, 2, 1, 1, 0.0F, false));
		ears.cubeList.add(new ModelBox(ears, 0, 0, -4.0F, -7.0F, -3.0F, 2, 1, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		tail.render(f5);
		ears.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}