package com.dyonovan.thingsnstuff.common.container;

import com.dyonovan.thingsnstuff.managers.ItemManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class SlotNull extends Slot
{
    public SlotNull(IInventory iInventory, int i, int i1, int i2)
    {
        super(iInventory, i, i1, i2);
    }

    @Override
    public IIcon getBackgroundIconIndex()
    {
        return ItemManager.trashBag.getIcon(new ItemStack(ItemManager.trashBag, 1), 0);
    }
}
