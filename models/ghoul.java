// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class ghoul extends ModelBase {
	private final ModelRenderer lleg;
	private final ModelRenderer rleg;
	private final ModelRenderer body;
	private final ModelRenderer larm;
	private final ModelRenderer rarm;
	private final ModelRenderer head;

	public ghoul() {
		textureWidth = 64;
		textureHeight = 64;

		lleg = new ModelRenderer(this);
		lleg.setRotationPoint(3.0F, 10.0F, 0.0F);
		lleg.cubeList.add(new ModelBox(lleg, 36, 38, -3.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F, false));

		rleg = new ModelRenderer(this);
		rleg.setRotationPoint(-2.0F, 10.0F, 0.0F);
		rleg.cubeList.add(new ModelBox(rleg, 0, 34, -2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 16, -4.0F, -28.0F, -2.0F, 8, 14, 4, 0.0F, false));

		larm = new ModelRenderer(this);
		larm.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(larm, -1.5708F, 0.0F, 0.0F);
		larm.cubeList.add(new ModelBox(larm, 32, 0, 4.0F, -2.0F, -28.0F, 4, 14, 4, 0.0F, false));
		larm.cubeList.add(new ModelBox(larm, 0, 0, 6.0F, 9.0F, -24.0F, 1, 0, 1, 0.0F, false));
		larm.cubeList.add(new ModelBox(larm, 0, 0, 4.0F, 9.0F, -24.0F, 1, 0, 1, 0.0F, false));
		larm.cubeList.add(new ModelBox(larm, 0, 0, 7.0F, 8.0F, -24.0F, 1, 0, 2, 0.0F, false));
		larm.cubeList.add(new ModelBox(larm, 0, 0, 5.0F, 7.0F, -24.0F, 1, 0, 3, 0.0F, false));

		rarm = new ModelRenderer(this);
		rarm.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(rarm, -1.5708F, 0.0F, 0.0F);
		rarm.cubeList.add(new ModelBox(rarm, 24, 24, -8.0F, -2.0F, -28.0F, 4, 14, 4, 0.0F, false));
		rarm.cubeList.add(new ModelBox(rarm, 0, 0, -5.0F, 10.0F, -24.0F, 1, 0, 1, 0.0F, false));
		rarm.cubeList.add(new ModelBox(rarm, 0, 0, -6.0F, 9.0F, -24.0F, 1, 0, 3, 0.0F, false));
		rarm.cubeList.add(new ModelBox(rarm, 0, 0, -8.0F, 9.0F, -24.0F, 1, 0, 2, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -4.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		lleg.render(f5);
		rleg.render(f5);
		body.render(f5);
		larm.render(f5);
		rarm.render(f5);
		head.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}