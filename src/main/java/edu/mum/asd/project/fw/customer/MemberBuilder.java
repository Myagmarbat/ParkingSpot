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
public class MemberBuilder implements CustomerBuilder {

    private Member member;
//    private AddressMember address;

    private String firstName;
    private String lastName;
    private String email;

    private String street;
    private String city;
    private String state;
    private String zip;
    private Integer customerType;

    public MemberBuilder(String firstName, String lastName, String email, String street,
            String city,
            String state,
            String zip,
            Integer customerType
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.customerType = customerType;

    }

    public Member build() {
        return this.member;
    }

    public void buildAddress() {
        this.member.setAddress(new AddressMember());
        this.member.getAddress().setCity(this.city);
        this.member.getAddress().setState(this.state);
        this.member.getAddress().setZip(this.zip);
    }

    public void buildCustomer() {
        this.member = new Member(this.firstName, this.lastName, this.email);
    }

}
