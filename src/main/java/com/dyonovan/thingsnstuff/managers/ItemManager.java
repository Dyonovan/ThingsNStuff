package com.dyonovan.thingsnstuff.managers;

import com.dyonovan.thingsnstuff.common.items.ItemTrashBag;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class ItemManager {
    public static Item trashBag;

    public static void init() {
        trashBag = new ItemTrashBag("trashBag", "item.trashBag.description");

        GameRegistry.registerItem(trashBag, "thingsnstuff:trashBag");

        CraftingManager.getInstance().addRecipe(new ItemStack(trashBag, 1),
                "S S",
                "L L",
                "LLL", 'L', Items.leather, 'S', Items.string);
    }
}
