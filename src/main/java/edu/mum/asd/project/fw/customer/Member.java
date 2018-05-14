/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.asd.project.fw.customer;

/**
 *
 * @author 985965
 */
public class Member extends AbstractCustomer {

    private CustomerType customerType = new CustomerType();
    private AddressMember address = new AddressMember();

    public Member() {
    }

    public Member(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    /**
     * @return the address
     */
    public AddressMember getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(AddressMember address) {
        this.address = address;
    }

    /**
     * @return the customerType
     */
    public CustomerType getCustomerType() {
        return customerType;
    }

    /**
     * @param customerType the customerType to set
     */
    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
