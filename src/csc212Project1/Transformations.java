//This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
