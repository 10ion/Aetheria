//Made with Blockbench
//Paste this code into your mod.

public static class Modelcustom_model extends ModelBase {
	private final ModelRenderer tail;
	private final ModelRenderer tail2;
	private final ModelRenderer lleg;
	private final ModelRenderer rleg;
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer rarm;
	private final ModelRenderer larm;
	private final ModelRenderer clothes;

	public Modelcustom_model() {
		textureWidth = 64;
		textureHeight = 64;

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 12.0F, 2.0F);
		setRotationAngle(tail, -1.309F, 0.0F, 0.0F);
		tail.cubeList.add(new ModelBox(tail, 13, 20, -0.5F, -0.7753F, -0.2929F,
				1, 1, 11, 0.0F, false));

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, 0.0F, 10.0F);
		setRotationAngle(tail2, 1.2217F, 0.0F, 0.0F);
		tail.addChild(tail2);
		tail2.cubeList.add(new ModelBox(tail2, 32, 27, -0.5F, -0.4664F,
				0.5865F, 1, 1, 5, 0.0F, false));

		lleg = new ModelRenderer(this);
		lleg.setRotationPoint(2.0F, 12.0F, 0.0F);
		lleg.cubeList.add(new ModelBox(lleg, 46, 46, -2.0F, 0.0F, -2.0F, 4, 12,
				4, 0.0F, false));

		rleg = new ModelRenderer(this);
		rleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
		rleg.cubeList.add(new ModelBox(rleg, 0, 46, -2.0F, 0.0F, -2.0F, 4, 12,
				4, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 6.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 15, -4.0F, -6.0F, -2.0F, 8, 12,
				4, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -7.0F, -4.0F, 8, 7,
				8, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 4, 4, -3.5F, -9.0F, -3.0F, 1, 1,
				1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 4, 2.5F, -9.0F, -3.0F, 1, 1, 1,
				0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 2, 2.0F, -8.0F, -3.0F, 2, 1, 1,
				0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -8.0F, -3.0F, 2, 1,
				1, 0.0F, false));

		rarm = new ModelRenderer(this);
		rarm.setRotationPoint(-6.0F, 0.0F, 0.0F);
		rarm.cubeList.add(new ModelBox(rarm, 34, 34, -2.0F, 0.0F, -2.0F, 4, 12,
				4, 0.0F, false));

		larm = new ModelRenderer(this);
		larm.setRotationPoint(6.0F, 0.0F, 0.0F);
		larm.cubeList.add(new ModelBox(larm, 18, 32, -2.0F, 0.0F, -2.0F, 4, 12,
				4, 0.0F, false));

		clothes = new ModelRenderer(this);
		clothes.setRotationPoint(0.0F, 12.0F, 2.0F);
		clothes.cubeList.add(new ModelBox(clothes, 48, 14, -4.0F, -12.0F,
				-5.0F, 3, 13, 1, 0.0F, false));
		clothes.cubeList.add(new ModelBox(clothes, 50, 28, -5.0F, 1.0F, -5.0F,
				3, 10, 1, 0.0F, false));
		clothes.cubeList.add(new ModelBox(clothes, 26, 15, -5.0F, 1.0F, -0.5F,
				10, 10, 1, 0.0F, false));
		clothes.cubeList.add(new ModelBox(clothes, 0, 32, -4.0F, -12.0F, -0.5F,
				8, 13, 1, 0.0F, false));
		clothes.cubeList.add(new ModelBox(clothes, 36, 50, 2.0F, 1.0F, -5.0F,
				3, 10, 1, 0.0F, false));
		clothes.cubeList.add(new ModelBox(clothes, 42, 0, 4.0F, 1.0F, -4.0F, 1,
				10, 4, 0.0F, false));
		clothes.cubeList.add(new ModelBox(clothes, 30, 47, 4.0F, -12.0F, -4.0F,
				0, 13, 3, 0.0F, false));
		clothes.cubeList.add(new ModelBox(clothes, 24, 45, -4.0F, -12.0F,
				-4.0F, 0, 13, 3, 0.0F, false));
		clothes.cubeList.add(new ModelBox(clothes, 32, 0, -5.0F, 1.0F, -4.0F,
				1, 10, 4, 0.0F, false));
		clothes.cubeList.add(new ModelBox(clothes, 16, 48, 1.0F, -12.0F, -5.0F,
				3, 13, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		tail.render(f5);
		lleg.render(f5);
		rleg.render(f5);
		body.render(f5);
		head.render(f5);
		rarm.render(f5);
		larm.render(f5);
		clothes.render(f5);
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
		this.lleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.tail2.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI)
				* f1;
		this.larm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.tail.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
		this.rleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI)
				* f1;
	}
}