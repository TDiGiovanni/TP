package aspects;

// Aspect used to track movement on any type of Figure
public aspect TrackMovement
{
	// Will be triggered anytime there is a call on a setter on a Figure
	pointcut move(Figure f):
		target(f)
		&& call (* *.set*(..));
	
	// Prints a message after a Figure has been moved
	after(Figure f): move(f)
	{
		System.out.println("The figure " + f + " has been moved: " + thisJoinPoint);
	}
}
