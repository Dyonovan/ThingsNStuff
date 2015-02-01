package com.dyonovan.thingsnstuff.blocks;

import com.dyonovan.thingsnstuff.ThingsNStuff;
import com.dyonovan.thingsnstuff.lib.Constants;
import com.dyonovan.thingsnstuff.tileentity.TEBlockWire;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWire extends BlockContainer {


    public BlockWire() {
        super(Material.circuits);
        this.setHardness(1.5F);
        this.setCreativeTab(ThingsNStuff.tabThingsNStuff);
        this.setBlockName(Constants.MODID + ":blockWire");
        this.setBlockTextureName(Constants.MODID + ":wire");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int var1) {
        return new TEBlockWire();
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    /*@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
         this.blockIcon = iconRegister.registerIcon(isOn ? Constants.MODID + ":wire_on" : Constants.MODID + ":wire_off");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return this.blockIcon;
    }*/

    @Override
    public boolean canProvidePower()
    {
        return true;
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess blockAccess, int x, int y, int z, int side)
    {

            int i1 = blockAccess.getBlockMetadata(x, y, z);

            if (i1 == 0) {
                return 0;
            } else {
                return i1;
            }

    }

    /*@Override
    public int isProvidingStrongPower(IBlockAccess blockAccess, int x, int y, int z, int side) {
        if(!isOn) return 0;
        else {
            return 15;
        }
    }*/

}
