class Examples(val name: String) {
	fun greet() {
		println("Hello, ${name}");
	}
}

fun main(args: Array<String>) {

	//Mutability
	var variable = 5
	variable = 6 //You can change value

	val immutable = 6
	//immutable = 7//Val cannot be reassigned

	//List<Integer> integers = new ArrayList<Integer>();
	var string: String = "abc"
	//string = null //Compilation Error

	var nullableString: String? = "abc"
	nullableString = null

	//print(nullableString.length)//Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?

	if (nullableString != null) {
		print(nullableString.length)
	}

	println(nullableString?.length)

	var char = 'c'

	//if(char==1) print (char);//Operator '==' cannot be applied to 'Char' and 'Int'

	//Arrays
	val intArray = intArrayOf(1, 2, 10)
	println(intArray[0])//1
	println(intArray.get(0))//1
	println(intArray.all { it > 5 }) //false
	println(intArray.any { it > 5 }) //true
	println(intArray.asList())//[1, 2, 10]
	println(intArray.max())//10
	println(intArray.min())//1

	//Type Inference
	var intVariable = 10
	//intVariable = "String" //Type mismatch: inferred type is String but Int was expected

	//String Templates
	var exampleStringVariable = "SomeString"

	//SomeString has 10 characters
	println("$exampleStringVariable has ${exampleStringVariable.length} characters")

	//Functions

	println(helloBasic("foo")) // => Hello, foo!

	// Named Parameters
	println(helloBasic(name = "bar"))

	//println(helloBasic()) //Compiler Error

	println(helloWithDefaultValue())//Hello, World

	//Data Class
	data class Address(val line1: String,
					   val line2: String,
					   val zipCode: Int,
					   val state: String,
					   val country: String)

	val myAddress = Address("234, Some Apartments", "River Valley Street", 54123, "NJ", "USA")

	println(myAddress)//Address(line1=234, Some Apartments, line2=River Valley Street, zipCode=54123, state=NJ, country=USA)

	val myFriendsAddress = myAddress.copy(line1 = "245, Some Apartments")

	println(myFriendsAddress)//Address(line1=245, Some Apartments, line2=River Valley Street, zipCode=54123, state=NJ, country=USA)


	//Destructure
	val (line1, line2, zipCode, state, country) = myAddress;

	println("$line1 $line2 $zipCode $state $country"); //234, Some Apartments River Valley Street 54123 NJ USA

	//Collections

	val countries = listOf("India", "China", "USA")
	println(countries.size)//3
	println(countries.first())//India
	println(countries.last())//USA
	println(countries[2])//USA
	//countries.add("China") //Not allowed

	val mutableContries = mutableListOf("India", "China", "USA")
	mutableContries.add("China")

	val characterOccurances = mapOf("a" to 1, "h" to 1, "p" to 2, "y" to 1)//happy
	println(characterOccurances)//{a=1, h=1, p=2, y=1}
	println(characterOccurances["p"])//2

	//Destructuring a Map
	for ((key, value) in characterOccurances) {
		println("$key -> $value")
	}

}

/*
Functions can be declared using the "fun" keyword.
Function arguments are specified in brackets after the function name.
Function arguments can optionally have a default value.
The function return type, if required, is specified after the arguments.
*/
fun helloBasic(name: String): String {
	return "Hello, $name!"
}

fun helloWithDefaultValue(name: String = "World"): String {
	return "Hello, $name!"
}

fun helloWithOneExpression(name: String = "world") = "Hello, $name!"

fun printHello(name: String = "world") = println("Hello, $name!")
