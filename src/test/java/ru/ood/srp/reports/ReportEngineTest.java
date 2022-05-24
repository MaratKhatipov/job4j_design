package ru.ood.srp.reports;

import org.junit.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static ru.ood.srp.reports.ReportEngineAccounting.AMD;

public class ReportEngineTest {

    private final String newLine = System.lineSeparator();

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(newLine)
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(newLine);
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportForDeveloper() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngineDev(store);
        StringBuilder expect = new StringBuilder()
                .append("<!DOCTYPE html>").append(newLine)
                .append("<html>").append(newLine)
                .append("<header>").append(newLine)
                .append("</header>").append(newLine)
                .append("<body>").append(newLine)
                .append("<table border = \"1\">").append(newLine)
                .append("<tr>").append(newLine)
                .append("<th>Name</th>").append(newLine)
                .append("<th>Hired</th>").append(newLine)
                .append("<th>Fired</th>").append(newLine)
                .append("<th>Salary</th>").append(newLine)
                .append("</tr>").append(newLine)
                .append("<tr>").append(newLine)
                .append("<td>").append(worker.getName()).append("</td>").append(newLine)
                .append("<td>").append(worker.getHired()).append("</td>").append(newLine)
                .append("<td>").append(worker.getFired()).append("</td>").append(newLine)
                .append("<td>").append(worker.getSalary()).append("</td>").append(newLine)
                .append("</tr>").append(newLine)
                .append("</table>").append(newLine)
                .append("</body>").append(newLine)
                .append("</html>").append(newLine);
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportForAccounting() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngineAccounting(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(newLine)
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() * AMD).append(";")
                .append(newLine);
        assertThat(engine.generate(em -> true), is(expect.toString()));
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
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;").append(newLine)
                .append(secondWorker.getName()).append(";")
                .append(secondWorker.getSalary()).append(";")
                .append(newLine)
                .append(firstWorker.getName()).append(";")
                .append(firstWorker.getSalary()).append(";")
                .append(newLine)
                .append(thirdWorker.getName()).append(";")
                .append(thirdWorker.getSalary()).append(";")
                .append(newLine);
        assertThat(engine.generate((em -> true)), is(expected.toString()));
    }

    @Test
    public void whenReportConvertXML() throws DatatypeConfigurationException {
        MemStore store = new MemStore();
        GregorianCalendar now = new GregorianCalendar();
        XMLGregorianCalendar convertDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(now);
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngineXML(store);
        StringBuilder expected = new StringBuilder();
                expected.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>").append("\n")
                .append("<Employees>" + "\n")
                .append("    <employees>").append("\n")
                .append("        <fired>").append(convertDate).append("</fired>").append("\n")
                .append("        <hired>")
                .append(convertDate)
                .append("</hired>").append("\n")
                .append("        <name>")
                .append(worker.getName())
                .append("</name>").append("\n")
                .append("        <salary>")
                .append(worker.getSalary())
                .append("</salary>").append("\n")
                .append("    </employees>").append("\n")
                .append("</Employees>").append("\n");
        System.out.println(engine.generate(em -> true));
        assertThat((engine.generate(employee -> true)), is(expected.toString()));

    }

    @Test
    public void whenReportConvertJSON() throws DatatypeConfigurationException {
        MemStore store = new MemStore();
        Calendar now = new GregorianCalendar(2022, Calendar.MAY, 24);
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngineJSON(store);
        StringBuilder expect = new StringBuilder();
        expect
                .append("{\"employees\":["
                        + "{\"name\":\"Ivan\""
                        + ",\"hired\":{"
                        + "\"year\":2022,\"month\":4,\"dayOfMonth\":24,\"hourOfDay\":0,\"minute\":0,\"second\":0}"
                        + ",\"fired\":{"
                        + "\"year\":2022,\"month\":4,\"dayOfMonth\":24,\"hourOfDay\":0,\"minute\":0,\"second\":0}"
                        + ",\"salary\":100.0}]}");
        System.out.println(engine.generate(employee -> true));
        assertThat(engine.generate(employee -> true), is(expect.toString()));
    }
}