public class Matrix 
{
    private int degree;
    private int matrix[][];
    private int rows;
    private int cols;
    private boolean isSquare;
    
    public Matrix(int values[], int degree)
    {
        this.degree = degree;
        this.rows = degree;
        this.cols = degree;
        this.isSquare = true;
        this.matrix = fillMatrix(values, degree);
    }
    
    public Matrix(Matrix matrix)
    {
    	this.degree = matrix.getDegree();
    	this.matrix = copyMatrix(matrix.getMatrix(), matrix.getRows(), matrix.getCols());
    	this.rows = matrix.getRows();
    	this.cols = matrix.getCols();
    	this.isSquare = matrix.isSquareMatrix();
    }
    
    public boolean isSquareMatrix() { return this.isSquare; }
    public int getDegree() { return this.degree; }
    public int getValue(int i, int j) { return this.matrix[i][j]; }
    public int[][] getMatrix() { return matrix;}
    public int getRows() { return this.rows; }
    public int getCols() { return this.cols; }
    
    private int [][] copyMatrix(int matrix[][], int rows, int cols)
    {
    	int newMatrix[][] = new int[rows][cols];
    	
    	for(int i=0; i<rows; i++)
    	{
    		for(int j=0; j<cols; j++)
    		{
    			newMatrix[i][j] = matrix[i][j];
    		}
    	}
    	
    	return newMatrix;
    }
    
    public void setValue(int i, int j, int value)
    {
    	this.matrix[i][j] = value;
    }
    
    private int[][] fillMatrix(int values[], int deegre)
    {
        int newMatrix[][] = new int[degree][degree];
        
        for(int i=0; i<degree; i++)
        {
            for(int j=0; j<degree; j++)
            {
                newMatrix[i][j] = values[i*degree+j];
            }
        }
        
        return newMatrix;
    }

    public void displayMatrix()
    {
        for(int i=0; i<this.rows; i++)
        {
            for(int j=0; j<this.cols; j++)
            {
                System.out.print(this.matrix[i][j] + " ");
            }
            
            System.out.println();
        }
        
        System.out.println();
    }
    
    public static boolean isSquareMatrix(Matrix matrix) 
    { 
    	return matrix.isSquareMatrix(); 
    }
    
    public static int computeIndicator(Matrix matrix)
    {
    	if(matrix.isSquareMatrix())
    	{
	        if(matrix.getDegree() == 1)
	        {
	            return matrix.getValue(0, 0);
	        }
	        
	        int result=0;
	        
	        for(int i=0; i<matrix.getDegree(); i++)
	        {
	            int arrayValues[] = getMatrixValues(matrix, i);
	            result += matrix.getValue(i, 0)*(int)Math.pow((double)-1, i)*Matrix.computeIndicator(new Matrix(arrayValues, matrix.getDegree()-1));   
	        }
	        
	        return result;
    	}
    	else
    	{
    		return -1;
    	}
    }
    
    private static int[] getMatrixValues(Matrix matrix, int elem)
    {
        int degreeNewMatrix = (int)Math.pow((double)(matrix.getDegree()-1), 2);
        int arrayValues[] = new int[degreeNewMatrix];
        int count = 0;
        
        for(int i=0; i<matrix.getDegree(); i++)
        {
            for(int j=1; j<matrix.getDegree(); j++)
            {
                if(i != elem)
                {
                    arrayValues[count] = matrix.getValue(i, j);
                    ++count;
                }
            }
        }
        
        return arrayValues;
    }
    
    public static Matrix changedMatrix(Matrix matrix, int yValues[], int col)
    {	  
	   	 for(int i=0; i<yValues.length; i++)
	   	 {
	   		 matrix.setValue(i, col, yValues[i]);
	   	 }
	   	 
	   	 //matrix.displayMatrix();
	   	 
	   	 return matrix;
    }
    
    public static int[] fillMatrixValues(int xValues[])
    {
	   	 int numberOfMatrixFields = (int)Math.pow((double) xValues.length, 2.0);
	   	 int matrixValues[] = new int[numberOfMatrixFields];
	   	 
	   	 for(int i=0; i<xValues.length; i++)
	   	 {
	   		 for(int j=0; j<xValues.length; j++)
	   		 {
	   			 matrixValues[i*xValues.length+j] = (int)Math.pow((double)xValues[i], (double)j);
	   		 }
	   	 }
   	 
   	 	return matrixValues;
    }
}
