package exo5;

public class CoupleEspece<E> {
	private E p1;
	private E p2;
	
	public CoupleEspece(E p1, E p2) {
		this.setP1(p1);
		this.setP2(p2);
	}
	
	public E getP1(){
		return this.p1;
	}
	
	public void setP1(E p1) {
		this.p1=p1;
	}
	
	public E getP2(){
		return this.p2;
	}
	
	public void setP2(E p2) {
		this.p2=p2;
	}
	
	public String toString() {
		return "Espece : "+p1+" et "+p2;
	}
}
