package org.example.Dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.Model.SelectShipModel;
import org.example.Model.ShipModel;
import org.example.ShipMapper;

public class ShipDao {

    private SqlSessionFactory sqlSessionFactory;

    public ShipDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void ShipService(ShipModel shipModel) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ShipMapper shipMapper = session.getMapper(ShipMapper.class);
            // insertShip 메서드 호출하여 shipModel 삽입
            shipMapper.insertShip(shipModel);
            session.commit(); // 변경 사항을 커밋하여 데이터베이스에 반영
        }
    }

    /*public void insertPastData(SelectShipModel data) {
        try (var session = sqlSessionFactory.openSession()) {
            session.insert("org.example.Dao.ShipDao.insertPastData", data);
            session.commit();
        }
    }*/

    public void insertPastData(SelectShipModel data) {
        try (var session = sqlSessionFactory.openSession()) {
            ShipMapper shipMapper = session.getMapper(ShipMapper.class);
            shipMapper.insertPastData(data);
            session.commit();
        }
    }
}
