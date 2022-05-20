package ru.ood.srp.reports;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportEngineTest {

    private final String newLine = System.lineSeparator();

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        String expect = "Name; Hired; Fired; Salary;"
                + newLine
                + worker.getName() + ";"
                + worker.getHired() + ";"
                + worker.getFired() + ";"
                + worker.getSalary() + ";" + newLine;
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenReportForDeveloper() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngineDev(store);
        String expect = "<!DOCTYPE html>" + newLine
                + "<html>" + newLine
                + "<header>" + newLine
                + "</header>" + newLine
                + "<body>" + newLine
                + "<table border = \"1\">" + newLine
                + "<tr>" + newLine
                + "<th>Name</th>" + newLine
                + "<th>Hired</th>" + newLine
                + "<th>Fired</th>" + newLine
                + "<th>Salary</th>" + newLine
                + "</tr>" + newLine
                + "<tr>" + newLine
                + "<td>" + worker.getName() + "</td>"
                + newLine
                + "<td>" + worker.getHired() + "</td>"
                + newLine
                + "<td>" + worker.getFired() + "</td>"
                + newLine
                + "<td>" + worker.getSalary() + "</td>"
                + newLine
                + "</tr>" + newLine
                + "</table>" + newLine
                + "</body>" + newLine
                + "</html>" + newLine;
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenReportForAccounting() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngineAccounting(store);
        String expect = "Name; Hired; Fired; Salary;" + newLine
                + worker.getName() + ";"
                + worker.getHired() + ";"
                + worker.getFired() + ";"
                + worker.getSalary() * 7.36 + ";" + newLine;
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenReportForHr() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee firstWorker = new Employee("Ivan", now, now, 100);
        Employee secondWorker = new Employee("Kolya", now, now, 250);
        Employee thirdWorker = new Employee("John", now, now, 35);
        store.add(firstWorker);
        store.add(secondWorker);
        store.add(thirdWorker);
        Report engine = new ReportEngineHR(store);
        String expected = "Name; Salary;" + newLine
                + secondWorker.getName() + ";"
                + secondWorker.getSalary() + ";"
                + newLine
                + firstWorker.getName() + ";"
                + firstWorker.getSalary() + ";"
                + newLine
                + thirdWorker.getName() + ";"
                + thirdWorker.getSalary() + ";"
                + newLine;
        assertThat(engine.generate((em -> true)), is(expected));
    }
}