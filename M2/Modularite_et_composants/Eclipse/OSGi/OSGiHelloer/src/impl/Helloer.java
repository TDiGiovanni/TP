package impl;

import export.IHelloer;

public class Helloer implements IHelloer
{
	@Override
	public void sayHello()
	{
		System.out.println("Hello World!");
	}

	@Override
	public void sayGoodbye()
	{
		System.out.println("Goodbye World!");
	}
}
