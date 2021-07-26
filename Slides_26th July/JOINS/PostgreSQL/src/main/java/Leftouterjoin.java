import java.sql.*;

public class Leftouterjoin {
    public static void main(String[] args) {
        leftouterjoinimplementation();
        //insertRecords();
    }

    private static void leftouterjoinimplementation() {
        try (Connection connection =
                     DriverManager.getConnection("jdbc:postgresql://localhost:5432/Joins?useSSL=false",
                             "postgres", "master");
             Statement statement = connection.createStatement();

             ResultSet resultset = statement.executeQuery("SELECT *\n" +
                     "FROM public.\"Student\"\n" +
                     "LEFT JOIN public.\"Registration\"\n" +
                     "ON public.\"Student\".\"Student ID\" = public.\"Registration\".\"Student ID\";    \n" +
                     "\n")) {
            System.out.println("Student ID\t\tStudent First Name\t\tStudent ID\t\tCourse ID\t\t\tGrade");

            while (resultset.next()) {
                System.out.println(resultset.getInt(1) + "\t\t\t\t\t" + resultset.getString(2)
                        + "\t\t\t\t\t" + resultset.getInt(3) + "\t\t\t\t" + resultset.getString(4)
                        + "\t\t\t" + resultset.getInt(5));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
