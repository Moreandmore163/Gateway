/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.model.util;

import com.creditcloud.model.enums.BaseEnum;
import com.creditcloud.model.enums.loanRequest.LoanRequestMethod;
import com.creditcloud.model.enums.loanRequest.LoanRequestPurpose;
import com.creditcloud.model.enums.loanRequest.LoanRequestStatus;
import com.creditcloud.model.enums.user.CareerStatus;
import com.creditcloud.model.enums.user.CompanyIndustry;
import com.creditcloud.model.enums.user.CompanySize;
import com.creditcloud.model.enums.user.CompanyType;
import com.creditcloud.model.enums.user.EducationLevel;
import com.creditcloud.model.enums.user.MaritalStatus;
import com.creditcloud.model.enums.user.MonthlySalary;
import com.creditcloud.model.enums.user.YearOfService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rooseek
 */
public class EnumsTest {

    public EnumsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCompanyIndustry() {
        String key = "其他";
        CompanyIndustry expResult = CompanyIndustry.OTHER;
        CompanyIndustry result = Enums.getEnumByKey(CompanyIndustry.class, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testCareerStatus() {
        String key = "其他";
        CareerStatus expResult = CareerStatus.OTHER;
        CareerStatus result = Enums.getEnumByKey(CareerStatus.class, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testCompanySize() {
        String key = "10人以下";
        CompanySize expResult = CompanySize.SIZE_BELOW_10;
        CompanySize result = Enums.getEnumByKey(CompanySize.class, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testCompanyType() {
        String key = "其他";
        CompanyType expResult = CompanyType.OTHER;
        CompanyType result = Enums.getEnumByKey(CompanyType.class, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testEducationLevel() {
        String key = "高中及以下";
        EducationLevel expResult = EducationLevel.HIGHSCHOOL;
        EducationLevel result = Enums.getEnumByKey(EducationLevel.class, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testMaritalStatus() {
        String key = "已婚";
        MaritalStatus expResult = MaritalStatus.MARRIED;
        MaritalStatus result = Enums.getEnumByKey(MaritalStatus.class, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testMonthlySalary() {
        String key = "2000以下";
        MonthlySalary expResult = MonthlySalary.SALARY_BELOW_2000;
        MonthlySalary result = Enums.getEnumByKey(MonthlySalary.class, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testYearOfService() {
        String key = "1年以下";
        YearOfService expResult = YearOfService.YEAR_BELOW_1;
        YearOfService result = Enums.getEnumByKey(YearOfService.class, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testLoanRequestStatus() {
        String key = "未处理";
        LoanRequestStatus expResult = LoanRequestStatus.UNASSIGNED;
        LoanRequestStatus result = Enums.getEnumByKey(LoanRequestStatus.class, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testLoanRequestPurpose() {
        String key = "购车借款";
        LoanRequestPurpose expResult = LoanRequestPurpose.CAR;
        LoanRequestPurpose result = Enums.getEnumByKey(LoanRequestPurpose.class, key);
        assertEquals(expResult, result);
    }

    @Test
    public void testLoanRequestMethod() {
        String key = "按月付息到期还本";
        LoanRequestMethod expResult = LoanRequestMethod.MonthlyInterest;
        LoanRequestMethod result = Enums.getEnumByKey(LoanRequestMethod.class, key);
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithStringClass() {
        Enum result = Enums.getEnumByKey(String.class, "key");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNonBaseEnumClass() {
        Enum result = Enums.getEnumByKey(SomeEnum.class, "key");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNonEnumClass() {
        Enum result = Enums.getEnumByKey(SomeBaseEnum.class, "key");
    }

    private enum SomeEnum {
    }

    private class SomeBaseEnum implements BaseEnum {

        @Override
        public String getKey() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}