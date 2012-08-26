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
public class MatrixMath {
	
	// State variables
	private double[][] work = new double[4][4];	// Working matrix

	// Constructor
	public MatrixMath(){
		for(int a = 0; a < 4; a++) {
			for(int b = 0; b < 4; b++){
				work[a][b] = 0;
			}
		}
		work[3][3] = 1.0;
	}
	
	@Override
	public String toString() {
		String str = "";
		for(int a = 0; a < 4; a++) {
			for(int b = 0; b < 4; b++) {
				str = str + this.work[a][b] + " ";
			}
			str = str + "\n";
		}
		return str;
	}
	
	public void translate(Point p, Point t)	// p is translated by t
	{
		this.initWorkTranslate(t);
		this.multiply(p);
	}

	public void scale(Point p, Point s)			// p is scaled by s
	{
		this.initWorkScale(s);
		this.multiply(p);
	}

	public void rotx(Point p, double r)			// p is rotated on x axis by r
	{
		this.initWorkRotx(r);	// r must be in radians
		this.multiply(p);
	}

	public void roty(Point p, double r)			// p is rotated on y axis by r
	{
		this.initWorkRoty(r);	// r must be in radians
		this.multiply(p);
	}

	public void rotz(Point p, double r)			// p is rotated on z axis by r
	{
		this.initWorkRotz(r);	// r must be in radians
		this.multiply(p);
	}

	public void initWorkTranslate(Point t) // init work matrix for translation
	{
		double[] f = new double[3];
		f = t.get();
		this.work[0][0] = 1.0;
		this.work[0][1] = 0.0;
		this.work[0][2] = 0.0;
		this.work[0][3] = f[0];
		this.work[1][0] = 0.0;
		this.work[1][1] = 1.0;
		this.work[1][2] = 0.0;
		this.work[1][3] = f[1];
		this.work[2][0] = 0.0;
		this.work[2][1] = 0.0;
		this.work[2][2] = 1.0;
		this.work[2][3] = f[2];
	}

	public void initWorkScale(Point s)			// init work matrix for scaling
	{
		double[] f = new double[3];
		f = s.get();
		this.work[0][0] = f[0];
		this.work[0][1] = 0.0;
		this.work[0][2] = 0.0;
		this.work[0][3] = 0.0;
		this.work[1][0] = 0.0;
		this.work[1][1] = f[1];
		this.work[1][2] = 0.0;
		this.work[1][3] = 0.0;
		this.work[2][0] = 0.0;
		this.work[2][1] = 0.0;
		this.work[2][2] = f[2];
		this.work[2][3] = 0.0;
	}

	public void initWorkRotx(double r)	// init work matrix for x axis rotation
	{
		this.work[0][0] = 1.0;
		this.work[0][1] = 0.0;
		this.work[0][2] = 0.0;
		this.work[0][3] = 0.0;
		this.work[1][0] = 0.0;
		this.work[1][1] = Math.cos(r);
		this.work[1][2] = -Math.sin(r);
		this.work[1][3] = 0.0;
		this.work[2][0] = 0.0;
		this.work[2][1] = Math.sin(r);
		this.work[2][2] = Math.cos(r);
		this.work[2][3] = 0.0;
	}

	public void initWorkRoty(double r)	// init work matrix for y axis rotation
	{
		this.work[0][0] = Math.cos(r);
		this.work[0][1] = 0.0;
		this.work[0][2] = Math.sin(r);
		this.work[0][3] = 0.0;
		this.work[1][0] = 0.0;
		this.work[1][1] = 1.0;
		this.work[1][2] = 0.0;
		this.work[1][3] = 0.0;
		this.work[2][0] = -Math.sin(r);
		this.work[2][1] = 0.0;
		this.work[2][2] = Math.cos(r);
		this.work[2][3] = 0.0;
	}

	public void initWorkRotz(double r)	// init work matrix for z axis rotation
	{
		this.work[0][0] = Math.cos(r);
		this.work[0][1] = -Math.sin(r);
		this.work[0][2] = 0.0;
		this.work[0][3] = 0.0;
		this.work[1][0] = Math.sin(r);
		this.work[1][1] = Math.cos(r);
		this.work[1][2] = 0.0;
		this.work[1][3] = 0.0;
		this.work[2][0] = 0.0;
		this.work[2][1] = 0.0;
		this.work[2][2] = 1.0;
		this.work[2][3] = 0.0;
	}

	public void multiply(Point p)		// Find product of p and work, put in p
	{
		int row, col;
		double[] f = new double[4];
		double[] g = new double[4];
		f = p.get();
		for(row = 0; row < 4; row++)
		{
			g[row] = 0.0;
			for(col = 0; col < 4; col++)
			{
				g[row] += this.work[row][col] * f[col];
			}
		}
		p.set(g);
	}
}
