// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class blockbird extends ModelBase {
	private final ModelRenderer stationaryblocks;
	private final ModelRenderer legleft;
	private final ModelRenderer legright;
	private final ModelRenderer wingleft;
	private final ModelRenderer wingright;

	public blockbird() {
		textureWidth = 32;
		textureHeight = 32;

		stationaryblocks = new ModelRenderer(this);
		stationaryblocks.setRotationPoint(0.0F, 17.0F, 1.0F);
		stationaryblocks.cubeList.add(new ModelBox(stationaryblocks, 0, 0, -4.0F, -2.0F, -4.0F, 7, 6, 7, 0.0F, false));
		stationaryblocks.cubeList.add(new ModelBox(stationaryblocks, 0, 13, -4.0F, -3.0F, -4.0F, 5, 1, 7, 0.0F, false));
		stationaryblocks.cubeList.add(new ModelBox(stationaryblocks, 0, 5, -5.0F, 0.0F, -1.0F, 1, 1, 1, 0.0F, false));
		stationaryblocks.cubeList.add(new ModelBox(stationaryblocks, 0, 23, -4.0F, -4.0F, -2.0F, 1, 1, 3, 0.0F, false));
		stationaryblocks.cubeList.add(new ModelBox(stationaryblocks, 21, 0, -3.0F, -5.0F, -2.0F, 1, 1, 3, 0.0F, false));

		legleft = new ModelRenderer(this);
		legleft.setRotationPoint(-1.0F, 21.0F, -2.0F);
		legleft.cubeList.add(new ModelBox(legleft, 0, 13, 0.0F, 0.0F, 4.0F, 1, 3, 2, 0.0F, false));

		legright = new ModelRenderer(this);
		legright.setRotationPoint(-1.0F, 21.0F, 3.0F);
		legright.cubeList.add(new ModelBox(legright, 0, 0, 0.0F, 0.0F, -6.0F, 1, 3, 2, 0.0F, false));

		wingleft = new ModelRenderer(this);
		wingleft.setRotationPoint(-1.0F, 17.0F, 4.0F);
		wingleft.cubeList.add(new ModelBox(wingleft, 17, 15, -2.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F, false));
		wingleft.cubeList.add(new ModelBox(wingleft, 17, 13, -2.0F, 1.0F, 1.0F, 4, 1, 1, 0.0F, false));
		wingleft.cubeList.add(new ModelBox(wingleft, 17, 17, -2.0F, 2.0F, 2.0F, 4, 1, 1, 0.0F, false));

		wingright = new ModelRenderer(this);
		wingright.setRotationPoint(-1.0F, 17.0F, -3.0F);
		wingright.cubeList.add(new ModelBox(wingright, 20, 21, -2.0F, 0.0F, -1.0F, 4, 1, 1, 0.0F, false));
		wingright.cubeList.add(new ModelBox(wingright, 10, 21, -2.0F, 1.0F, -2.0F, 4, 1, 1, 0.0F, false));
		wingright.cubeList.add(new ModelBox(wingright, 0, 21, -2.0F, 2.0F, -3.0F, 4, 1, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		stationaryblocks.render(f5);
		legleft.render(f5);
		legright.render(f5);
		wingleft.render(f5);
		wingright.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}