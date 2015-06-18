package com.dyonovan.thingsnstuff.client.gui;

import com.dyonovan.thingsnstuff.client.gui.component.NinePatchRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.StatCollector;

public class GuiBase<T extends Container> extends GuiContainer {
    protected String title;
    protected NinePatchRenderer background = new NinePatchRenderer();

    /**
     * Constructor for All Guis
     * @param container Inventory Container
     * @param width XSize
     * @param height YSize
     * @param name The inventory title
     */
    public GuiBase(T container, int width, int height, String name) {
        super(container);
        this.xSize = width;
        this.ySize = height;
        this.title = name;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        fontRendererObj.drawString(StatCollector.translateToLocal(title), xSize / 2 - fontRendererObj.getStringWidth(StatCollector.translateToLocal(title)) / 2, 6, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        background.render(this, x, y, xSize, ySize);
    }
}
