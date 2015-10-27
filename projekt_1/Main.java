public class Main
{
     public static void main(String []args)
     {
        int values[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Matrix matrix = Matrix.createMatrix(values, (int)Math.sqrt((double)values.length));
        
        if(!(matrix == null))
        {
            System.out.println(Matrix.computeIndicator(matrix));
        }
     }
}
