package com.dyonovan.thingsnstuff.proxy;

import com.dyonovan.thingsnstuff.handlers.BlockHandler;
import com.dyonovan.thingsnstuff.client.renderer.ItemRenderBlockWire;
import com.dyonovan.thingsnstuff.client.renderer.RenderBlockWire;
import com.dyonovan.thingsnstuff.common.tileentity.TEBlockWire;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

    public void registerRenderer() {
        //BlockWire
        TileEntitySpecialRenderer render = new RenderBlockWire();
        ClientRegistry.bindTileEntitySpecialRenderer(TEBlockWire.class, render);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockHandler.blockWire),
                new ItemRenderBlockWire(render, new TEBlockWire()));
    }

    public void registerTESpecialRenderer() {

    }

}
