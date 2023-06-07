package com.example.demo.common.utils;

import com.sun.org.apache.xml.internal.utils.StringToIntTable;

import java.util.UUID;

import java.sql.*;

public class UUIDUtil {
  static int count = 2;

  public static String getOneUUID() {
    String s = UUID.randomUUID().toString();
    return s.substring(0, 8)
        + s.substring(9, 13)
        + s.substring(14, 18)
        + s.substring(19, 23)
        + s.substring(24);
  }

  public static int getQuestionnaireUUID() {
    String url = "jdbc:mysql://localhost:3306/myweb";
    String username = "root";
    String password = "zcx.11123";
    String tableName = "questionnaire_info";

    try (Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement()) {

      String query = "SELECT COUNT(*) FROM " + tableName;
      ResultSet resultSet = statement.executeQuery(query);
      if (resultSet.next()) {
        int rowCount = resultSet.getInt(1);
        return rowCount + 1;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return -1;
  }


  public static String[] getUUID(int number) {
    if (number < 1) {
      return null;
    }
    String[] ss = new String[number];
    for (int i = 0; i < number; ++i) {
      ss[i] = getOneUUID();
    }
    return ss;
  }
}
