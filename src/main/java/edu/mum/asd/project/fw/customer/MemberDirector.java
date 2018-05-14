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
public class MemberDirector {

    private MemberBuilder memberBuilder = null;

    public MemberDirector(MemberBuilder r) {
        this.memberBuilder = r;
    }

    public void construct() {
        memberBuilder.buildCustomer();
        memberBuilder.buildAddress();
    }

    public Member getMember() {
        return memberBuilder.build();
    }
}
