package p;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
public @interface Todo {
	public TaskKind kind();
	public String version();
	public double duration();
	
	enum TaskKind {
		Write,
		Enhance,
		Test,
		Refactor
	}
}
