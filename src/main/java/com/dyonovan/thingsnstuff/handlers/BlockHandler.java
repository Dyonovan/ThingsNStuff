package com.dyonovan.thingsnstuff.handlers;

import com.dyonovan.thingsnstuff.ThingsNStuff;
import com.dyonovan.thingsnstuff.common.blocks.BlockSwitch;
import com.dyonovan.thingsnstuff.common.blocks.BlockWire;
import com.dyonovan.thingsnstuff.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class BlockHandler {

    public static Block blockSwitch, blockSwitchOn, blockWire;

    public static void init() {

        blockSwitch = new BlockSwitch(false)
                .setBlockName(Constants.MODID + ":blockSwitch")
                .setCreativeTab(ThingsNStuff.tabThingsNStuff);
        blockSwitchOn = new BlockSwitch(true)
                .setBlockName(Constants.MODID + ":blockSwitchOn");

        blockWire = new BlockWire();

        GameRegistry.registerBlock(blockSwitch, "blockSwitch");
        GameRegistry.registerBlock(blockSwitchOn, "blockSwitchOn");
        GameRegistry.registerBlock(blockWire, "blockWire");

    }
}
