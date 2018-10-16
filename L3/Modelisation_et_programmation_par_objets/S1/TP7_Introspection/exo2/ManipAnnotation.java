package exo2;

import java.lang.reflect.Method;

@SuppressWarnings("rawtypes")
public class ManipAnnotation {
	public static void afficheTodo(Class[] classes) {
		System.out.println("Les classes possédant l'annotation Todo sont :");
		for (Class c: classes) {
			Method[] methodes= c.getMethods();
			for (Method m: methodes){
				if (m.isAnnotationPresent(Todo.class))
					System.out.println(c.getName()+" sur la méthode "+m.getName());
		}}
	}
	
	public static void afficheTodoKind(Class[] classes,TaskKind t) {
		System.out.println("Les classes possédant l'annotation Todo avec la tâche "+t+" sont :");
		for (Class c: classes) {
			Method[] methodes= c.getMethods();
			for (Method m: methodes)
				if (m.isAnnotationPresent(Todo.class)) {
					Todo a = m.getAnnotation(Todo.class);
					if (a.kind().equals(t))
						System.out.println(c.getName()+" sur la méthode "+m.getName());
				}
		}
	}
	
	public static void afficheTodoDuree(Class[] classes, String version) {
		double d=0;
		System.out.println("La durée cumulée des tâches à réaliser de version "+version+" est :");
		for (Class c: classes) {
			Method[] methodes= c.getMethods();
			for (Method m: methodes)
				if (m.isAnnotationPresent(Todo.class)) {
					Todo a = m.getAnnotation(Todo.class);
					if (a.version()==version) {
						d+=a.duration();
					}
				}
		}
		System.out.println(d);
	}
}
