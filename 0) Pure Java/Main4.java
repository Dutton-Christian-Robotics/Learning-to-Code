public class Main {

	public static void main(String[] args) {

		Human sam = new SnarkyHuman("Samuel", "Klynstra");
		
		sam.sayHello();

		


		//System.out.println("Welcome to Online Java!! Happy Coding :)");
	}
}


class Human {
	String hairColor;
	String height;
	String legalFirstName;
	String nickName;
	String lastName;
	int numberOfTimesTheySpelledTheWordAquatic;
	int hoursPlayingCookieClicker;

	public Human(String fn, String ln) {
		legalFirstName = fn;
		lastName = ln;
	}
	
	void sayHello() {
		System.out.println("Nice to meet you, my name is " + legalFirstName + ".");
	}
}

class SnarkyHuman extends Human {
	public SnarkyHuman(String fn, String ln) {
		super(fn, ln);
	}
	
	void sayHello() {
		System.out.println("My name is " + legalFirstName + ", not that you care.");
	}
}