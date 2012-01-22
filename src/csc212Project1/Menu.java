package csc212Project1;

import java.util.Scanner;
import java.util.StringTokenizer;

//import java.util.*;

public class Menu {

	public static MatrixMath math = new MatrixMath();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Point p = new Point();
		Point x = new Point();
		double[] t = new double[3];
		Scanner scan = new Scanner(System.in);
		String str = "";
		StringTokenizer stok = new StringTokenizer(str,",");
		int m, a;
		p.userSet();
		p.print();
		a = 1;
		while(a == 1)
		{
			m = doMenu();
			switch(m)
			{
				case 1:
					System.out.print("Enter +/- translation units x,y,z: ");
					str = scan.nextLine();
					stok = new StringTokenizer(str,",");
					t[0] = Double.parseDouble(stok.nextToken());
					t[1] = Double.parseDouble(stok.nextToken());
					t[2] = Double.parseDouble(stok.nextToken());
					x.set(t);	// Use this point to hold onto translation values
					translate(p, x);
				break;
				case 2:
					System.out.print("Enter +/- scale units x,y,z: ");
					str = scan.nextLine();
					stok = new StringTokenizer(str,",");
					t[0] = Double.parseDouble(stok.nextToken());
					t[1] = Double.parseDouble(stok.nextToken());
					t[2] = Double.parseDouble(stok.nextToken());
					x.set(t);	// Use this point to hold onto translation values
					scale(p, x);
				break;
				case 3:
					System.out.print("Enter +/- degrees about x axis: ");
					str = scan.nextLine();
					t[0] = Double.parseDouble(str);
					rotx(p, t[0]);
				break;
				case 4:
					System.out.print("Enter +/- degrees about y axis: ");
					str = scan.nextLine();
					t[0] = Double.parseDouble(str);
					roty(p, t[0]);
				break;
				case 5:
					System.out.print("Enter +/- degrees about z axis: ");
					str = scan.nextLine();
					t[0] = Double.parseDouble(str);
					rotz(p, t[0]);
				break;
				case 6:
					a = 0;	// All done
				break;
			}
		}
	}

	public static int doMenu()
	{
		System.out.println("--------------------------------");
		System.out.println("Welcome to Transformation System");
		System.out.println("--------------------------------");
		System.out.println("Please choose a transformation");
		System.out.println("1) Translate");
		System.out.println("2) Scale");
		System.out.println("3) Rotate around X");
		System.out.println("4) Rotate around Y");
		System.out.println("5) Rotate around Z");
		System.out.println("6) Done");
		System.out.println("Enter selection: ");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		int m = Integer.parseInt(str);
		return m;
	}

	public static void translate(Point p, Point t)
	{
		printHeader(p);
		math.translate(p, t);
		printFooter(p);
	}

	public static void scale(Point p, Point s)
	{
		printHeader(p);
		math.scale(p, s);
		printFooter(p);
	}

	public static void rotx(Point p, double r)
	{
		r = degreeToRadian(r);
		printHeader(p);
		math.rotx(p, r);
		printFooter(p);
	}

	public static void roty(Point p, double r)
	{
		r = degreeToRadian(r);
		printHeader(p);
		math.roty(p, r);
		printFooter(p);
	}

	public static void rotz(Point p, double r)
	{
		r = degreeToRadian(r);
		printHeader(p);
		math.rotz(p, r);
		printFooter(p);
	}

	public static void printHeader(Point p)
	{
		System.out.print("Input point: ");
		p.print();
		System.out.println("Transformation matrix: ");
	}

	public static void printFooter(Point p)
	{
		math.print();	// Print the last used work matrix
		System.out.print("Resultant point: ");
		p.print();
	}

	public static double degreeToRadian(double r)
	{
		return r * Math.PI / 180.0;
	}
}
