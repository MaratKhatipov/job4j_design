package ru.ood.srp.reports;

import java.util.List;
import java.util.function.Predicate;

public class ReportEngineHR extends ReportEngine {

    private final String newLine = System.lineSeparator();

    public ReportEngineHR(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;").append(newLine);
        createBody(filter, text);
        return text.toString();
    }

    private void createBody(Predicate<Employee> filter, StringBuilder text) {
        List<Employee> employeeList = store.findBy(filter);
        employeeList.sort((x, y) -> (int) ((y.getSalary()) - (x.getSalary())));
        for (Employee employee : employeeList) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(newLine);
        }
    }
}
