import java.util.Arrays;



public class SortingNumbers {


    public static int[] int1 = new int []{1, 1, 2, 1, 3, 4, 5};
    
    public static void main(String[] args)
    {
         
        System.out.println("Test");

        Arrays.sort(int1);

        int[] output = new int[int1.length];

        output[0] = int1[0];

        int previousNum = int1[0];

        for(int i=1; i < int1.length;i++)
        {

            if(previousNum != int1[i])
            {
                output[i] = int1[i];
            }

            previousNum = int1[i];
        }

        System.out.println("After removing duplicates   : " + Arrays.toString(output));

    }


}
