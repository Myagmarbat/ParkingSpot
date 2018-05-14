/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.asd.project.fw.customer.dao;


import edu.mum.asd.project.application.web.ConnectionPool;
import edu.mum.asd.project.fw.customer.AddressMember;

/**
 *
 * @author 985965
 */
public class AddressDAO {
    public void createAddress(AddressMember a) {
    	 try {
             ConnectionPool.createData("INSERT INTO customer_address (`city`, `street`, `zip`, `state`) VALUES ('" + a.getCity() + "', '" + a.getStreet() + "', '" + a.getZip() + "', '" + a.getState() + "');");
         } catch (Exception e) {
             System.out.println(e);
         }
    }
}
