package com.gildedrose;

public class Sulfuras extends Item {

    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    protected boolean isSul() {
        return true;
    }

    protected void updateSellIn() {

    }

    protected void updateQuality() {

    }

    protected void updateQualityExpireSellIn() {

    }
}
