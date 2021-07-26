import java.sql.*;

public class Rightouterjoin {
    public static void main(String[] args) {
        rightouterjoinimplementation();
        //insertRecords();
    }

    private static void rightouterjoinimplementation() {
        try (Connection connection =
                     DriverManager.getConnection("jdbc:postgresql://localhost:5432/Joins?useSSL=false",
                             "postgres", "master");
             Statement statement = connection.createStatement();

             ResultSet resultset = statement.executeQuery("SELECT *  \n" +
                     "FROM public.\"Registration\"  \n" +
                     "Right JOIN public.\"Student\"\n" +
                     "ON public.\"Registration\".\"Student ID\"= public.\"Student\".\"Student ID\"\n")) {
            System.out.println("Student ID\t\tCourse ID\t\t\tGrade\t\tStudent ID\t\tStudent First Name");

            while (resultset.next()) {
                System.out.println(resultset.getInt(1) + "\t\t\t\t\t" + resultset.getString(2)
                        + "\t\t\t" + resultset.getInt(3) + "\t\t\t\t" + resultset.getInt(4)
                        + "\t\t\t" + resultset.getString(5));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}
