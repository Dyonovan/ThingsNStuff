package com.dyonovan.thingsnstuff.client.renderer;

import com.dyonovan.thingsnstuff.common.items.ItemPipette;
import com.dyonovan.thingsnstuff.util.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import org.lwjgl.opengl.GL11;

//Rendering Code was partially based on work from the COFH team
public class ItemRendererPipette implements IItemRenderer {

    public ItemRendererPipette() {}

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return false;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        GL11.glPushMatrix();

        GL11.glEnable(3042);
        GL11.glEnable(3008);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);

        switch(type) {
            case ENTITY :
                GL11.glRotated(180.0D, 0.0D, 0.0D, 1.0D);
                GL11.glRotated(90.0D, 0.0D, 1.0D, 0.0D);
                GL11.glScaled(0.75D, 0.75D, 0.75D);
                GL11.glTranslated(-0.5D, -0.6D, 0.0D);
                break;
            case EQUIPPED_FIRST_PERSON :
                GL11.glTranslated(1.0D, 1.0D, 0.0D);
                GL11.glRotated(180.0D, 0.0D, 0.0D, 1.0D);
                break;
            case EQUIPPED :
                GL11.glRotated(180.0D, 0.0D, 0.0D, 1.0D);
                GL11.glTranslated(-1.0D, -1.0D, 0.0D);
            }

        if(item.hasTagCompound()) {
            Fluid onStack = FluidRegistry.getFluid(item.getTagCompound().getInteger(ItemPipette.LIQUID_TYPE));
            if(onStack != null) {
                RenderUtils.bindMinecraftItemSheet();

                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);

                GL11.glDisable(2884);
                Tessellator localTessellator = Tessellator.instance;
                localTessellator.startDrawingQuads();
                localTessellator.setNormal(0.0F, 0.0F, 1.0F);

                if (type.equals(IItemRenderer.ItemRenderType.INVENTORY)) {
                    preRenderIconInv(ItemPipette.mask, 10.0D);
                } else {
                    preRenderIconWorld(ItemPipette.mask, 0.001D);
                }
                localTessellator.draw();

                localTessellator.startDrawingQuads();
                localTessellator.setNormal(0.0F, 0.0F, -1.0F);
                if (type.equals(IItemRenderer.ItemRenderType.INVENTORY)) {
                    preRenderIconInv(ItemPipette.mask, -0.0635D);
                } else {
                    preRenderIconWorld(ItemPipette.mask, -0.0635D);
                }
                localTessellator.draw();

                RenderUtils.bindMinecraftBlockSheet();

                GL11.glDepthFunc(514);
                GL11.glDepthMask(false);

                localTessellator.startDrawingQuads();
                localTessellator.setNormal(0.0F, 0.0F, 1.0F);
                if (type.equals(IItemRenderer.ItemRenderType.INVENTORY)) {
                    preRenderIconInv(onStack.getIcon(), 10.0D);
                } else {
                    preRenderIconWorld(onStack.getIcon(), 0.001D);
                }
                localTessellator.draw();

                localTessellator.startDrawingQuads();
                localTessellator.setNormal(0.0F, 0.0F, -1.0F);
                if (type.equals(IItemRenderer.ItemRenderType.INVENTORY)) {
                    preRenderIconInv(onStack.getIcon(), -0.0635D);
                } else {
                    preRenderIconWorld(onStack.getIcon(), -0.0635D);
                }
                localTessellator.draw();

                GL11.glDisable(3042);
                GL11.glDepthMask(true);
                GL11.glDepthFunc(515);
                GL11.glEnable(2884);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            }
        }

        RenderUtils.bindMinecraftItemSheet();

        IIcon itemIcon = item.getIconIndex();
        if (!type.equals(IItemRenderer.ItemRenderType.INVENTORY)) {
            ItemRenderer.renderItemIn2D(Tessellator.instance, itemIcon.getMinU(), itemIcon.getMaxV(), itemIcon.getMaxU(), itemIcon.getMinV(), itemIcon.getIconWidth(), itemIcon.getIconHeight(), 0.0625F);
        }
        else {
            Tessellator.instance.startDrawingQuads();
            Tessellator.instance.addVertexWithUV(0.0D, 16.0D, 4.0D, itemIcon.getMinU(), itemIcon.getMaxV());
            Tessellator.instance.addVertexWithUV(16.0D, 16.0D, 4.0D, itemIcon.getMaxU(), itemIcon.getMaxV());
            Tessellator.instance.addVertexWithUV(16.0D, 0.0D, 4.0D, itemIcon.getMaxU(), itemIcon.getMinV());
            Tessellator.instance.addVertexWithUV(0.0D, 0.0D, 4.0D, itemIcon.getMinU(), itemIcon.getMinV());
            Tessellator.instance.draw();
        }
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glPopMatrix();
    }

    public static void preRenderIconWorld(IIcon paramIIcon, double paramDouble) {
        Tessellator.instance.addVertexWithUV(0.0D, 1.0D, paramDouble, paramIIcon.getMinU(), paramIIcon.getMaxV());
        Tessellator.instance.addVertexWithUV(1.0D, 1.0D, paramDouble, paramIIcon.getMaxU(), paramIIcon.getMaxV());
        Tessellator.instance.addVertexWithUV(1.0D, 0.0D, paramDouble, paramIIcon.getMaxU(), paramIIcon.getMinV());
        Tessellator.instance.addVertexWithUV(0.0D, 0.0D, paramDouble, paramIIcon.getMinU(), paramIIcon.getMinV());
    }

    public static void preRenderIconInv(IIcon paramIIcon, double paramDouble) {
        Tessellator.instance.addVertexWithUV(0.0D, 16.0D, paramDouble, paramIIcon.getMinU(), paramIIcon.getMaxV());
        Tessellator.instance.addVertexWithUV(16.0D, 16.0D, paramDouble, paramIIcon.getMaxU(), paramIIcon.getMaxV());
        Tessellator.instance.addVertexWithUV(16.0D, 0.0D, paramDouble, paramIIcon.getMaxU(), paramIIcon.getMinV());
        Tessellator.instance.addVertexWithUV(0.0D, 0.0D, paramDouble, paramIIcon.getMinU(), paramIIcon.getMinV());
    }
}
