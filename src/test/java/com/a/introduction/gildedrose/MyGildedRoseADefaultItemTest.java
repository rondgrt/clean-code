package com.a.introduction.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyGildedRoseADefaultItemTest {

	public static final int NOT_EMPIRED_SELLIN = 15;
	public static final int DEFAULT_QUALITY = 3;
	public static final String DEFAULT_ITEM = "DEFAULT_ITEM";
	public static final int EXPIRED_SELLIN = -1;

	@Test
	public void unexpiredDefaultItem_QualityDecreasesBy1() {
		GildedRose app = getGildedRoseWithOneItem(DEFAULT_ITEM, NOT_EMPIRED_SELLIN, DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(DEFAULT_ITEM, NOT_EMPIRED_SELLIN - 1, DEFAULT_QUALITY -1);

		assertItem(expected, app.items[0]);
	}

	@Test
	public void expiredDefaultItem_qualityDecreasesBy2() {
		GildedRose app = getGildedRoseWithOneItem(DEFAULT_ITEM, EXPIRED_SELLIN, DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(DEFAULT_ITEM, EXPIRED_SELLIN -1, DEFAULT_QUALITY - 2);

		assertItem(expected, app.items[0]);
	}

	private void assertItem(Item expected, Item actual) {
		assertEquals(expected.name, actual.name);
		assertEquals(expected.sellIn, actual.sellIn);
		assertEquals(expected.quality, actual.quality);
	}

	private GildedRose getGildedRoseWithOneItem(String itemType, int sellin, int quality) {
		Item item = new Item(itemType, sellin, quality);
		Item[] items = new Item[]{item};
		return new GildedRose(items);
	}

}