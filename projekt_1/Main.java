public class Main
{
     public static void main(String []args)
     {
        int values[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int matrixDegree = (int)Math.sqrt((double)values.length);
        Matrix matrix = Matrix.createMatrix(values, matrixDegree);
        
        if(!(matrix == null))
        {
            System.out.println(Matrix.computeIndicator(matrix));
        }
     }
}
