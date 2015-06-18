package com.dyonovan.thingsnstuff.common.items;

import com.dyonovan.thingsnstuff.lib.MinecraftStringColor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;

import java.util.List;

public class ItemPipette extends ItemBase {
    public static final String LIQUID_TAG = "Contains Fluid";
    public static final String LIQUID_AMOUNT = "Fluid Amount";
    public static final String LIQUID_TYPE = "Fluid Type";

    public static IIcon mask;

    public ItemPipette(String unlocalizedName) {
        super(unlocalizedName);
    }

    @Override
    public void onToolTip(List<String> toolTip, ItemStack stack) {
        if(stack.hasTagCompound() && stack.getTagCompound().getBoolean(LIQUID_TAG)) {
            toolTip.add(MinecraftStringColor.DARK_BLUE + "Fluid: " + MinecraftStringColor.WHITE + FluidRegistry.getFluid(stack.getTagCompound().getInteger(LIQUID_TYPE)).getLocalizedName());
            toolTip.add(MinecraftStringColor.YELLOW + "Amount: " + MinecraftStringColor.WHITE + stack.getTagCompound().getInteger(LIQUID_AMOUNT) + " mb");
        } else
            toolTip.add("Right click a block with a tank to drain a maximum of 250mb");
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int a, float b, float c, float f) {

        Block clickedOn = world.getBlock(x, y, z);

        if(stack.getTagCompound() != null) {
            NBTTagCompound tag = stack.getTagCompound();
            if(tag.getBoolean(LIQUID_TAG)) {
                if(clickedOn.hasTileEntity(world.getBlockMetadata(x, y, z))) {
                    TileEntity tile = world.getTileEntity(x, y, z);
                    if(tile instanceof IFluidHandler) {
                        IFluidHandler tank = (IFluidHandler)tile;
                        FluidStack toFill = new FluidStack(FluidRegistry.getFluid(stack.getTagCompound().getInteger(LIQUID_TYPE)), stack.getTagCompound().getInteger(LIQUID_AMOUNT));
                        for(ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
                            int drained = tank.fill(dir, toFill, true);
                            if(drained > 0) {
                                if(drained == stack.getTagCompound().getInteger(LIQUID_AMOUNT))
                                    stack.setTagCompound(null);
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        } else {
            if(clickedOn.hasTileEntity(world.getBlockMetadata(x, y, z))) {
                TileEntity tile = world.getTileEntity(x, y, z);
                if(tile instanceof IFluidHandler) {
                    IFluidHandler tank = (IFluidHandler) tile;
                    for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
                        if (tank.getTankInfo(dir) != null) {
                            for (FluidTankInfo info : tank.getTankInfo(dir)) {
                                if (info.fluid != null) {

                                    //Get the fluid amount. Can't be more than 1/4 bucket
                                    int drained = Math.min(info.fluid.amount, (FluidContainerRegistry.BUCKET_VOLUME / 4));
                                    Fluid fluidType = info.fluid.getFluid();

                                    //Drain what was taken from the tank
                                    tank.drain(dir, new FluidStack(fluidType, drained), true);

                                    //Build and set tag
                                    NBTTagCompound newTag = new NBTTagCompound();
                                    newTag.setBoolean(LIQUID_TAG, true);
                                    newTag.setInteger(LIQUID_AMOUNT, drained);
                                    newTag.setInteger(LIQUID_TYPE, fluidType.getID());
                                    stack.setTagCompound(newTag);
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        super.registerIcons(iconRegister);
        mask = iconRegister.registerIcon("thingsnstuff:" + (this.getUnlocalizedName().substring(5)) + "Mask");
    }
}
