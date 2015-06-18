package com.dyonovan.thingsnstuff.common.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;

public class BlockBufferChest extends BlockBase {

    @SideOnly(Side.CLIENT)
    private IIcon top;

    public BlockBufferChest(String name, Class<? extends TileEntity> tileClass) {
        super(Material.wood, name, tileClass);
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
