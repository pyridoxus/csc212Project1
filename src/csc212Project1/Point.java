package csc212Project1;

import java.util.*;

public class Point {
	// State variables
	private double[] p;
	
	public Point() {
		p = new double[4];
		for(int a = 0; a < 3; a++) {
			this.p[a] = 0.0;
		}
		this.p[3] = 1.0;	// homogeneous
	}

	public void userSet() {
		System.out.print("Enter initial point in the form x,y,z: ");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		StringTokenizer stok = new StringTokenizer(str,",");
		this.p[0] = Double.parseDouble(stok.nextToken());
		this.p[1] = Double.parseDouble(stok.nextToken());
		this.p[2] = Double.parseDouble(stok.nextToken());
	}

	@Override
	public String toString() {
		String str = "(" + this.p[0] + ", ";
		str = str + this.p[1] + ", ";
		str = str + this.p[2] + ")\n";
		return str;
	}
	
	public void set(double x, double y, double z) {
		this.p[0] = x;
		this.p[1] = y;
		this.p[2] = z;
		this.p[3] = 1.0;	// homogeneous
	}
	
	public void set(double q[]) {
		this.p = q;
	}
	
	public double[] get() {
		double[] rp = new double[4];
		rp[0] = this.p[0];
		rp[1] = this.p[1];
		rp[2] = this.p[2];
		rp[3] = 1.0;		// homogeneous
		return rp;
	}
}
