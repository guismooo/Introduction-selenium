import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;
public class javaStreams {

	//count the number of names starting with alphabet A in list
	@Test
	public void regular()
	{
	ArrayList<String> names = new ArrayList<String>();
	names.add("Aba");
	names.add("don");
	names.add("Alexa");
	names.add("Adam");
	names.add("Ram");
	int count =0;
	for(int i=0; i<names.size();i++)
	{
		String actual=names.get(i);
		if(actual.startsWith("A"))
		{
			count++;
		}

	}
	System.out.println(count);
	}
	@Test
	public void streamFilter()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Aba");
		names.add("don");
		names.add("Alexa");
		names.add("Adam");
		names.add("Ram");
		
		//convert array list into stream, then in a single line we can do the filtering we want.
		//here "s" is acting same as String actual in previous code.
		Long c = names.stream().filter(s->s.startsWith("A")).count(); // why type here is long?
		System.out.println(c);
		
		// you can directly create a stream, for practice this is easier
		//Stream.of("Aba","don","Alexa","Adam","Ram").filter(s->s.startsWith("A")); // There is no life for intermediate operation (filter) if there is no terminal op (count)
		//Terminal operation will execute only if intermediate op (filter) returns true.
		//
		long d = Stream.of("Aba","don","Alexa","Adam","Ram").filter(s->
		{
			s.startsWith("A");	
			return true;
		}).count();
		System.out.println(d);
		
		//Print all names in list
		names.stream().filter(s->s.length()>0).forEach(s->System.out.println(s));
		//takes String list, filter by length >0 and for each result, print it
		
		//Print only fist name. add .limit(1) to the filter
		names.stream().filter(s->s.length()>0).limit(1).forEach(s->System.out.println(s));
	}
	
	@Test
	public void streamMap()
	{
		
		//print names which have lat letter as "a" TO Uppercase
		//Use map to convert to uppercase
		Stream.of("Abafawf","donfawf","lexa","Tedam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		//if I want to print all names in uppercase, no need filter.
		Stream.of("Abafawf","donfawf","lexa","Tedam","Rama").map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		//Print names which have first letter as "a" with Uppercase and sorted.
		//Convert array to list
		List<String> names1 = Arrays.asList("Abafawf","Aonfawf","lexa","Tedam","Ama");
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));

		System.out.println("---------------------------");
		//Merging 2 different lists.
		ArrayList<String> names = new ArrayList<String>();
		names.add("man");
		names.add("deni");
		names.add("seaattle");
		Stream<String> newStream=Stream.concat(names.stream(), names1.stream());
		newStream.forEach(s->System.out.println(s));
		
		//Check if present in stream.
		List<String> names2 = Arrays.asList("Abafawf","Aonfawf","lexa","Tedam","Ama");
		boolean flag=names2.stream().anyMatch(s->s.equalsIgnoreCase("Ama")); // will run code successfully, because name is found
		Assert.assertTrue(flag);
		System.out.println("---------------------------");
		
	}
	@Test
	public void streamCollect()
	{
		//collect results and convert back into any list.
		List<String> ls=Stream.of("Abafawf","donfawf","lexa","Tedam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println("streamCollect :"+ls.get(0)); // If I want to print out first result
		
		//Print unique numbers from this array.
		List<Integer> numbers = Arrays.asList(3,2,2,7,5,1,9,7);
		//Sort the array
		System.out.println("---------------------------");
		numbers.stream().distinct().forEach(s->System.out.println(s)); //done, beautiful!
		System.out.println("---------------------------");
		//sort the array and give me 3rd index
		System.out.println("---------------------------");
		List<Integer> li= numbers.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
		System.out.println("---------------------------");
	
	
	
	}

}
