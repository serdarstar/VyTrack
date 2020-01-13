package com.cybertek.tests;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilTest {
    @Test
    public void readExcelFile(){
        //to reach the methods in ExcelUtil, we have to create an object first
        ExcelUtil qashort=new ExcelUtil("src/test/resources/Vytracktestdata.xlsx", "QA3-short");
        System.out.println("qashort.getColumnsNames() = " + qashort.getColumnsNames());

        //to print each on eor all of them, we use MapList
        List<Map<String, String>> dataList = qashort.getDataList();
        System.out.println(dataList.get(0).get("firstname"));
        for (Map<String, String> stringStringMap : dataList) {
            System.out.println(stringStringMap);
        }
        //or alternatively, we could use 2d Arrays
        String [][] dataArray=qashort.getDataArray();
        System.out.println(Arrays.deepToString(dataArray));


    }

}
