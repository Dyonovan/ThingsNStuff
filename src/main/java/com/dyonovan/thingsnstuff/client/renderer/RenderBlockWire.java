package com.dyonovan.thingsnstuff.client.renderer;

import com.dyonovan.thingsnstuff.lib.Constants;
import com.dyonovan.thingsnstuff.client.model.ModelWire;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderBlockWire extends TileEntitySpecialRenderer {

    public static final ResourceLocation texture = new ResourceLocation(Constants.MODID + ":textures/models/modelwire.png");

    private ModelWire model;

    public RenderBlockWire() {
        this.model = new ModelWire();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {

        GL11.glPushMatrix();

        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glRotatef(180, 0F, 0F, 1F);

        this.bindTexture(texture);

        //GL11.glPushMatrix();
        this.model.renderModel(0.0625F, tileentity.xCoord, tileentity.yCoord, tileentity.zCoord, (tileentity.getWorldObj() == null) ? true : false);
        //GL11.glPopMatrix();

        GL11.glPopMatrix();
    }
}
