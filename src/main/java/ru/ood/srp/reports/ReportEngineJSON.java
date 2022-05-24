package ru.ood.srp.reports;

import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.function.Predicate;

public class ReportEngineJSON extends ReportEngine {


    public ReportEngineJSON(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return new GsonBuilder().create().toJson(store);
    }

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
