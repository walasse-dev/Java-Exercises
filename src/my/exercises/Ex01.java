package my.exercises;

public class Ex01 {
    public static void main(String[] args) {
       int[] example = {10, 15, 13};

        for (int i = 0; i < logic(example).length; i++) {
            System.out.println(logic(example)[i]);
        }

        System.out.println();

        for (int i = example.length -1; i >= 0; i--) {
            System.out.println(example[i]);
        }
    }

    public static int[] logic(int[] array){
        int[] newArray = new int[3];
        int higher = 0;
        int minor = 0;
        int average;
        int sum = 0;

        for (int i = 0; i < array.length; i++){
            sum += array[i];

            if (array[i] > higher){
               higher = array[i];
            }

            if (array[i] < minor){
               minor = array[i];
            }
        }

       average = sum / array.length;

       newArray[0] = higher;
       newArray[1] = minor;
       newArray[2] = average;

       return newArray;
    }
}
