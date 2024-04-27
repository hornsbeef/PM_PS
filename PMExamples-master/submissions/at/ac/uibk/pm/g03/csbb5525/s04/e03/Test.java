package at.ac.uibk.pm.g03.csbb5525.s04.e03;

public class Test {
	public static void main(String[] args) {
		separateOutput(1);

		B object1 = new C();
		object1.print(new A());
		((C) object1).print(new B());

		separateOutput(2);

		A object2 = new B();
		((B) object2).print(new A());
		object2.print(new C());	//todo

		separateOutput(3);

		A object3 = new C();
		object3.print(new C());
		object3.print(new A());
		object3.print(new B());
		((C) object3).print(new B());
		((C) object3).print(new C());

		separateOutput(4);

		C object4 = new C();
		object4.print(new C());
		object4.print(new A());
		object4.print(new B());

		separateOutput(5);

		B object5 = new B();
		object5.print(new C());
		object5.print(new B());
		object5.print(new A());

		separateOutput(6);

		Object object6 = new C();
		((C) object6).print(new B());
		((A) object6).print(new A());
		((B) object6).print(new B());

		separateOutput(7);

		Object object7 = new A();
		((A) object7).print(new C());

		separateOutput(8);

		Object object8 = new B();
		((B) object8).print(new A());
		((A) object8).print(new A());
	}

	private static void separateOutput(int part) {
		System.out.println("\n--- " + part + " ---\n");
	}
}
