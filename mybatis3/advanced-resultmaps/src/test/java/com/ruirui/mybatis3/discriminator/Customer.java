package com.ruirui.mybatis3.discriminator;

public class Customer extends Person {
    private Person salesman;

    public Person getSalesman() {
        return salesman;
    }

    public void setSalesman(Person salesman) {
        this.salesman = salesman;
    }
}
