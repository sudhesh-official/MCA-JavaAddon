package collections.Framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionArrayList {
	/**
	 * Overview of Java collections framework
		The Java Collections Framework is a set of classes and interfaces 
		that provide a standardized way of managing and manipulating 
		groups of objects. It offers a wide range of data structures 
		and algorithms to store, retrieve, and process collections of 
		objects efficiently.
		
		Core Interfaces:
		The Java Collections Framework includes several core interfaces
		that define the behavior and functionality of different types of 
		collections.
		● Collection: Represents a generic collection of objects.
		● List: Represents an ordered collection that allows duplicate elements.
		● Set: Represents an unordered collection that does not allow duplicate elements.
		● Map: Represents a mapping between unique keys and values.
		
		Common Implementations:
		● ArrayList: Implements the List interface using a dynamic array.
		● LinkedList: Implements the List interface using a doubly-linked list.
		● HashSet: Implements the Set interface using a hash table.
		● TreeSet: Implements the Set interface using a balanced binary tree.
		● HashMap: Implements the Map interface using a hash table.
		● TreeMap: Implements the Map interface using a balanced binary tree.
	 */
	
	public static void main(String[] args) {
		
		// A) List (Allows Duplicates, Ordered)
		
		// Creating an ArrayList
		List<String> names = new ArrayList<>();
		
		// Adding elements
		names.add("Alice");
		names.add("Bob");
		names.add("Charlie");
		
		System.out.println("Names: " + names);
		System.out.println("Size: " + names.size());
		names.remove("Charlie");
		System.out.println("Names: " + names);
		
		// Using enhanced for loop
		for(String name: names) {
			System.out.println("Hello, " + name + "!");
		}
		
		if (names.contains("Bob")) {
			System.out.println("Bob is in the list.");
		}
		
		/**
		 * 1. In the example above, an ArrayList is created to store a 
		 * collection of names.
		 * 2. Names are added to the list using the add() method.
		 * 3. The contains() method is used to check if the list 
		 * contains the name "Bob".
		 * 4. The remove() method removes the name "Charlie" from the list.
		 * 5. The size() method returns the size of the list.
		 * 6. loop is used to iterate over the elements of the list and
		 * print a greeting message for each name.
		 */
		
		/*
		 * The enhanced for loop (for-each loop) simplifies the 
		 * process of iterating over collections.
		 */
		
		/**
		 * The Iterator interface provides methods like hasNext() 
		 * and next() to iterate through elements.
		 */
		
		// Using iterator
		Iterator<String> iterator = names.iterator();
		while (iterator.hasNext()) {
			String name = iterator.next();
			System.out.println(name);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
