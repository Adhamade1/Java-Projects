package org.javaclass2020;

import java.sql.*;
import java.util.Arrays;

public class PayrollApp
{
    public static void main(String[] args)
    {
        testConnect();
        testSelect();
//        int [] arr = {1,2,3,4,5};
//        System.out.println(Arrays.toString(arr));
    }

    private static Connection connection;

    static void testConnect()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://157.245.65.64/javaclass2", "ozzy", "#Abcqr123");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    static void testSelect()
    {
        try
        {
            String selectSQL = "SELECT * FROM demo";
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(selectSQL);

            while (resultSet.next())
            {
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
