package com.lxx.cloud;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/micro_storage?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai";
            Connection conn = DriverManager.getConnection(url, "root", "root");
            System.out.println("连接成功！");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
