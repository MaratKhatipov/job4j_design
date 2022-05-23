package ru.ood.srp.reports;

import java.util.function.Predicate;

public class ReportEngineAccounting extends ReportEngine {

    public static final double AMD = 7.36;

    private final String newLine = System.lineSeparator();

    public ReportEngineAccounting(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;").append(newLine);
        createBody(filter, text);
        return text.toString();
    }

    private void createBody(Predicate<Employee> filter, StringBuilder text) {
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() * AMD).append(";")
                    .append(newLine);
        }
    }
}
