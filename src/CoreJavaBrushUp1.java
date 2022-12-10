import java.util.ArrayList;

public class CoreJavaBrushUp1 {

	public static void main(String[] args) {

		//creating variables name
		int num =5;
		String website = "www.google.com";
		//char letter ="r";
		float decimal = 5;
		double decimal2 = 4.88;
		boolean mycard = true;
		
		//Arrays
		
		//This will store 5 integer elements
		//Downside os this method is it limits the size of array and cannot be changed later
		int [] arr = new int [5];
		arr[0]=1;
		arr[1]=2;
		arr[2]=3;
		arr[3]=4;
		arr[4]=5;
		
		int [] arr2 = {1,2,3,4,5,6};
		
		//for loop
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		
		String [] name = {"rahul","shetty","selecnium"};
		for(int i=0;i<name.length;i++)
		{
			System.out.println(name[i]);
		}
		
		//another way (shorter), for every element in name, the iterarion will pick one and store in s
		for (String s: name)
		{
			System.out.println(s);
		}
		
		//Print values that are multiples of 2 in array2
		for(int i=0;i<arr2.length;i++)
		{
			if(arr2[i]%2==0)
			{
				System.out.println(arr2[i]);
			}
		}
		
		
		//What is arraylist and difference to Arrays
		//It lets you dinamically increase the size of array
		//this example will store only string values
		ArrayList<String> a = new ArrayList();
		// create object of the class to access the object by object.method
		//do not forgot import java.util.ArrayList;
		a.add("test");
		a.add("shetty");
		a.add("bobo");
		
		//to remove shetty:
		a.remove(1);
		
		//to extract values:
		a.get(0);
		
		//iterating over arrays and arraylists
		for(int i=0;i<a.size();i++)
		{
			System.out.println(a.get(i));
		}
		//or
		for ( String val :a)
		{
			System.out.println(val);
		}
		
		//Item is present in arraylist
		a.contains("bobo"); // will output true
		
		//convert normal array into arraylist
		//List<int> array2List = Arrays.asList(arr2);
		
		//String in java
		//In java string is an object that represents a sequence of characters
		//Two ways to create string object
		String s = "Test string";
		//Now if we try to create a new string sa with same string content it will not create a new record in memory
		//Instead it will link to previous declared variable s
		
		//Another way:
		String s2 = new String("New string Content"); // a new object s2 is created and "New String" is stored
		String s3 = new String("New String"); // here it creates a new object, regardless if test is the same, explicit I am saying to create it
		
		//Split method
		String[] splittedString = s.split(" ");//splitting based on white spaces
		
		String[] splittedString2 = s2.split("string");
		//The result of this split will be "New " and " Content"
		//There will be white spaces, to remove them if not desired, we use trim

		System.out.println(splittedString2[0].trim());
		System.out.println(splittedString2[1].trim());
		
		//How to print letter by letter from a string:
		for(int i=0;i<s2.length();i++)
		{
			System.out.println(s2.charAt(i));
		}
		
		//Famous interview question
		//How to print in reverse order?
		//Start from the back
		for(int i=s2.length()-1;i>=0;i--)
		{
			System.out.println(s2.charAt(i));
		}
		
		
		// How to create methods
		
		//Why method? If you have a set of code that you want to reuse every time
		//!!!We should not create methods inside main block, this is reserved for execution!!!!!!
		//public will allow us to access this method from other classes
		//void means returns nothing, just executing

		//lets call the method:
		//First we need to create the object
		CoreJavaBrushUp1 d = new CoreJavaBrushUp1();
		d.getData();
		String test5 = d.getData2();
		//System.out.print(test5);
		
		
		//Calling an method from another class
		MethodsLib met = new MethodsLib();
		System.out.println(met.getData3());
		
		
		
		
		
	}
	
	public void getData()
	{
		System.out.println("Hello World");
	}
	public String getData2()
	{
		return "Zaragoza";
	}

}
