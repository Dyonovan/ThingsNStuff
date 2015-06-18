package com.dyonovan.thingsnstuff.events;

import com.dyonovan.thingsnstuff.common.items.ItemBase;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class ToolTipEvent {
    @SubscribeEvent
    public void onToolTip(ItemTooltipEvent event) {
        if(event.itemStack.getItem() instanceof ItemBase) {
            ((ItemBase)event.itemStack.getItem()).onToolTip(event.toolTip, event.itemStack);
        }
    }
}
