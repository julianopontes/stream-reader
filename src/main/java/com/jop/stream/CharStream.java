package com.jop.stream;

import java.util.NoSuchElementException;

/**
 * 
 * 
 * @author julianopontes
 *
 */
public class CharStream implements Stream {

	private final char[] value;
	private final int length;
	private int position = 0;

	public CharStream(char[] value) {
		if (value == null) {
			throw new IllegalArgumentException("inform value!");
		}
		
		this.value = value;
		length = value.length;
	}

	@Override
	public char getNext() {
		if (position >= length)
			throw new NoSuchElementException();

		return value[position++];
	}

	@Override
	public boolean hasNext() {
		return position < length;
	}
}