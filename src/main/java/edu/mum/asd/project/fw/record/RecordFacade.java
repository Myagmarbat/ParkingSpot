/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.asd.project.fw.record;

import edu.mum.asd.project.fw.record.dao.RecordDAO;
import edu.mum.asd.project.fw.record.dao.RecordSpotDAO;
import edu.mum.asd.project.fw.record.model.RecordFilter;
import java.util.List;

/**
 *
 * @author 985965
 */
public class RecordFacade {
    private Integer createRecord(Integer carTypeId, Integer cId){
        return RecordDAO.createRecord(carTypeId, cId);
    }

    public List<Record> getRecords(RecordFilter filter){
        return RecordDAO.getRecords(filter);
    }

    public void checkIn(Integer carType, List<Integer> sIds, Integer cId){
        Integer rId = createRecord(carType, cId);

        for(Integer i: sIds){
            RecordSpotDAO.createRecordSpot(rId, i);
        }
    }

    public void checkOut(Integer rId){
        RecordDAO.setCheckOutDate(rId);
    }

    public void washCar(Integer rId){
        RecordDAO.setWashCar(rId);
    }

    public void washedCar(Integer rId){
        RecordDAO.setWashedCar(rId);
    }
    
    public void parkWash(Integer pId) {
    	RecordDAO.setParkWash(pId);
    }
}
