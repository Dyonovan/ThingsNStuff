package com.dyonovan.thingsnstuff.client.gui.component;

import net.minecraft.client.gui.Gui;

public interface IComponent {
    /**
     * Called to render the component
     * @param gui The parent gui. Required for placement and rendering
     */
    public void render(Gui gui);
}
