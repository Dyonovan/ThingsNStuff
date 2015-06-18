package com.dyonovan.thingsnstuff.managers;

import com.dyonovan.thingsnstuff.common.blocks.BlockBufferChest;
import com.dyonovan.thingsnstuff.common.blocks.BlockSwitch;
import com.dyonovan.thingsnstuff.common.tileentity.TileBufferChest;
import com.dyonovan.thingsnstuff.common.tileentity.TileSwitch;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

public class BlockManager {

    public static Block blockSwitch, blockSwitchOn, blockBufferChest;

    public static void init() {

        //BufferChest
        registerBlock(blockBufferChest = new BlockBufferChest("blockBufferChest", TileBufferChest.class), "blockBufferChest",
                TileBufferChest.class);

        //Redstone Switch
        registerBlock(blockSwitch = new BlockSwitch(false, "blockSwitch", TileSwitch.class), "blockSwitch", TileSwitch.class);
        registerBlock(blockSwitch = new BlockSwitch(true, "blockSwitchOn", TileSwitch.class), "blockSwitchOn", TileSwitch.class);

    }

    public static void registerBlock(Block block, String name, Class<? extends TileEntity> tileEntity) {
        GameRegistry.registerBlock(block, name);
        if (tileEntity != null)
            GameRegistry.registerTileEntity(tileEntity, name);
    }
}
