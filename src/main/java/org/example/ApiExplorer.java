package org.example;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

//해양수산부_선박제원정보 서비스 API
public class ApiExplorer {
    // XML을 JSON으로 변환하는 메서드
    public static String convertXmlToJson(String xmlData) throws Exception {
        // XML을 읽을 XmlMapper 객체 생성
        XmlMapper xmlMapper = new XmlMapper();
        // XML 데이터를 JsonNode로 변환
        JsonNode jsonNode = xmlMapper.readTree(xmlData.getBytes());

        // JsonNode를 JSON 문자열로 변환
        ObjectMapper jsonMapper = new ObjectMapper();
        System.out.println(jsonMapper.writeValueAsString(jsonNode));
        return jsonMapper.writeValueAsString(jsonNode);
    }

    // JSON 데이터를 반환하는 메서드
    public static String fetchJsonData(String callSign, String shipName) throws Exception {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1192000/SicsVsslManp2/Info"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=s8NQPp8lC2S2DEC2J%2Fe4XvNZG9Mj7lH3VRqlDcuUtmz6%2B5Or5t0jrenDdGymcFOYTVA7EjuVepvUnnC1IrdtuQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("50", "UTF-8")); /*조회 결과 데이터 최대 개수(최대 50)*/
        urlBuilder.append("&" + URLEncoder.encode("vsslNm","UTF-8") + "=" + URLEncoder.encode(shipName, "UTF-8")); /*검색하고자 하는 선박명*/
        urlBuilder.append("&" + URLEncoder.encode("clsgn","UTF-8") + "=" + URLEncoder.encode(callSign, "UTF-8")); /*검색을 원하는 조회 호출부호*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();


        // XML을 JSON으로 변환하여 반환
        return convertXmlToJson(String.valueOf(sb));

    }
}
