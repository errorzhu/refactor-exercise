package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }


    public void update() {
        updateQuality();
        updateSellIn();
        updateQualityExpireSellIn();
    }

    private void updateQualityExpireSellIn() {
        if (this.sellIn < 0) {
            if (!isAgedBrie()) {
                if (!isPass()) {
                    if (this.quality > 0) {
                        if (!isSul()) {
                            this.quality = this.quality - 1;
                        }
                    }
                } else {
                    this.quality = 0;
                }
            } else {
                if (this.quality < 50) {
                    this.quality = this.quality + 1;
                }
            }
        }
    }

    protected void updateSellIn() {

        this.sellIn = this.sellIn - 1;

    }

    private void updateQuality() {
        if (!isAgedBrie()
                && !isPass()) {
            if (this.quality > 0) {
                if (!isSul()) {
                    this.quality = this.quality - 1;
                }
            }
        } else {
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

    protected boolean isSul() {
        return false;
    }

    protected boolean isPass() {
        return false;
    }

    protected boolean isAgedBrie() {
        return false;
    }


    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
