package app.jdbc;

import java.sql.*;

public class JdbcTest {
    static final String url = "jdbc:postgresql://localhost:5432/TestDb?currentSchema=jdbc_test";
    static final String name = "postgres";
    static final String password = "kas3722058";

    public static void createTables() throws ClassNotFoundException {
        try{
            try(Connection connection = DriverManager.getConnection(url, name, password)){
                Statement statement = connection.createStatement();

                String sqlLine = "drop table if exists jdbc_test.person";
                statement.execute(sqlLine);

                sqlLine = "drop sequence if exists jdbc_test.personseq ";
                statement.execute(sqlLine);

                sqlLine = "CREATE SEQUENCE if not exists jdbc_test.personseq " +
                        "    INCREMENT 1 " +
                        "    START 10 " +
                        "    MINVALUE 1 " +
                        "    MAXVALUE 9223372036854775807 " +
                        "    CACHE 1;";
                statement.execute(sqlLine);

                sqlLine = "create table Person " +
                        "(" +
                    "id integer default nextval('personseq'::regclass) not null " +
                        "constraint person_pkey " +
                        "primary key, " +
                    "name char(100), " +
                    "salary real, " +
                    "birthday date, " +
                    "sex integer" +
                        ");";
                statement.execute(sqlLine);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        createTables();
        try{
            try(Connection connection = DriverManager.getConnection(url, name, password)){
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from Person");
                while (resultSet.next()){
                    System.out.println(resultSet.getInt("id") + " " +
                            resultSet.getString("name"));
                }
                statement.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
