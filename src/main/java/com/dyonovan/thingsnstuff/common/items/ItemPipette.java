package com.dyonovan.thingsnstuff.common.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemPipette extends ItemBase {
    private static final String LIQUID_TAG = "Contains Fluid";

    public ItemPipette(String unlocalizedName) {
        super(unlocalizedName);
    }

    @Override
    public void onToolTip(List<String> toolTip, ItemStack stack) {

    }

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int a, float b, float c, float f) {

        return false;
    }
}
