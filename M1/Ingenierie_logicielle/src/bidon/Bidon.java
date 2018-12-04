package bidon;

public class Bidon {
	
	private int volumeMax;
	private int volume;
	
	
	public Bidon(int vmax){
		this.volumeMax = vmax;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int mVol) {
		this.volume = mVol;
	}
	
	public int getVolumeMax() {
		return volumeMax;
	}

	
	public void vider(){
		setVolume(0);
	}
	
	public void remplir(){
		setVolume(volumeMax);
	}
	
	public int transvaser(Bidon dest){
		int vdeplace;
		int sum = this.getVolume()+dest.getVolume();
		
		if( sum > dest.getVolumeMax()){
			
			vdeplace = dest.getVolumeMax() - dest.getVolume();
			
			dest.setVolume(dest.getVolumeMax());
			this.setVolume(this.getVolume() - vdeplace);
			
		}else{
			
			vdeplace = this.getVolume();
			dest.setVolume(sum);
			this.vider();
		}
		
		return vdeplace;
	}
}
