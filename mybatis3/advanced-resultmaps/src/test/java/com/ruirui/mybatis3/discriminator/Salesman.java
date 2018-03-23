package com.ruirui.mybatis3.discriminator;

import java.util.List;

public class Salesman extends Person {
    private List<Person> customers;

    public List<Person> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Person> customers) {
        this.customers = customers;
    }
}
