package com.dyonovan.thingsnstuff.client.renderer;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class ItemRenderBlockWire implements IItemRenderer {

    private TileEntitySpecialRenderer render;
    private TileEntity tileentity;

    public ItemRenderBlockWire(TileEntitySpecialRenderer render, TileEntity tileentity) {
        this.render = render;
        this.tileentity = tileentity;
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

        /*if (type == ItemRenderType.ENTITY) {
            GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
            this.render.renderTileEntityAt(this.tileentity, 0.0D, 0.0D, 0.0D, 0.0F);
        }*/

        if(type != ItemRenderType.ENTITY && type != ItemRenderType.EQUIPPED){
            GL11.glPushMatrix();
            /*
            GL11.glScalef(1.25F, 1.25F, 1.25F);
            TileEntityRendererDispatcher.instance.renderTileEntityAt(new TEBlockWire(), 0.0D, 0.0D, 0.0D, 0.0F);
            */
            this.render.renderTileEntityAt(this.tileentity, 0.0D, 0.0D, 0.0D, 0.0F);
            GL11.glPopMatrix();
        }/*else if(type == type.ENTITY && !(item.getItem() instanceof ItemBlock)){
            GL11.glPushMatrix();
            //GL11.glScalef(1.5f, 1.5f, 1.5f);
            TileEntityRendererDispatcher.instance.renderTileEntityAt(new TEBlockWire(), 0.0D, 0.0D, 0.0D, 0.0F);
            GL11.glPopMatrix();
        }else if(type == type.ENTITY && item.getItem() instanceof ItemBlock){
            GL11.glPushMatrix();
            //GL11.glScalef(3.0f, 3.0f, 3.0f);
            TileEntityRendererDispatcher.instance.renderTileEntityAt(new TEBlockWire(), 0.0D, 0.0D, 0.0D, 0.0F);
            GL11.glPopMatrix();
        }else if(type == type.EQUIPPED){
            GL11.glPushMatrix();
            //GL11.glScalef(2f, 2f, 2f);
            GL11.glRotatef(20, 1, 0, 0);
            TileEntityRendererDispatcher.instance.renderTileEntityAt(new TEBlockWire(), -0.30D, 0.1D, -0.30D, 0.0F);
            GL11.glRotatef(-20, 1, 0, 0);
            GL11.glPopMatrix();
        }*/
    }
}
