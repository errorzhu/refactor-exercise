package com.gildedrose;

public class Pass extends Item {
    public Pass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    protected void updateQuality() {
        if (this.quality < 50) {
            this.quality = this.quality + 1;


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


    protected void updateQualityExpireSellIn() {


        this.quality = 0;


    }

}
