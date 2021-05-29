package com.a.introduction.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyGildedRoseCBackstagePassesTest {

	public static final int DEFAULT_QUALITY = 3;
	public static final int SELLIN_ABOVE_10 = 15;
	public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	public static final int SELL_IN_ABOVE_5 = 7;
	public static final int SELL_IN_BELOW_5 = 4;

	@Test
	public void backStagePassesBeyond10Days_qualityIncreasesBy1() {
		GildedRose app = getGildedRoseForOneItem(BACKSTAGE_PASSES, SELLIN_ABOVE_10, DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(BACKSTAGE_PASSES, SELLIN_ABOVE_10 - 1, DEFAULT_QUALITY + 1);

		assertItem(expected, app.items[0]);
	}

	@Test
	public void backStagePassesBetween5And10Days_qualityIncreasesBy2() {
		GildedRose app = getGildedRoseForOneItem(BACKSTAGE_PASSES, SELL_IN_ABOVE_5, DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(BACKSTAGE_PASSES, SELL_IN_ABOVE_5 - 1, DEFAULT_QUALITY + 2);

		assertItem(expected, app.items[0]);
	}

	@Test
	public void backStagePassesBelow5Days_qualityIncreasesBy3() {
		GildedRose app = getGildedRoseForOneItem(BACKSTAGE_PASSES, SELL_IN_BELOW_5, DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(BACKSTAGE_PASSES, SELL_IN_BELOW_5 - 1, DEFAULT_QUALITY + 3);

		assertItem(expected, app.items[0]);
	}

	private void assertItem(Item expected, Item actual) {
		assertEquals(expected.name, actual.name);
		assertEquals(expected.sellIn, actual.sellIn);
		assertEquals(expected.quality, actual.quality);
	}

	private GildedRose getGildedRoseForOneItem(String itemType, int sellin, int quality) {
		Item item = new Item(itemType, sellin, quality);
		Item[] items = new Item[]{item};
		return new GildedRose(items);
	}

}