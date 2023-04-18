package app.jdbc;

import java.sql.*;

public class JdbcTest {
    static final String url = "jdbc:postgresql://localhost:5432/TestDb?currentSchema=jdbc_test";
    static final String name = "postgres";
    static final String password = "kas3722058";

    public static void createTables(Connection connection) throws SQLException {
                Statement statement = connection.createStatement();

                String sqlLine = "drop table if exists person";
                statement.execute(sqlLine);

                sqlLine = "drop sequence if exists personseq ";
                statement.execute(sqlLine);

                sqlLine = "CREATE SEQUENCE if not exists personseq " +
                        "    INCREMENT 1 " +
                        "    START 1 " +
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

                for (int i = 1; i <= 10; i ++) {
                    sqlLine = "insert into Person values " +
                            "(" + i + ", 'Вася" + i + "', 100, '2006-05-28', 1)";
//                    statement.executeUpdate(sqlLine);

                    statement.addBatch(sqlLine);
                }
                statement.executeBatch();

    }

    public static void print(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            System.out.println(resultSet.getInt("id") + " " +
                    resultSet.getString("name"));
        }

    }

    public static void prepareQuery(Connection connection) throws SQLException {
        System.out.println("*".repeat(40));
        System.out.println("PreparedStatement:");
        String sqlLine = "Select * from Person where id = ?";
        PreparedStatement statement = connection.prepareStatement(sqlLine);
        statement.setInt(1, 5);
        ResultSet resultSet = statement.executeQuery();
        print(resultSet);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        try{
            try(Connection connection = DriverManager.getConnection(url, name, password)){
                createTables(connection);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from Person");
                print(resultSet);

                resultSet = statement.executeQuery("select count(*) from Person");
                resultSet.next();

                System.out.println("count = " + resultSet.getInt(1));

                statement.close();
                prepareQuery(connection);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
