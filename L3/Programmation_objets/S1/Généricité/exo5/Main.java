package exo5;

public class Main {
	public static void main(String[] args) {
		Vache v= new Vache();
		Taureau t= new Taureau();
		Dauphin d1= new Dauphin();
		Dauphine d2= new Dauphine();
		
		CoupleConventionnel cc1= new CoupleConventionnel(t,v);
		System.out.println(cc1.toString());
		CoupleConventionnel cc2= new CoupleConventionnel(d1,d2);
		System.out.println(cc2.toString());
		CoupleConventionnel cc3= new CoupleConventionnel(d1,v);
		System.out.println(cc3.toString());
		CoupleConventionnel cc4= new CoupleConventionnel(t,d2);
		System.out.println(cc4.toString());
		
		CoupleEspece<Bovin> ce1= new CoupleEspece<Bovin>(t,v);
		System.out.println(ce1.toString());
		CoupleEspece<Cetace> ce2= new CoupleEspece<Cetace>(d1,d2);
		System.out.println(ce2.toString());
		CoupleEspece<Bovin> ce3= new CoupleEspece<Bovin>(t,t);
		System.out.println(ce3.toString());
		CoupleEspece<Cetace> ce4= new CoupleEspece<Cetace>(d2,d2);
		System.out.println(ce4.toString());
		
		CoupleFertile<Bovin> cf1= new CoupleFertile<Bovin>(t,v);
		System.out.println(cf1.toString());
		CoupleFertile<Cetace> cf2= new CoupleFertile<Cetace>(d1,d2);
		System.out.println(cf2.toString());
	}
}
