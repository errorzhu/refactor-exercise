package com.gildedrose;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TexttestFixture {
    public static void main(String[] args) {

        System.out.println(printOutput());

    }

    public static String printOutput() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bos);
        ps.println("OMGHAI!");

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new AgedBrie("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Sulfuras("Sulfuras, Hand of Ragnaros", -1, 80),
                new Pass("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Pass("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Pass("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Pass("Backstage passes to a TAFKAL80ETC concert", 1, 20),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 3;
        for (int i = 0; i < days; i++) {
            ps.println("-------- day " + i + " --------");
            ps.println("name, sellIn, quality");
            for (Item item : items) {
                ps.println(item);
            }
            ps.println();
            app.updateQuality();
        }
        return bos.toString();
    }

}
