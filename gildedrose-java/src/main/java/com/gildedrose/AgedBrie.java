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

            if (isPass()) {
                if (this.sellIn < 11) {
                    if (this.quality < 50) {
                        this.quality = this.quality + 1;
                    }
                }

                if (this.sellIn < 6) {
                    if (this.quality < 50) {
                        this.quality = this.quality + 1;
                    }
                }
            }
        }
    }

}
