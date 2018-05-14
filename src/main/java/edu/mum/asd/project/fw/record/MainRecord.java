/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.asd.project.fw.record;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 985965
 */
public class MainRecord {
    public static void main(String[] args) {
        RecordFacade f = new RecordFacade();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);
        f.checkIn(1, ids, 1);
//        System.out.println("pId: " + pId);
    }
}
