import java.util.*;
import entities.Person;
import java.time.LocalDate;


public class Hello {
	
	public static void main0(String[] args) {
		// int i = 3;
		Scanner input = new Scanner(System.in);
		System.out.print("Qual o seu nome? ");
		String name = input.next();
		System.out.print("Qual a sua idade? ");
		int age = input.nextInt();
		System.out.println("Hello " + name + " with " + 
		                   age + " years, welcome to java world!");
		
		System.out.printf("Hello %s with %d, welcome to java world!\n",
							name, age);
	}
	
	public static void main(String[] args) {
		LocalDate bd = LocalDate.of(2010, 8, 12);
		Person p = new Person("Carlos", 123456, bd );
		 
		
		p.show();
	}
	
}