package com.jop.stream;

/**
 * Stream interface.
 * 
 * @author julianopontes
 *
 */
public interface Stream {

	/**
	 * Retrieve next char of stream.
	 * 
	 * @return next char.
	 */
	char getNext();

	/**
	 * Validate if stream has ended.
	 * 
	 * @return validation.
	 */
	boolean hasNext();
}