package com.dyonovan.thingsnstuff.common.container;

import com.dyonovan.thingsnstuff.lib.Couplet;

public interface ICustomSlot {
    public enum SLOT_SIZE {
        STANDARD,
        LARGE
    }

    public SLOT_SIZE getSlotSize();

    public Couplet<Integer, Integer> getPoint();
}
