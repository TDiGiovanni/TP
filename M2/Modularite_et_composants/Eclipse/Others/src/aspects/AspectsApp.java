package aspects;

public class AspectsApp
{
	public static void main(String[] args)
	{
		Point p1 = new Point(),
				p2 = new Point();
		
		p1.setX(10);
		p1.setY(5);
		
		p2.setX(12);
		p2.setY(7);
		
		Line l = new Line();
		l.setP1(p1);
		l.setP2(p2);
	}
}
