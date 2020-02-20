package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    protected boolean isAgedBrie() {
        return true;
    }

    protected void updateQuality() {
        if (this.quality < 50) {
            this.quality = this.quality + 1;
        }
    }

    protected void updateQualityExpireSellIn() {
        if (this.sellIn < 0) {

            if (this.quality < 50) {
                this.quality = this.quality + 1;
            }

        }
    }

}
