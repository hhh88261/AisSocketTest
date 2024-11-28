package org.example.Spliter;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.Dao.ShipDao;
import org.example.Model.SelectShipModel;
import org.example.OldDataPost.PastDataPost;

import java.io.IOException;
import java.io.Reader;

public class MessageSpliter {
    PastDataPost pastDataPost = new PastDataPost();

    public void messageInputer(String PastMessage) throws IOException {
        /// db 연결
        Reader reader = Resources.getResourceAsReader("Configuration.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        ShipDao shipDao = new ShipDao(sqlSessionFactory);

        SelectShipModel data = new SelectShipModel();

        String[] splitMessage = PastMessage.split(",");

        data.setShipDate(splitMessage[1]);
        data.setShipStartTime(splitMessage[2]);
        data.setShipEndTime(splitMessage[3]);

        System.out.println("과거 선박 정보: " + splitMessage[0] + splitMessage[1] + splitMessage[2]);

        shipDao.insertPastData(data);

        pastDataPost.PastShipDataPost();
    }
}
