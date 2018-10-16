package designPattern;

public class Link extends SimpleElement {
	protected Element linkedElement; // Elément lié
	
	// Constructeurs
	public Link(Container fatherContainer, Element linkedElement) {
		this.name = "New link";
		this.fatherContainer = fatherContainer;
		this.basicSize = 4;
		this.linkedElement = linkedElement;
	}
	
	public Link(String name, Container fatherContainer, Element linkedElement) {
		this.name = name;
		this.fatherContainer = fatherContainer;
		this.basicSize = 4;
		this.linkedElement = linkedElement;
	}

	@Override
	public int size() {
		return basicSize;
	}

	@Override
	public void print() {
		linkedElement.print();
	}
}
