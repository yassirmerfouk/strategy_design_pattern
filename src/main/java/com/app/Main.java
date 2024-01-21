package com.app;

import com.app.client.SortClient;
import com.app.sort.BubbleSort;
import com.app.sort.MergeSort;
import com.app.sort.QuickSort;
import com.app.sort.StrategySort;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

       SortClient sortClient = new SortClient();
/*        sortClient.setSort(new QuickSort());
        sortClient.sortData();
        sortClient.setSort(new BubbleSort());
        sortClient.sortData();
        sortClient.setSort(new MergeSort());
        sortClient.sortData();*/

        Scanner scanner = new Scanner(System.in);
        Map<String, StrategySort> cache = new HashMap<>();

        while (true){
            try{
                StrategySort sort = null;
                System.out.print("What sort you want to use : ");
                String sortName = scanner.next();
                sortName = "com.app.sort." + sortName;
                if(!cache.containsKey(sortName)){
                    sort = (StrategySort) Class.forName(sortName).getConstructor().newInstance();
                    cache.put(sortName, sort);
                }
                else{
                    sort = cache.get(sortName);
                }
                sortClient.setSort(sort);
                sortClient.sortData();
            }catch (Exception e){
                System.out.println(e.toString());
            }
        }
    }
}
