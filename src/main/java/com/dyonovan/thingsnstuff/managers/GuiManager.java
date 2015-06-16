package com.dyonovan.thingsnstuff.managers;

import com.dyonovan.thingsnstuff.container.ContainerTrashBag;
import com.dyonovan.thingsnstuff.gui.GuiTrashBag;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiManager implements IGuiHandler
{
    public static final int TRASH_BAG_GUI_ID = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch(ID) {
            case TRASH_BAG_GUI_ID :
                return new ContainerTrashBag(player.inventory, player.getHeldItem());
            default :
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch(ID) {
            case TRASH_BAG_GUI_ID :
                return new GuiTrashBag(player.inventory, player.getHeldItem());
            default :
                return null;
        }
    }
}
