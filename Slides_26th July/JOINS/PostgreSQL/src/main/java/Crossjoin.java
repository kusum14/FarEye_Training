import java.sql.*;

public class Crossjoin {
    public static void main(String[] args) {
        crossjoinimplementation();
        //insertRecords();
    }

    private static void crossjoinimplementation()
    {
        try(Connection connection =
                    DriverManager.getConnection("jdbc:postgresql://localhost:5432/Joins?useSSL=false",
                            "postgres","master");
            Statement statement = connection.createStatement();

            ResultSet resultset = statement.executeQuery("SELECT *  \n" +
                    "FROM public.\"Student\"  \n" +
                    "Cross Join public.\"Course\"\n"))

        {
            System.out.println("Student ID\t\tStudent First Name\t\t\tCourse ID\t\tCourse Name");

            while( resultset.next())
            {
                System.out.println(resultset.getInt(1)+"\t\t\t\t\t"+resultset.getString(2)
                        +"\t\t\t\t\t"+resultset.getString(3)+"\t\t\t\t"+resultset.getString(4));

            }
        }catch(SQLException throwables)
        {
            throwables.printStackTrace();
        }

    }
}
