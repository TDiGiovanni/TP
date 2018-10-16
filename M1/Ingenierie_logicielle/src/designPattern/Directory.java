package designPattern;

import java.util.Collection;

public class Directory extends Container {
	// Constructeurs
	public Directory(Container fatherContainer) {
		this.name = "New directory";
		this.fatherContainer = fatherContainer;
		this.basicSize = 4;
		this.content = null;
	}
	
	public Directory(String name, Container fatherContainer) {
		this.name = name;
		this.fatherContainer = fatherContainer;
		this.basicSize = 4;
		this.content = null;
	}
	
	public Directory(String name, Container fatherContainer, Collection<Element> content) {
		this.name = name;
		this.fatherContainer = fatherContainer;
		this.basicSize = 4;
		this.content = content;
	}
}
