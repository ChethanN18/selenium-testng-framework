package com.framework.dataproviders;

import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.framework.utils.ExcelUtils;

public class DataProviders {

    @DataProvider(name = "loginData", parallel = true)
    public static Object[][] loginData() {

        List<Map<String, String>> data =
                ExcelUtils.getTestData("LoginTest");

        Object[][] result = new Object[data.size()][1];

        for (int i = 0; i < data.size(); i++) {
            result[i][0] = data.get(i);
        }

        return result;
    }

}
