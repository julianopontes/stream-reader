package com.jop.stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Utility char class.
 * 
 * @author julianopontes
 *
 */
public class FirstNotRepeatedChar {

	/**
	 * Find first not repeated char in a Stream.
	 * 
	 * @param input
	 * @return found char.
	 */
	public static char firstChar(Stream input) {
		char found = 0;

		/**
		 * Stores the stream in a list with dinamic size, because Stream doesn't
		 * provide method for getting size.
		 */
		List<Character> listChar = new ArrayList<Character>();
		while (input.hasNext()) {
			listChar.add(input.getNext());
		}

		// List for storing characters already found repeated.
		Set<Character> blacklist = new HashSet<Character>();

		// Store list size to avoid call method List.size() every time needed.
		int listSize = listChar.size();

		/*
		 * Iteration over list to compare if cursor is repeated, until list is over
		 * or char is found.
		 */
		for (int i = 0; i < listSize && found == 0; i++) {
			Character cursor = listChar.get(i);

			// Verify if cursor is already found repeated.
			if (blacklist.contains(cursor)) {
				continue;
			}

			/**
			 * Assign cursor to found, for using as a return case cursor does not
			 * repeat.
			 */
			found = cursor;

			// Iteration over the rest of the list for verifying if cursor repeats.
			for (int j = i + 1; j < listSize; j++) {

				// Assign current for verification.
				Character current = listChar.get(j);

				/**
				 * Verify if cursor is repeated, case it is, assign null to cursor,
				 * black list cursor and move cursor for next position.
				 */
				if (cursor == current) {
					found = 0;
					blacklist.add(cursor);
					break;
				}
			}
		}

		// Case first char not repeated doesn't exists, show friendly message.
		if (found == 0) {
			System.out.println("First character without repetition not found! :(");
		}

		// return found result.
		return found;
	}
}