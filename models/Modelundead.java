// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.14
// Paste this class into your mod and generate all required imports

public static class Modelundead extends EntityModel {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;

	public Modelundead() {
		textureWidth = 128;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 32, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 28, 28, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.25F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 16, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F, false));

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		setRotationAngle(rightArm, -1.3963F, 0.0F, 0.0F);
		rightArm.cubeList.add(new ModelBox(rightArm, 52, 52, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));
		rightArm.cubeList.add(new ModelBox(rightArm, 52, 28, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F, false));
		rightArm.cubeList.add(new ModelBox(rightArm, 16, 32, -3.0F, 10.0F, 1.0F, 4, 0, 4, 0.0F, false));
		rightArm.cubeList.add(new ModelBox(rightArm, 28, 24, -3.0F, 8.0304F, 1.3473F, 4, 0, 4, 0.0F, false));
		rightArm.cubeList.add(new ModelBox(rightArm, 28, 20, -3.0F, 5.8871F, 0.7098F, 4, 0, 4, 0.0F, false));
		rightArm.cubeList.add(new ModelBox(rightArm, 28, 16, -3.0F, 3.9175F, 1.0571F, 4, 0, 4, 0.0F, false));

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		setRotationAngle(leftArm, -1.3963F, 0.0F, 0.0F);
		leftArm.cubeList.add(new ModelBox(leftArm, 52, 52, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));
		leftArm.cubeList.add(new ModelBox(leftArm, 0, 48, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F, false));
		leftArm.cubeList.add(new ModelBox(leftArm, 20, 16, -1.0F, 3.9175F, 1.0571F, 4, 0, 4, 0.0F, false));
		leftArm.cubeList.add(new ModelBox(leftArm, 20, 4, -1.0F, 10.0F, 1.0F, 4, 0, 4, 0.0F, false));
		leftArm.cubeList.add(new ModelBox(leftArm, 20, 0, -1.0F, 8.0304F, 1.3473F, 4, 0, 4, 0.0F, false));
		leftArm.cubeList.add(new ModelBox(leftArm, 20, 20, -1.0F, 5.8871F, 0.7098F, 4, 0, 4, 0.0F, false));

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		rightLeg.cubeList.add(new ModelBox(rightLeg, 44, 12, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
		rightLeg.cubeList.add(new ModelBox(rightLeg, 36, 44, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F, false));

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		leftLeg.cubeList.add(new ModelBox(leftLeg, 20, 44, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
		leftLeg.cubeList.add(new ModelBox(leftLeg, 32, 0, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		head.render(f5);
		rightArm.render(f5);
		leftArm.render(f5);
		rightLeg.render(f5);
		leftLeg.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.rightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.body.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.body.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}