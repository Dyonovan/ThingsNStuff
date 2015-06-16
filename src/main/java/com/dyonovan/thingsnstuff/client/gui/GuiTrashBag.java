package com.dyonovan.thingsnstuff.client.gui;

import com.dyonovan.thingsnstuff.common.container.ContainerTrashBag;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiTrashBag extends GuiContainer {
    private static final ResourceLocation texture = new ResourceLocation("thingsnstuff:textures/gui/trashBagGui.png");

    public GuiTrashBag(InventoryPlayer inventoryPlayer, ItemStack bag) {
        super(new ContainerTrashBag(inventoryPlayer, bag));
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        final String invTitle = "Trash Bag";
        fontRendererObj.drawString(invTitle, xSize / 2 - fontRendererObj.getStringWidth(invTitle) / 2, 6, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f(1f, 1f, 1f, 1f);

        this.mc.getTextureManager().bindTexture(texture);

        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
}
