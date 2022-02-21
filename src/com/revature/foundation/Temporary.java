package com.revature.foundation;

import com.revature.foundation.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class Temporary {

    public static void main(String[] args) {

        ConnectionFactory connFactory = ConnectionFactory.getInstance();
        ConnectionFactory connFactory2 = ConnectionFactory.getInstance();

        System.out.println(connFactory == connFactory2);

        Connection conn = null;

        try {
            conn = connFactory.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (conn == null) {
            System.out.println("Error");
        } else {
            System.out.println("Success");
        }

    }
}

