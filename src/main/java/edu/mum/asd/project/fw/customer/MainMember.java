/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.asd.project.fw.customer;

import edu.mum.asd.project.fw.customer.dao.MemberDAO;

/**
 *
 * @author 985965
 */
public class MainMember {
    public static void main(String[] args) {
        MemberDirector md = new MemberDirector(new MemberBuilder("name", "last","test@test.mn", "1", "2", "3", "4", 3));
        md.construct();
        MemberDAO m = new MemberDAO();
//        m.createMember(md.getMember());
//        System.out.println(":" +md.getMember().getFirstName());
//        System.out.println("get: " +m.getMember(3).getFirstName());
        for(Member mem: m.getMembers()){
            System.out.println(""+mem.getId() + ", " + mem.getFirstName());
        }
    }
}
