import java.sql.*;

public class DatabaseOperations {
    public static void main(String[] args)
    {
        selectRecords();
        insertRecords();
    }


    public static void insertRecords()
    {
        Connection connection = null;
        Statement statement = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/School?useSSL=false",
                            "postgres","master");
            connection.setAutoCommit(false);
            statement=connection.createStatement();
            String sql = "INSERT INTO public.\"Address\"(\"Id\",\"City\", \"State\", \"Zip\")\n" +
                    "\tVALUES (2,'Gurugram', 'Haryana', '12121');";
            statement.executeUpdate(sql);
            statement.close();
            connection.commit();
            connection.close();




        }catch(SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    private static void selectRecords()
    {
        try(Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/School?useSSL=false",
                        "postgres","master");
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("Select\"Id\",\"Name\",\"AddressId\" " +
                "FROM public.\"Student\";"))
        {
            while( resultset.next())
            {
                System.out.println("Id : "+resultset.getInt("id"));
                System.out.println("Name :"+resultset.getString("Name"));
                System.out.println("Address :"+resultset.getString("AddressId"));

            }
        }catch(SQLException throwables)
        {
            throwables.printStackTrace();
        }

    }

}


















