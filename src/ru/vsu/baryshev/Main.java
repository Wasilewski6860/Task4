package ru.vsu.baryshev;

import java.util.Comparator;

public class Main {


    public static <T> T[] selectionSort(T[] data,boolean[] bArr,Comparator<T> c){
    /*По очереди будем просматривать все подмножества
      элементов массива (0 - последний, 1-последний,
      2-последний,...)*/
        for (int i = 0; i < data.length; i++) {

            if (bArr[i]) {
        /*Предполагаем, что первый элемент (в каждом
           подмножестве элементов) является минимальным */
                T min = data[i];
                int min_i = i;
        /*В оставшейся части подмножества ищем элемент,
           который меньше предположенного минимума*/
                for (int j = i + 1; j < data.length; j++) {
                    //Если находим, запоминаем его индекс
                    if (c.compare(data[j], min) < 0 && bArr[j]) {
                        min = data[j];
                        min_i = j;
                    }
                }
        /*Если нашелся элемент, меньший, чем на текущей позиции,
          меняем их местами*/
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
        selectionSort(data,bArr, Comparable::compareTo);
    }


    public static void main(String[] args) {

        int[] array = {7, 10, 3, 8, 7, 2, 1, 9, 5, 7 };
        boolean[] booleans ={true,false,true,true,false,false,true,true,false,true};
        array=sort(array,booleans);
        System.out.println();
        for (int i=0;i< array.length;i++){
            System.out.print(array[i]+" ");
        }

    }
}

//{ 7, 10, 3, 8, 7, 2, 1, 9, 5, 7 } –> { 1, 10, 3, 7, 7, 2, 7, 8, 5, 9 }