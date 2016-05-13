package com.indusmed.utils;

import java.io.IOException;
import java.util.List;

import com.indusmed.base.Hospitals;

public class SampleExcelTest {

    public void readFile(){
        ExcelUtil excelReader = new ExcelUtil();
        try {
            String filePath = this.getClass().getClassLoader().getResource("providers.xlsx").toString();
            List<Hospitals> hospitals = excelReader.readBooksFromExcelFile(filePath.substring(6));

            for (Hospitals hospital : hospitals) {
                System.out.println("ECLAIM: " + hospital.getEclaimId() + "  NAME: " + hospital.getHospitalName());
            }
        } catch (IOException e) {
            System.out.println("exception occured with cause : " + e.getMessage());
        }
    }
}
