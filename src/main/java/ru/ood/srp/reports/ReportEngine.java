package ru.ood.srp.reports;

import java.util.function.Predicate;

public class ReportEngine implements Report {

    protected Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;").append(System.lineSeparator());
        createBody(filter, text);
        return text.toString();
    }

    private void createBody(Predicate<Employee> filter, StringBuilder text) {
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
    }
}
