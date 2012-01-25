package csc212Project1;

public class Transformations {

	// State variables
	MatrixMath math = new MatrixMath();
	
	public Transformations() {
	}
	
	public Point translate(Point p, Point t)
	{
		printHeader(p);
		this.math.translate(p, t);
		printFooter(p);
		return p;
	}

	public Point scale(Point p, Point s)
	{
		printHeader(p);
		this.math.scale(p, s);
		printFooter(p);
		return p;
	}

	public Point rotx(Point p, double r)
	{
		r = degreeToRadian(r);
		printHeader(p);
		this.math.rotx(p, r);
		printFooter(p);
		return p;
	}

	public Point roty(Point p, double r)
	{
		r = degreeToRadian(r);
		printHeader(p);
		this.math.roty(p, r);
		printFooter(p);
		return p;
	}

	public Point rotz(Point p, double r)
	{
		r = degreeToRadian(r);
		printHeader(p);
		this.math.rotz(p, r);
		printFooter(p);
		return p;
	}

	private void printHeader(Point p)
	{
		System.out.print("Input point: ");
		System.out.print(p);
		System.out.println("Transformation matrix: ");
	}

	private void printFooter(Point p)
	{
		System.out.print(this.math);	// Print the last used work matrix
		System.out.print("Resultant point: ");
		System.out.print(p);
	}

	private double degreeToRadian(double r)
	{
		return r * Math.PI / 180.0;
	}
}
