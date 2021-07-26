import java.sql.*;

public class Fullouterjoin {
    public static void main(String[] args) {
        fullouterjoinimplementation();
        //insertRecords();
    }

    private static void fullouterjoinimplementation() {
        try (Connection connection =
                     DriverManager.getConnection("jdbc:postgresql://localhost:5432/Joins?useSSL=false",
                             "postgres", "master");
             Statement statement = connection.createStatement();

             ResultSet resultset = statement.executeQuery("SELECT *  \n" +
                     "FROM public.\"Registration\"  \n" +
                     "Full Outer Join public.\"Course\"\n" +
                     "ON public.\"Registration\".\"Course ID\"= public.\"Course\".\"Course ID\"\n")) {
            System.out.println("Student ID\t\tCourse ID\t\tGrade  \t\tCourse ID\t\t\tCourse Name");

            while (resultset.next()) {
                System.out.println(resultset.getInt(1) + "\t\t\t\t" + resultset.getString(2)
                        + "\t\t\t\t" + resultset.getInt(3) + "\t\t\t" + resultset.getString(4)
                        + "\t\t\t" + resultset.getString(5));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
