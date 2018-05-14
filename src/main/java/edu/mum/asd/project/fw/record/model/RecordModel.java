/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.asd.project.fw.record.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 985965
 */
public class RecordModel {
    private Integer recordId;
    private Integer customerId;
    private Date checkIn;
    private Date checkOut;
    private float price;
    private List<Integer> spotIds;
    
}
