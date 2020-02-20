package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    protected void updateQuality() {
        if (this.quality < 50) {
            this.quality = this.quality + 1;
        }
    }

    protected void updateQualityExpireSellIn() {


        if (this.quality < 50) {
            this.quality = this.quality + 1;
        }

    }


}
