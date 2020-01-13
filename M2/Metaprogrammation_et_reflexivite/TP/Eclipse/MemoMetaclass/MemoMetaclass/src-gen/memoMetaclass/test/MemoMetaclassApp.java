package memoMetaclass.test;

import memoMetaclass.Automobile;
import memoMetaclass.AutomobileType;
import memoMetaclass.MemoMetaclassFactory;
import memoMetaclass.Person;
import memoMetaclass.World;

public class MemoMetaclassApp
{
	public static void main(String[] args)
	{
		World world = MemoMetaclassFactory.eINSTANCE.createWorld();
		
		Automobile mercedesClassC = MemoMetaclassFactory.eINSTANCE.createAutomobile();
		mercedesClassC.setName("Class C");
		mercedesClassC.setType(AutomobileType.MERCEDES);
		world.getAutomobiles().add(mercedesClassC);
		
		Person paul = MemoMetaclassFactory.eINSTANCE.createPerson();
		paul.setName("Paul");
		paul.setAge(45);
		paul.getAutomobiles().add(mercedesClassC);
		world.getPopulation().add(paul);
		
		System.out.println("Paul's age: " + paul.getAge());
		paul.birthday();
		System.out.println("Paul's age: " + paul.getAge());
	}
}
