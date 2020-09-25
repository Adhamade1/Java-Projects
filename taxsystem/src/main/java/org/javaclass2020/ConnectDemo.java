package org.javaclass2020;
//import java.sql.*;
//import java.util.List;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectDemo
{

    public static void main(String[] args)
    {
        openConnection();
        employeeRows();
    }

    static String url = "jdbc:mysql://157.245.65.64/javaclass2";
    //    SYNTAX FOR PROXY
//    jdbc:{name of db}://{address of db server}:port/{name of db}
    static Connection connection;
    static String username = "ozzy";
    static String password = "#Abcqr123";
    static String selectSalary = " select * from salarygrades2";
    static String selectEmployee = " select * from employees2";
    static String selectTaxBracket = " select * from taxbracket2";

//    SYNTAX TO INSERT INTO SALARYGRADE TABLE
    static String insertSQL = " insert into salarygrades2 (grade,salary) values ('G6',280000)";
    static String insertStatement6 = " insert into salarygrades2 (grade,salary,description) values ('G6',280000,)";

//    UPDATE SYNTAX
    static String update11 = "update salarygrades2 set overtime= 240 where grade='G10'";
//    DELETE SYNTAX
    static String delete10 = "delete from salarygrades2 where grade = 'G9'";

//    SYNTAX TO INSERT INTO TABLE
    static String employee1 = "insert into employees2 (id,firstname , lastname , gender , age, address,  phone, email)\n" +
            "values ('1.3.1','Salawu', 'Romoke', 'Female', 43, 'Ikeja',  '08102804355', 'adhamade2014@gmail.com')";
    static String employee2 = " insert into employees2 (id,firstname , lastname , gender , age, address, phone, email)\n" +
            "values ('1.3.2','Oladipupo', 'Olabisi', 'Female', 54, 'Shomolu',  '08079574195', 'opebiade@gmail.com') ";

//    SYNTAX TO INSERT INTO TAX BRACKET TABLE
//    static String taxBracket1 = "insert into taxbracket2 (bracket, grade,taxpercent, description ) values ('T1', 'G1',1.25,'for tax bracket 1')";
//    static String taxBracket2 = "insert into taxbracket2 (bracket, grade,taxpercent, description ) values ('T2', 'G12',2.25,'for tax bracket 1')";

    public static void openConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static void runSelect()
    {
        try
        {
            Statement jdbcStatement = connection.createStatement();
            ResultSet rows = jdbcStatement.executeQuery(selectSalary);

            while (rows.next())
            {
                String grade = rows.getString("grade");
                double salary = rows.getDouble("salary");
                System.out.println("The salary for grade level " + grade + "is-> " + salary);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void insertRows()
    {
        try
        {
            Statement insertStatement = connection.createStatement();

//            int affectedRows = insertStatement.executeUpdate(insertSQL);

//            INSERT ROWS INTO SALARY GRADE
//            insertStatement.executeUpdate(insertStatement7);
//
//            INSERT ROWS INTO TAX EMPLOYEE
//            insertStatement.executeUpdate(employee1);

//            INSERT ROWS INTO TAX BRACKET
//            insertStatement.executeUpdate(taxBracket1);

            runSelect();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public static void updateRows()
    {
        try
        {
            Statement updateStatement = connection.createStatement();
//            updateStatement.executeUpdate(update11);
            runSelect();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }

//        runSelect();
    }

    public static void deleteRows()
    {
        try
        {
            Statement deleteStatement = connection.createStatement();
//             deleteStatement.executeUpdate(delete10);
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public static void runSalary()
    {
        List<SalaryGrade> grades = getGrade();
        for (SalaryGrade grade : grades)
        {
            System.out.println("salary for grade " + grade.getGrade()
                    + " is= " + grade.getSalary());
        }

    }

    public static List<SalaryGrade> getGrade()
    {
        List<SalaryGrade> grades = new ArrayList<>();
        try
        {
            Statement stat = connection.createStatement();
            ResultSet rows = stat.executeQuery(selectSalary);

            while (rows.next())
            {
                String grade = rows.getString("grade");
                double salary = rows.getDouble("salary");
                //System.out.println("salary for grade " + grade + " is= " + salary);

                SalaryGrade salaryGrade = new SalaryGrade();
                salaryGrade.setGrade(grade);
                salaryGrade.setSalary(salary);

                grades.add(salaryGrade);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return grades;
    }

    public static void employeeRows()
    {
        List<Employee> implore = getEmployeeRows();
        for (Employee count : implore)
        {
            System.out.println("The name of the employee with id number " + count.getEmployeeId() + " who is a " +
                    count.getGender() + " is  " + count.getFirstName()
                    + " " + count.getLastName() + " and the age is " + count.getAge());
        }

    }

    public static List<Employee> getEmployeeRows()
    {
        List<Employee> employer = new ArrayList<>();
        try
        {
            Statement jdbcStatement = connection.createStatement();
            ResultSet rows = jdbcStatement.executeQuery(selectEmployee);

            while (rows.next())
            {
                String id = rows.getString("id");
                String first = rows.getString("firstname");
                String lastname = rows.getString("lastname");
                int age = rows.getInt("age");
                String gend = rows.getString("gender");
                //System.out.println("salary for grade " + grade + " is= " + salary);

                Employee employ = new Employee();
                employ.setFirstName(first);
                employ.setLastName(lastname);
                employ.setAge(age);
                employ.setGender(gend);
                employ.setEmployeeId(id);

                employer.add(employ);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return employer;
    }

    public static void taxBracketRows()
    {
        List<TaxBracket> taxee = getTaxTable();
        for (TaxBracket count : taxee)
        {
            System.out.println("The employer with tax bracket " + count.getBracket() + " and salary grade " +
                    count.getGrade() + " is to pay tax percent of  " + count.getTaxPercent());
        }

    }

    public static List<TaxBracket> getTaxTable()
    {
        List<TaxBracket> taxer = new ArrayList< >();
        try
        {
            Statement stat = connection.createStatement();
            ResultSet rows = stat.executeQuery(selectTaxBracket);

            while (rows.next())
            {
                String grade = rows.getString("grade");
                String bracket = rows.getString("bracket");
                double taxPercent = rows.getDouble("taxpercent");

                //System.out.println("salary for grade " + grade + " is= " + salary);

                TaxBracket tax = new TaxBracket();
                tax.setGrade(grade);
                tax.setBracket(bracket);
                tax.setTaxPercent(taxPercent);

                taxer.add(tax);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return taxer;
    }

}
