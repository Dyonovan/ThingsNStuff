package com.dyonovan.thingsnstuff.common.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerTrashBag extends Container {
    public ContainerTrashBag(InventoryPlayer playerInv, ItemStack bag) {

        bindPlayerInventory(playerInv);

        Slot replacer = new SlotNull(ICustomSlot.SLOT_SIZE.STANDARD, new InventoryNull(), 0, -1000, 0);
        addSlotToContainer(replacer);
        for(int i = 1; i < this.inventorySlots.size(); i++) {
            Slot temp = (Slot)this.inventorySlots.get(i);
            if(temp != null) {
                if(temp.getStack() != null) {
                    if(temp.getStack().equals(bag)) {
                        int x = temp.xDisplayPosition;
                        int y = temp.yDisplayPosition;
                        temp.xDisplayPosition = -1000;
                        replacer.xDisplayPosition = x;
                        replacer.yDisplayPosition = y;
                        break;
                    }
                }
            }
        }
        addSlotToContainer(new SlotNull(ICustomSlot.SLOT_SIZE.LARGE, new InventoryNull(), 0, 80, 35));
    }

    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
                        8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
        ItemStack stack = null;
        Slot slotObject = (Slot) inventorySlots.get(slot);

        //null checks and checks if the item can be stacked (maxStackSize > 1)
        if (slotObject != null && slotObject.getHasStack()) {
            ItemStack stackInSlot = slotObject.getStack();
            stack = stackInSlot.copy();

            if(slot != this.inventorySlots.size() - 1) {
                if (!this.mergeItemStack(stackInSlot, this.inventorySlots.size() - 1, this.inventorySlots.size(), true)) {
                    return null;
                }
            }

            if (stackInSlot.stackSize == 0) {
                slotObject.putStack(null);
            } else {
                slotObject.onSlotChanged();
            }

            if (stackInSlot.stackSize == stack.stackSize) {
                return null;
            }
            slotObject.onPickupFromSlot(player, stackInSlot);
        }
        return stack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_)
    {
        return true;
    }
}
