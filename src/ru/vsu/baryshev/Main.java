package ru.vsu.baryshev;

import java.util.Comparator;

public class Main {


    public static <T> T[] selectionSort(T[] data,boolean[] bArr,Comparator<T> c){
        for (int i = 0; i < data.length; i++) {

            if (bArr[i]) {

                T min = data[i];
                int min_i = i;

                for (int j = i + 1; j < data.length; j++) {

                    if (c.compare(data[j], min) < 0 && bArr[j]) {
                        min = data[j];
                        min_i = j;
                    }
                }

                if (i != min_i) {
                    T tmp = data[i];
                    data[i] = data[min_i];
                    data[min_i] = tmp;
                }
            }

        }
        return data;
    }

    public static <T extends Comparable<T>> void sort(T[] data,boolean[] bArr) {

        class TempComparator implements Comparator<T> {
            @Override
            public int compare(T a, T b) {
                return a.compareTo(b);
            }
        }

        selectionSort(data,bArr, new TempComparator());
    }


    public static void main(String[] args) {

        Integer[] array = {7, 10, 3, 8, 7, 2, 1, 9, 5, 7 };
        boolean[] booleans ={true,false,true,true,false,false,true,true,false,true};

        sort(array,booleans);

        System.out.println();
        for (int i=0;i< array.length;i++){
            System.out.print(array[i]+" ");
        }

    }
}

//{ 7, 10, 3, 8, 7, 2, 1, 9, 5, 7 } –> { 1, 10, 3, 7, 7, 2, 7, 8, 5, 9 }