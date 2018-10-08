package exo5;

public class Paire<A,B> {
	private A fst;
	private B snd;
	
	public Paire() {}
	
	public Paire(A f, B s){
		this.fst=f;
		this.snd=s;
	}
	
	public A getFst(){
		return fst;
	}
	
	public void setFst(A a){
		fst=a;
	}
	
	public B getSnd(){
		return snd;
	}
	
	public void setSnd(B b){
		snd=b;
	}
	
	public String toString(){
		return getFst()+"-"+getSnd();
	}
}
