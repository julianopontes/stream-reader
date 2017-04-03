package com.jop.stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Test;

public class CharStreamTest {

	private Stream stream;

	@Test(expected = IllegalArgumentException.class)
	public void testCreateNullStream() {
		stream = new CharStream(null);
	}

	@Test
	public void testHasNext() {
		stream = new CharStream("A".toCharArray());

		assertTrue(stream.hasNext());
	}

	@Test
	public void testHasNextEmptyStream() {
		stream = new CharStream(new char[0]);

		assertFalse(stream.hasNext());
	}

	@Test
	public void testGetNext() {
		stream = new CharStream("A".toCharArray());

		assertEquals('A', stream.getNext());
	}

	@Test(expected = NoSuchElementException.class)
	public void testGetNextEmptyStream() {
		stream = new CharStream(new char[0]);

		stream.getNext();
	}
}