class Greeter(val name : String) { 
  fun greet() { 
    println("Hello, ${name}"); 
  } 
} 
 
fun main(args : Array<String>) { 
  Greeter("John Doe").greet() 
}