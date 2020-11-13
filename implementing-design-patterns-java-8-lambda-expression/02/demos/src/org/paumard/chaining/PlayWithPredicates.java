package org.paumard.chaining;

import org.paumard.chaining.function.Predicate;

import java.util.Objects;

public class PlayWithPredicates {

	public static void main(String[] args) {

		Predicate<String> p1 = Objects::nonNull;
		Predicate<String> p2 = String::isEmpty;

		Predicate<String> p3 = p1.and(p2.negate());

		System.out.println("Test for null: " + p3.test(null));
		System.out.println("Test for empty: " + p3.test(null));
		System.out.println("Test for empty: " + p2.test(""));
		System.out.println("Test for non empty: " + p3.test("Hello"));
	}
}
