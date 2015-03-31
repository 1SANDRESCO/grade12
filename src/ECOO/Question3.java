package ECOO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question3 {
//QUESTIOn 3
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("DATA32.txt"));

		for (int i = 0; i < 10; i++) {


			//inputs
			double xMain = input.nextDouble();
			double xPow = input.nextDouble();
			double yMain = input.nextDouble();
			double yPow = input.nextDouble();
			double sMain = input.nextDouble();
			double sPow = input.nextDouble();
			double round = input.nextDouble();

			/*double orx = ((int)((xMain*(Math.pow(10, xPow)))*Math.pow(10, round) +.5))/Math.pow(10, round);
			double ory = ((int)((yMain*(Math.pow(10, yPow)))*Math.pow(10, round) +.5))/Math.pow(10, round);
			double sl = ((int)((sMain*(Math.pow(10, sPow)))*Math.pow(10, round) +.5))/Math.pow(10, round);
*/
			
			double orx = xMain * Math.pow(10, xPow);
			double ory = yMain * Math.pow(10, yPow);
			double sl = sMain * Math.pow(10, sPow);

			double[][]pins = new double [10][2];
			pins [0][0] = orx;
			pins[0][1] = ory;
			pins[1][1] = ory + sl/3.0;
			pins[2][1] = ory + sl/3.0;
			pins[3][1] = ory + 2*sl/3.0;
			pins[4][1] = ory + 2*sl/3.0;
			pins[5][1] = ory + 2*sl/3.0;
			pins[6][1] = ory + sl;
			pins[7][1] = ory + sl;
			pins[8][1] = ory + sl;
			pins[9][1] = ory + sl;

			//x
			pins[1][0] = orx - sl/6.0;
			pins[2][0] = orx + sl/6.0;
			pins[3][0] = orx - sl/3.0;
			pins[4][0] = orx;
			pins[5][0] = orx + sl/3.0;
			pins[6][0] = orx - sl/2.0;
			pins[7][0] = orx - sl/6.0;
			pins[8][0] = orx + sl/6.0;
			pins[9][0] = orx + sl/2.0;

			for (int j = 0; j < 5; j++) {

				double[] distance = new double[10];

				double txMain = input.nextDouble();
				double txPow = input.nextDouble();
				double tyMain = input.nextDouble();
				double tyPow = input.nextDouble();
				
				//double x = ((int)((txMain*(Math.pow(10, txPow)))*Math.pow(10, round) +.5))/Math.pow(10, round);
				//double y = ((int)((tyMain*(Math.pow(10, tyPow)))*Math.pow(10, round) +.5))/Math.pow(10, round);
				
				double x = txMain*Math.pow(10, txPow);
				double y = tyMain*Math.pow(10, tyPow);
				
				for (int z = 0; z < distance.length; z++) {
					distance[z] = Math.sqrt(Math.pow((pins[z][0] - x), 2) + Math.pow((pins[z][1]-y), 2));
				}

				double small = 0;
				int pos = 0;
				for (int i1 = 0; i1 < distance.length; i1++) {
					if (i1 == 0) {
						small = distance[i1];
						pos = i1;
					} else {
						if(distance[i1] < small) {
							small = distance[i1];
							pos = i1;
						}
					}
				}

				System.out.print(pos+1 + " ");

			}
			System.out.println();
		}
	}

}
