package org.paumard.chaining;

import org.paumard.chaining.model.Person;
import org.paumard.chaining.util.Comparator;

public class PlayWithComparators {

	public static void main(String[] args) {

		Person mary = new Person("Mary", 28);
		Person john = new Person("John", 22);
		Person linda = new Person("Linda", 26);
		Person james = new Person("James", 32);
		Person jamesBis = new Person("James", 26);

		Comparator<Person> cmp =
				Comparator.comparing(Person::getName)
 					      .thenComparing(Person::getAge);

		Comparator<Person> reversed = cmp.reversed();

		System.out.println("Mary > John : " + (cmp.compare(mary, john) > 0));
		System.out.println("John > James : " + (cmp.compare(john, james) > 0));
		System.out.println("Linda > John : " + (cmp.compare(linda, john) > 0));
		System.out.println("James > James Bis : " + (cmp.compare(james, jamesBis) > 0));


		System.out.println("Mary > John : " + (reversed.compare(mary, john) > 0));
		System.out.println("John > James : " + (reversed.compare(john, james) > 0));
		System.out.println("Linda > John : " + (reversed.compare(linda, john) > 0));
		System.out.println("James > James Bis : " + (reversed.compare(james, jamesBis) > 0));

	}
}
