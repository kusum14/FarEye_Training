import java.sql.*;

public class Innerjoin {
    public static void main(String[] args)
    {
        innerjoinimplementation();
        //insertRecords();
    }

    private static void innerjoinimplementation()
    {
        try(Connection connection =
                    DriverManager.getConnection("jdbc:postgresql://localhost:5432/Joins?useSSL=false",
                            "postgres","master");
            Statement statement = connection.createStatement();

            ResultSet resultset = statement.executeQuery("SELECT *\n" +
                    "FROM public.\"Student\"\n" +
                    "INNER JOIN public.\"Registration\"\n" +
                    "ON public.\"Student\".\"Student ID\" = public.\"Registration\".\"Student ID\";    \n" +
                    "\n"))

        {
            System.out.println("Student ID\t\tStudent First Name\t\t\tStudent ID\t\tCourse ID\t\t\tGrade");

            while( resultset.next())
            {
                System.out.println(resultset.getInt("Student ID")+"\t\t\t\t\t"+resultset.getString("Student First Name")
               +"\t\t\t\t\t\t"+resultset.getInt("Student ID")+"\t\t\t\t"+resultset.getString("Course ID")
               +"\t\t\t"+resultset.getInt("Grade"));

            }
        }catch(SQLException throwables)
        {
            throwables.printStackTrace();
        }

    }


}
