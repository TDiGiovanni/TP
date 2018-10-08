package exo2;

import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Todo {
	public TaskKind kind();
	public String version();
	public double duration();
}
