// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class foxtail extends ModelBase {
	private final ModelRenderer ears;
	private final ModelRenderer rightear;
	private final ModelRenderer leftear;
	private final ModelRenderer tail1;
	private final ModelRenderer tail2;
	private final ModelRenderer tail3;

	public foxtail() {
		textureWidth = 32;
		textureHeight = 32;

		ears = new ModelRenderer(this);
		ears.setRotationPoint(0.0F, 0.0F, 0.0F);

		rightear = new ModelRenderer(this);
		rightear.setRotationPoint(4.0F, -3.0F, -1.0F);
		setRotationAngle(rightear, 0.6109F, 0.5236F, 0.0F);
		ears.addChild(rightear);
		rightear.cubeList.add(new ModelBox(rightear, 11, 13, -0.75F, -1.0F,
				0.0F, 1, 2, 3, 0.0F, false));
		rightear.cubeList.add(new ModelBox(rightear, 0, 4, -0.75F, -0.5F, 3.0F,
				1, 1, 1, 0.0F, false));
		rightear.cubeList.add(new ModelBox(rightear, 0, 0, -1.25F, -1.0F, 0.0F,
				1, 2, 2, 0.0F, false));

		leftear = new ModelRenderer(this);
		leftear.setRotationPoint(-3.0F, -3.0F, -1.0F);
		setRotationAngle(leftear, 0.6109F, -0.5236F, 0.0F);
		ears.addChild(leftear);
		leftear.cubeList.add(new ModelBox(leftear, 11, 13, -1.4F, -1.0F, 0.0F,
				1, 2, 3, 0.0F, false));
		leftear.cubeList.add(new ModelBox(leftear, 0, 4, -1.4F, -0.5F, 3.0F, 1,
				1, 1, 0.0F, false));
		leftear.cubeList.add(new ModelBox(leftear, 0, 0, -0.9F, -1.0F, 0.0F, 1,
				2, 2, 0.0F, false));

		tail1 = new ModelRenderer(this);
		tail1.setRotationPoint(0.0F, 11.0F, 2.0F);
		setRotationAngle(tail1, -0.9599F, 0.0F, 0.0F);
		tail1.cubeList.add(new ModelBox(tail1, 0, 0, -1.1F, -0.1071F, -0.2071F,
				2, 2, 7, 0.0F, false));

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, 1.2929F, 3.2929F);
		tail1.addChild(tail2);
		tail2.cubeList.add(new ModelBox(tail2, 11, 0, -1.35F, -1.15F, 0.0F, 2,
				2, 3, 0.0F, false));

		tail3 = new ModelRenderer(this);
		tail3.setRotationPoint(0.0F, 0.0F, 3.0F);
		tail2.addChild(tail3);
		tail3.cubeList.add(new ModelBox(tail3, 0, 9, -1.6F, -1.9F, 0.0F, 3, 3,
				4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		ears.render(f5);
		tail1.render(f5);
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
		this.tail1.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
		this.ears.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.ears.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.tail2.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
		this.tail3.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
	}
}