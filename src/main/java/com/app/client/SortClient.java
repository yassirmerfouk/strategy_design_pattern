package com.app.client;

import com.app.sort.DefaultSort;
import com.app.sort.StrategySort;

public class SortClient {

    private StrategySort sort = new DefaultSort();

    public void setSort(StrategySort sort) {
        this.sort = sort;
    }

    public void sortData(){
        System.out.println("************************");
        System.out.println("Prepare data for sorting");
        System.out.println("************************");
        sort.sort();
        System.out.println("************************");
        System.out.println("Display sorted data");
        System.out.println("************************");
    }
}
