package ru.ood.srp.reports;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngineXML extends ReportEngine {

    public ReportEngineXML(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder result = new StringBuilder();
        try {
            result = xmlConvert(store.findBy(filter));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    private static StringBuilder xmlConvert(List<Employee> employeeList) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Employees.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringBuilder xml = new StringBuilder();
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(
                    new Employees(employeeList), writer);
            xml = new StringBuilder(writer.getBuffer().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xml;
    }
    @XmlAccessorType
    @XmlRootElement(name = "Employees")
    static class Employees {

        private List<Employee> employee;

        public Employees() {
        }

        public Employees(List<Employee> employees) {
            this.employee = employees;
        }

        public List<Employee> getEmployees() {
            return employee;
        }

        public void setEmployees(List<Employee> employees) {
            this.employee = employees;
        }
    }
}
