package com.dyonovan.thingsnstuff.items;

import com.dyonovan.thingsnstuff.ThingsNStuff;
import com.dyonovan.thingsnstuff.managers.GuiManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTrashBag extends ItemBase {

    public ItemTrashBag(String i, String j) {
        super(i, j);
        this.setMaxStackSize(1);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (!world.isRemote) {
            entityPlayer.openGui(ThingsNStuff.instance, GuiManager.TRASH_BAG_GUI_ID, world, (int)entityPlayer.posX, (int)entityPlayer.posY, (int)entityPlayer.posZ);
        }
        return itemStack;
    }
}
