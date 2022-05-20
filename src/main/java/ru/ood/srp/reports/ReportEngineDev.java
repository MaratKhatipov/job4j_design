package ru.ood.srp.reports;

import java.util.function.Predicate;

public class ReportEngineDev extends ReportEngine {

    private final String newLine = System.lineSeparator();

    public ReportEngineDev(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        createHeader(text);
        createBody(filter, text);
        createTags(text.append("</table>").append(newLine), "</body>", "</html>");
        return text.toString();
    }

    private void createTags(StringBuilder text, String str, String str1) {
        text
                .append(str).append(newLine)
                .append(str1).append(newLine);
    }

    private void createHeader(StringBuilder text) {
        createTags(text.append("<!DOCTYPE html>").append(newLine)
                .append("<html>").append(newLine)
                .append("<header>").append(newLine)
                .append("</header>").append(newLine)
                .append("<body>").append(newLine)
                .append("<table border = \"1\">").append(newLine)
                .append("<tr>").append(newLine)
                .append("<th>Name</th>").append(newLine)
                .append("<th>Hired</th>").append(newLine)
                .append("<th>Fired</th>").append(newLine), "<th>Salary</th>", "</tr>");
    }

    private void createBody(Predicate<Employee> filter, StringBuilder text) {
        for (Employee employee : store.findBy(filter)) {
            createTags(text.append("<tr>").append(newLine)
                    .append("<td>").append(employee.getName()).append("</td>")
                    .append(newLine)
                    .append("<td>").append(employee.getHired()).append("</td>")
                    .append(newLine)
                    .append("<td>").append(employee.getFired()).append("</td>")
                    .append(newLine)
                    .append("<td>").append(employee.getSalary()), "</td>", "</tr>");
        }
    }
}
