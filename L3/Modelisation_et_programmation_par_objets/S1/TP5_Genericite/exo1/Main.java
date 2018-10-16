package exo1;

public class Main {

	public static void main(String[] args) {
		Pile<String> p1= new Pile<String>();
		Pile<Integer> p2= new Pile<Integer>();
		Pile<Object> p3= new Pile<Object>();
		
		p1.empile("oui");
		p1.empile("non");
		p1.depile();
		System.out.println(p1.toString());
		
		p2.empile(1);
		p2.empile(2);
		p2.depile();
		p2.empile(3);
		System.out.println(p2.toString());
		
		p3.empile(p1);
		p3.empile(p2);
		System.out.println(p3.toString());
	}
}
