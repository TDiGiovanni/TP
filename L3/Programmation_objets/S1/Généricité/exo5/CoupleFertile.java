package exo5;

public class CoupleFertile<E> {
	private Male m;
	private Femelle f;
	
	public CoupleFertile(Male m, Femelle f) {
		this.setM(m);
		this.setF(f);
	}

	public Male getM(){
		return this.m;
	}
	
	public void setM(Male m) {
		this.m=m;
	}
	
	public Femelle getF(){
		return this.f;
	}
	
	public void setF(Femelle f) {
		this.f=f;
	}

	public String toString() {
		return "Fertile : "+m+" et "+f;
	}
}
