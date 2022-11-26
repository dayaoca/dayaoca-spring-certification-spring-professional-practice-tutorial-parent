package com.spring.professional.exam.tutorial.module01.question01.manual.dependency.injection;

import com.spring.professional.exam.tutorial.module01.question01.commons.bls.EmployeeSalaryCalculator;
import com.spring.professional.exam.tutorial.module01.question01.commons.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.module01.question01.commons.ds.Employee;
import com.spring.professional.exam.tutorial.module01.question01.commons.ds.EmployeeSalary;
import com.spring.professional.exam.tutorial.module01.question01.commons.report.SalaryReport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeSalariesReportServiceTest {
    @InjectMocks
    EmployeeSalariesReportService1 employeeSalariesReportService1;
    @Mock
    EmployeeDao employeeDao;
    @Mock
    EmployeeSalaryCalculator employeeSalaryCalculator;
    @Mock
    SalaryReport salaryReport;
    @Mock
    List<Employee> employees;
    @Mock
    private List<EmployeeSalary> employeeSalaries;

    @Test
    public void shouldGenerateSalaryReport(){

        when(employeeDao.findAll()).thenReturn(employees);
        when(employeeSalaryCalculator.calculateSalaries(employees)).thenReturn(employeeSalaries);
        employeeSalariesReportService1.generateReport();
        verify(salaryReport).writeReport(employeeSalaries);
    }

}
