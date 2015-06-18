package com.dyonovan.thingsnstuff.common.container;

import com.dyonovan.thingsnstuff.lib.Couplet;
import com.dyonovan.thingsnstuff.managers.ItemManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import javax.vecmath.Vector2d;

public class SlotNull extends Slot implements ICustomSlot {
    private SLOT_SIZE size;

    public SlotNull(SLOT_SIZE slotSize, IInventory iInventory, int i, int i1, int i2) {
        super(iInventory, i, i1, i2);
        this.size = slotSize;
    }

    @Override
    public IIcon getBackgroundIconIndex() {
        if(size == SLOT_SIZE.STANDARD)
            return ItemManager.trashBag.getIcon(new ItemStack(ItemManager.trashBag, 1), 0);
        else
            return null;
    }

    @Override
    public SLOT_SIZE getSlotSize() {
        return size;
    }

    @Override
    public Couplet<Integer, Integer> getPoint() {
        switch (size) {
            case LARGE :
                return new Couplet<>(xDisplayPosition - 5, yDisplayPosition - 5);
            default :
                return new Couplet<>(xDisplayPosition - 1, yDisplayPosition - 1);
        }
    }
}
