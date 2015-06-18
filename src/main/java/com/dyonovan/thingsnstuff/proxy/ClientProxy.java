package com.dyonovan.thingsnstuff.proxy;

import com.dyonovan.thingsnstuff.client.renderer.ItemRendererPipette;
import com.dyonovan.thingsnstuff.managers.ItemManager;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

    public void registerRenderer() {
        MinecraftForgeClient.registerItemRenderer(ItemManager.pipette, new ItemRendererPipette());
    }

    public void registerTESpecialRenderer() {

    }

}
