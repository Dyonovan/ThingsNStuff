package com.dyonovan.thingsnstuff.common.blocks;

import com.dyonovan.thingsnstuff.ThingsNStuff;
import com.dyonovan.thingsnstuff.lib.Constants;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBase extends BlockContainer {

    protected String name;
    protected Class<? extends TileEntity> tileClass;

    protected BlockBase(Material mat, String name, Class<? extends TileEntity> tileClass) {
        super(mat);
        this.name = name;
        this.tileClass = tileClass;

        this.setBlockName(Constants.MODID + ":" + name);
        this.setCreativeTab(ThingsNStuff.tabThingsNStuff);
        this.setHardness(2.0F);
    }

    public String getName() {
        return name;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        if(tileClass != null) {
            try {
                return tileClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
