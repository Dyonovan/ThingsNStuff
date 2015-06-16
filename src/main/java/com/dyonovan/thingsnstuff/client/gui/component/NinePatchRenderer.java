package com.dyonovan.thingsnstuff.client.gui.component;

import com.dyonovan.thingsnstuff.lib.Constants;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.awt.*;

/**
 * Allows for a dynamic sizing 2D renderer
 */
public class NinePatchRenderer {

    private int u;
    private int v;

    private ResourceLocation patchLocation;

    /**
     * Default Constructor
     */
    public NinePatchRenderer() {
        this(false);
    }

    /**
     * Used to specify if it is to be colored or default
     * @param isColored Is it colored
     */
    public NinePatchRenderer(boolean isColored) {
        //TODO: Offset u and v for white slate
        //TODO: Find default location, probably 0, 0

        u = 0;
        v = 0;

        //TODO: Add default location for Resource
        patchLocation = new ResourceLocation(Constants.MODID, "LOCATION");
    }

    /**
     * Used to specify a nine patch that isn't the default sheet
     * @param resource Location of the patch
     * @param resourceU Resource U
     * @param resourceV Resource V
     */
    public NinePatchRenderer(ResourceLocation resource, int resourceU, int resourceV) {
        u = resourceU;
        v = resourceV;

        patchLocation = resource;
    }

    /**
     * Partial Rendering Code
     *
     * This can be overwritten in a new instance of the class to disable certain parts from rendering or to give them a
     * different behavior. One instance would be for a tab, you can prevent the left edge from rendering in that way
     */

    //TODO: Create Rendering Code
    //Corners
    protected void renderTopLeftCorner(Gui gui) {}

    protected void renderTopRightCorner(Gui gui, int width) {}

    protected void renderBottomLeftCorner(Gui gui, int height) {}

    protected void renderBottomRightCorner(Gui gui, int width, int height) {}

    //Edges
    protected void renderTopEdge(Gui gui, int width) {}

    protected void renderBottomEdge(Gui gui, int width, int height) {}

    protected void renderLeftEdge(Gui gui, int height) {}

    protected void renderRightEdge(Gui gui, int width, int height) {}

    //Background
    protected void renderBackground(Gui gui, int width, int height) {}


    public void render(Gui gui, int x, int y, int width, int height, Color color) {}

    public static void setColor(Color color) {
        GL11.glColor4d(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }

}
