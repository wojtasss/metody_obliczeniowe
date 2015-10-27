public class Matrix 
{
    private int degree;
    private int matrix[][];
    
    public Matrix(int values[], int degree)
    {
        this.degree = degree;
        this.matrix = fillMatrix(values, degree);
    }
    
    public int getDegree(){ return this.degree; }
    public int getValue(int i, int j) { return this.matrix[i][j]; }
    
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
        for(int i=0; i<this.degree; i++)
        {
            for(int j=0; j<this.degree; j++)
            {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static Matrix createMatrix(int values[], int degree)
    {
        if((int)Math.pow((double)degree, 2.0) == values.length)
        {
            Matrix newMatrix = new Matrix(values, degree);
            System.out.println("Utworzono macierz!");
            newMatrix.displayMatrix();
            return newMatrix;
        }
        else
        {
            return null;
        }
    }
    
    public static int computeIndicator(Matrix matrix)
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
}
