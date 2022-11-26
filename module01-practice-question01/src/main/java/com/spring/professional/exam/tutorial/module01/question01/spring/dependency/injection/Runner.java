package com.spring.professional.exam.tutorial.module01.question01.spring.dependency.injection;

import com.spring.professional.exam.tutorial.module01.question01.manual.dependency.injection.EmployeeSalariesReportService1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String... args) {
        AnnotationConfigApplicationContext context = getSpringContext("pdf-reports");


        EmployeesSalariesReportService employeesSalariesReportService = context.getBean(EmployeesSalariesReportService.class);
        employeesSalariesReportService.generateReport();

        AnnotationConfigApplicationContext context1 = getSpringContext1("pdf-reports");
        EmployeeSalariesReportService1 employeeSalariesReportService1 = context1.getBean(EmployeeSalariesReportService1.class);
        employeeSalariesReportService1.generateReport();

        context.close();
    }

    private static AnnotationConfigApplicationContext getSpringContext(String profile) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles(profile);
        context.register(Configuration.class);
        context.refresh();
        return context;
    }

    private static AnnotationConfigApplicationContext getSpringContext1(String profile){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles(profile);
        context.register(Configuration.class);
        context.refresh();
        return context;
    }
}
