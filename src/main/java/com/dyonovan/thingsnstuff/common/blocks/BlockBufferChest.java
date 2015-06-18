package com.dyonovan.thingsnstuff.common.blocks;

import com.dyonovan.thingsnstuff.common.tileentity.TileBufferChest;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;

public class BlockBufferChest extends BlockBase {

    @SideOnly(Side.CLIENT)
    private IIcon top;

    public BlockBufferChest() {
        super(Material.wood, "blockBufferChest", TileBufferChest.class);
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
}
