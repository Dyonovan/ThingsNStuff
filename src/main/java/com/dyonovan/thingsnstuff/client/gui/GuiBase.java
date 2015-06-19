package com.dyonovan.thingsnstuff.client.gui;

import com.dyonovan.thingsnstuff.client.gui.component.NinePatchRenderer;
import com.dyonovan.thingsnstuff.common.container.ICustomSlot;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.util.StatCollector;

import java.awt.*;

public class GuiBase<T extends Container> extends GuiContainer {
    protected String title;
    protected T inventory;
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
        this.inventory = container;
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

        for(Object obj : inventory.inventorySlots) {
            if(obj instanceof ICustomSlot) {
                ICustomSlot slot = (ICustomSlot)obj;
                if(slot.getSlotSize() == ICustomSlot.SLOT_SIZE.LARGE)
                    this.drawTexturedModalRect(x + slot.getPoint().getFirst(), y + slot.getPoint().getSecond(), 0, 38, 26, 26);
                else
                    this.drawTexturedModalRect(x + slot.getPoint().getFirst(), y + slot.getPoint().getSecond(), 0, 20, 18, 18);
            } else if(obj instanceof Slot) {
                Slot slot = (Slot)obj;
                this.drawTexturedModalRect(x + slot.xDisplayPosition - 1, y + slot.yDisplayPosition - 1, 0, 20, 18, 18);
            }
        }
    }
}
