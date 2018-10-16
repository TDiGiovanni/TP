package designPattern;

public class File extends SimpleElement {
	protected String content; // Contenu du fichier
	
	// Constructeurs
	public File(Container fatherContainer) {
		this.name = "New file";
		this.fatherContainer = fatherContainer;
		this.basicSize = 4;
		this.content = "";
	}
	
	public File(String name, Container fatherContainer) {
		this.name = name;
		this.fatherContainer = fatherContainer;
		this.basicSize = 4;
		this.content = "";
	}
	
	public File(Container fatherContainer, String content) {
		this.name = "New file";
		this.fatherContainer = fatherContainer;
		this.basicSize = 4;
		this.content = content;
	}
	
	public File(String name, Container fatherContainer, String content) {
		this.name = name;
		this.fatherContainer = fatherContainer;
		this.basicSize = 4;
		this.content = content;
	}
	
	@Override
	public int size() {
		return content.length() + basicSize;
	}

	@Override
	public void print() {
		System.out.println(content);
	}
}
