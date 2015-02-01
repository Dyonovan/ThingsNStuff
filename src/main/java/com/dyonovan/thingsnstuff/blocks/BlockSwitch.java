package com.dyonovan.thingsnstuff.blocks;

import com.dyonovan.thingsnstuff.handlers.BlockHandler;
import com.dyonovan.thingsnstuff.lib.Constants;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSwitch extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon top;

    public boolean isOn;

    public BlockSwitch(boolean isOn) {
        super(Material.circuits);

        this.isOn = isOn;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Constants.MODID + ":switch_side");
        this.top = iconRegister.registerIcon(isOn ? Constants.MODID + ":switch_on" : Constants.MODID + ":switch_off");
    }

    public IIcon getIcon(int side, int meta) {
        if (side == 1) return this.top;
        else return this.blockIcon;
    }

    @Override
    public boolean canProvidePower()
    {
        return true;
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess blockAccess, int x, int y, int z, int unknown) {
        return (isOn) ? 15 : 0;
    }

    @Override
    public int isProvidingStrongPower(IBlockAccess blockAccess, int x, int y, int z, int side) {
        if(!isOn) return 0;
        else {
            return 15;
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta,
                                    float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            if (isOn) world.setBlock(x, y, z, BlockHandler.blockSwitch);
            else world.setBlock(x, y, z, BlockHandler.blockSwitchOn);
            world.playSoundEffect((double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D, "random.click", 0.3F, 0.6F);

            world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
            world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
            world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
            world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
            world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
            world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
        }


        return true;
    }

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
