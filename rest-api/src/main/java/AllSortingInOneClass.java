import java.util.Arrays;


public class AllSortingInOneClass {


    public static void bubblesort(int[] array)
    {
        int[] output = new int[array.length];

        for(int j=0; j < array.length-1;j++)
        {


            for(int i=0; i < array.length-j-1;i++)
            {

                if(array[i] >  array[i+1])
                {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                
                }
            }

        }
        System.out.println("After sorting    : " + Arrays.toString(array));
    }



    public static void selectionsort(int[] array)
    {
        int[] output = new int[array.length];

        for(int i=0; i < array.length-1;i++)
        {
            int min = i;

            for(int j=i+1; j < array.length;j++)
            {
                if(array[j] < array[min])
                {
                    min = j;
                }
            }

            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

        System.out.println("After sorting    : " + Arrays.toString(array));
    }


    public static void mergesort(int[] array)
    {
        int[] output = new int[array.length];

        if(array.length == 1)
        {
            return;
        }

        int mid = array.length/2;

        int[] left = new int[mid];
        int[] right = new int[array.length-mid];

        for(int i=0; i < mid;i++)
        {
            left[i] = array[i];
        }

        for(int i=mid; i < array.length;i++)
        {
            right[i-mid] = array[i];
        }

        mergesort(left);
        mergesort(right);

        int i=0;
        int j=0;
        int k=0;

        while(i < left.length && j < right.length)
        {
            if(left[i] < right[j])
            {
                output[k] = left[i];
                i++;
            }
            else
            {
                output[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < left.length)
        {
            output[k] = left[i];
            i++;
            k++;
        }

        while(j < right.length)
        {
            output[k] = right[j];
            j++;
            k++;
        }

        System.out.println("After sorting    : " + Arrays.toString(output));
    }




    public static void sortit()
    {
        int[] array = {5,4,3,2,1};
        System.out.println("Before sorting    : " + Arrays.toString(array));
        bubblesort(array);
        selectionsort(array);
        mergesort(array);        
    }

    public static void main(String[] args) {

        int[] array = new int[]{5454,222,10,12,343,23,545,5753,232,457,676};

        mergesort(array);


       

    }
    
}
