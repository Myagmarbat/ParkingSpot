/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.asd.project.fw.customer.dao;

import edu.mum.asd.project.application.web.ConnectionPool;
import edu.mum.asd.project.fw.customer.CustomerType;
import edu.mum.asd.project.fw.customer.Member;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 985965
 */
public class MemberDAO {

    public void createMember(Member m) {
        try {
            ConnectionPool.createData("INSERT INTO customer (first_name, last_name, email, address) VALUES ('" + m.getFirstName() + "', '" + m.getLastName() + "', '" + m.getEmail() + "');");
            ConnectionPool.createData("INSERT INTO customer_address (`city`, `street`, `zip`, `state`) VALUES ('" + m.getAddress().getCity() + "', '" + m.getAddress().getStreet() + "', '" + m.getAddress().getZip() + "', '" + m.getAddress().getState() + "');");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Member> getMembers() {
        List<Member> members = new ArrayList<Member>();
        ResultSet rs = ConnectionPool.getData("SELECT customer.*, customer_type.name as type_name FROM spotsystem.customer left join customer_type on customer.customer_type = customer_type.customer_type_id;");
        try {
            while (rs.next()) {
                members.add(setObject2Member(rs));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return members;
    }

    public Member getMember(Integer id) {
        ResultSet rs = ConnectionPool.getData("select * from customer where customer_id=" + id);
        try {
            if (rs.next()) {
                return setObject2Member(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Member setObject2Member(ResultSet rs) {
        Member obj = new Member();
        CustomerType ct;
        try {
            obj.setId(rs.getInt("customer_id"));
            obj.setLastName(rs.getString("last_name"));
            obj.setFirstName(rs.getString("first_name"));
            obj.setEmail(rs.getString("email"));
//                obj.setLastName(rs.getString("address"));
            ct = new CustomerType();
            ct.setId(rs.getInt("customer_type"));
            ct.setName(rs.getString("type_name"));
            obj.setCustomerType(ct);
            return obj;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
