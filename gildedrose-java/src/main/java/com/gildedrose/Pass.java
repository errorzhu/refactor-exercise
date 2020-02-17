package com.gildedrose;

public class Pass extends Item {
    public Pass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    protected boolean isPass() {
        return true;
    }
}
