//import java.util.Arrays;
import java.util.Scanner;

public class Main
{
     public static void main(String []args)
     {
    	 Scanner getData = new Scanner(System.in);
    	 System.out.print("Podaj ilość węzłów: ");
    	 int numberOfNodes = getData.nextInt();
    	 int yValues[] = new int[numberOfNodes];
    	 int xValues[] = new int[numberOfNodes];
    	 double factorValues[] = new double[numberOfNodes];
    	 
    	 System.out.println();
    	 
    	 for(int i=0; i<numberOfNodes; i++)
    	 {
    		 System.out.print("x" + i + " = ");
    		 xValues[i] = getData.nextInt();
    		 System.out.print("y" + i + " = ");
    		 yValues[i] = getData.nextInt();
    	 }
    	 
    	 //System.out.println("\n" + Arrays.toString(xValues));
    	 //System.out.println(Arrays.toString(yValues) + "\n");
    	 getData.close();
    	 
    	 Matrix matrix = new Matrix(Matrix.fillMatrixValues(xValues), numberOfNodes);
    	 //matrix.displayMatrix();
    	 int matrixIndicator = Matrix.computeIndicator(matrix);
    	 //System.out.println(matrixIndicator);
    	 
    	 if(matrixIndicator != 0)
    	 {
	    	 for(int i=0; i<numberOfNodes; i++)
	    	 {
	    		 factorValues[i] = (double)Matrix.computeIndicator(Matrix.changedMatrix(new Matrix(matrix), yValues, i))/(double)matrixIndicator;
	    	 }
	    	 
	    	 //System.out.println(Arrays.toString(factorValues));
	    	 displayPolynomial(factorValues, xValues, yValues);
    	 }
    	 else
    	 {
    		 System.out.println("\nNie można utworzyć wielomianu który przechodzi przez punkty: \n");
    		 
    		 for(int i=0; i<xValues.length; i++)
    	    	{
    	    		System.out.print("("+ xValues[i] + ", " + yValues[i] +") ");
    	    	}
    	 }
     }
     
     public static void displayPolynomial(double factorValues[], int xValues[], int yValues[])
     {
    	 boolean isStarted = false;
    	 
    	System.out.print("\nWielomian który przechodzi przez punkty:\n\n");
    	 
    	for(int i=0; i<xValues.length; i++)
    	{
    		System.out.print("("+ xValues[i] + ", " + yValues[i] +") ");
    	}
    	 
    	System.out.print("\n\nto W(x) = ");
    	
    	for(int i=factorValues.length-1; i>=0; i--)
    	{
    		if(!(factorValues[i] == 0.0))
    		{
    			if(i != 0)
    			{
    				 if(isStarted)
    				 {
    					 if(factorValues[i] > 0.0)
    					 {
    						 System.out.print(" + ");
    					 }
    					 else
    					 {
    						 System.out.print(" - ");
    					 }
    				 }
    				 System.out.print(Math.abs(factorValues[i]) + "*x");
    				 
    				 if(i > 1)
    				 {
    					 System.out.print("^" + i);
    				 }
    			}
    			else if(i == factorValues.length-1)
    			{
    				System.out.print(factorValues[i] + "*x");
    				//System.out.print(((factorValues[i] == 1.0)?"":Math.abs(factorValues[i]) + "*") + "x");
    			}
    			else
    			{
    				if(isStarted)
    				{
	    				if(factorValues[i] > 0.0)
						{
	    					System.out.print(" + ");
						}
						else
						{
							System.out.print(" - ");
						}
    				}
    				
    				System.out.print(Math.abs(factorValues[i]));
    				//System.out.print(((factorValues[i] == 1.0)?"":Math.abs(factorValues[i]) + "*") + "x");
    			}
    			
    			isStarted = true;
    		}
    	}
    }
}
