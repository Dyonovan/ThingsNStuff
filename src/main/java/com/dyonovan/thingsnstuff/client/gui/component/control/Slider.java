package com.dyonovan.thingsnstuff.client.gui.component.control;

import com.dyonovan.thingsnstuff.client.gui.component.BaseComponent;
import com.dyonovan.thingsnstuff.util.RenderUtils;
import org.lwjgl.opengl.GL11;

public class Slider extends BaseComponent {
    protected int width;
    protected int boxX;
    protected int boxY;

    //Locations on texture sheet
    private static final int BAR_U = 32;
    private static final int BAR_V = 0;
    private static final int BOX_U = 32;
    private static final int BOX_V = 3;

    public Slider(int x, int y, int length) {
        super(x, y);
        width = length;
    }

    @Override
    public void initialize() {}

    @Override
    public void render(int guiLeft, int guiTop) {
        GL11.glPushMatrix();

        GL11.glTranslated(guiLeft + xPos, guiTop + yPos, 0);
        RenderUtils.bindGuiComponentsSheet();

        //Start the bar
        GL11.glPushMatrix();
        GL11.glTranslatef(0, 4, 0);
        drawTexturedModalRect(0, 0, BAR_U, BAR_V + 1, 1, 1);

        //Render middle out to edge
        GL11.glPushMatrix();
        GL11.glTranslatef(1, -1, 0); //Move over and up
        GL11.glScaled(width - 2, 1, 0); //Scale to other end
        drawTexturedModalRect(0, 0, BAR_U + 1, BAR_V, 1, 3);
        GL11.glPopMatrix();

        //End the bar
        GL11.glTranslatef(width - 1, 0, 0);
        drawTexturedModalRect(0, 0, BAR_U + 2, BAR_V + 1, 1, 1);

        GL11.glPopMatrix();

        //Render the box
        GL11.glTranslatef(1, 0, 0);
        drawTexturedModalRect(0, 0, BOX_U, BOX_V, 4, 9);

        GL11.glPopMatrix();
    }

    @Override
    public void renderOverlay(int guiLeft, int guiTop) {

    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }
}
