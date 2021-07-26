import java.sql.*;

public class Selfjoin {
    public static void main(String[] args) {
        selfjoinimplementation();
        //insertRecords();
    }

    private static void selfjoinimplementation() {
        try (Connection connection =
                     DriverManager.getConnection("jdbc:postgresql://localhost:5432/Joins?useSSL=false",
                             "postgres", "master");
             Statement statement = connection.createStatement();

             ResultSet resultset = statement.executeQuery("SELECT *\n" +
                     "FROM public.\"Customer\" C1 , public.\"Customer\" C2\n" +
                     "WHERE C1.\"Customer ID\" <> C2.\"Customer ID\"\n" +
                     "AND C1.\"Customer City\" = C2.\"Customer City\"")) {
            System.out.println("Customer ID\t\tCustomer Name\t\t\tCustomer City\t\tCustomer ID\t\tCustomer Name\t\tCustomer City");

            while (resultset.next()) {
                System.out.println(resultset.getInt(1) + "\t\t\t\t\t\t" + resultset.getString(2)
                        + "\t\t\t\t" + resultset.getString(3) + "\t\t\t\t" + resultset.getInt(4)
                        + "\t\t\t" + resultset.getString(5)+"\t\t\t\t"+resultset.getString(6));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
