package com.dyonovan.thingsnstuff.managers;

import com.dyonovan.thingsnstuff.common.items.ItemPipette;
import com.dyonovan.thingsnstuff.common.items.ItemTrashBag;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ItemManager {
    public static Item trashBag;
    public static Item pipette;

    public static void init() {
        trashBag = new ItemTrashBag("trashBag", "item.trashBag.description");

        GameRegistry.registerItem(trashBag, "trashBag");

        GameRegistry.addRecipe(new ItemStack(trashBag, 1),
                "S S",
                "L L",
                "LLL", 'L', Items.leather, 'S', Items.string);


        pipette = new ItemPipette("pipette");

        GameRegistry.registerItem(pipette, "pipette");

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(pipette, 1),
                "GG ",
                "GG ",
                "  G", 'G', "paneGlass"));
    }
}
