package Jva.Sort_test;
import java.util.ArrayList;

public class SelectionSort {
    public static void selectionSort(ArrayList<Integer> list){
        for(int i=0; i< list.size(); i++){
            int menor = i;

            for (int j=1 ; j<list.size(); j++){
                if (list.get(j) < list.get(menor)){
                    menor = j;
                }
                int trade = list.get(i);
                list.set(i, list.get(menor));
                list.set(menor, trade);
            }
        }
    }
}