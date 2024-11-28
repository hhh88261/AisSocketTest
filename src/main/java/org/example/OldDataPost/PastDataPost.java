package org.example.OldDataPost;

import org.apache.ibatis.session.SqlSession;
import org.example.Model.PastShipDataSelectModel;
import org.example.MyBatisConfig.MyBatisUtil;

import java.util.List;

public class PastDataPost {
    public void PastShipDataPost() {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()){
            List<PastShipDataSelectModel> pastShipDataSelectModelList = session.selectList("org.example.ShipMapper.selectPastShipData");
            for(PastShipDataSelectModel pastData : pastShipDataSelectModelList) {
                if(pastData != null) {
                    System.out.println("과거 MMSI: " + pastData.getMmsi() + ", 과거 LON: " + pastData.getLon() + ", 과거 LAT: " + pastData.getLat());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}