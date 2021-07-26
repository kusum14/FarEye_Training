import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class Crud {
        private  final String url = "jdbc:postgresql://localhost:5432/CRUD2?useSSL=false";
        private final String user= "postgres";
        private final String password = "admin123";


        //Connection_JDBC
        public Connection connect(){
            Connection conn=null;
            try{
                conn = DriverManager.getConnection(url, user, password);
                if(conn != null){
                    System.out.println("Connection  to the PostgreSQL server successful");
                }
                else{
                    System.out.println("Connection Failed");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return conn;
        }


    // Create table
    private static final String createTableSQL = "CREATE TABLE users" +
            "(ID INT PRIMARY KEY ," + "NAME TEXT, " + "EMAIL VARCHAR(50)," + "COUNTRY VARCHAR(50))" ;
    public void CreateTable() throws SQLException{
        System.out.println(createTableSQL);
        
        try(Connection connection= getConnection(url, user, password);
            Statement statement = connection.createStatement();){
            statement.execute(createTableSQL);            
        }
        catch(SQLException e){
            printSQLException(e);
        }
            
    }

    // insert in table
    private static final String INSERT_USERS_SQL = "INSERT INTO users" +
            "  (id, name, email, country) VALUES " +
            " (?, ?, ?, ?);";
    public void InsertationinTable() throws SQLException{
        System.out.println(INSERT_USERS_SQL);
        try(Connection connection = DriverManager.getConnection(url, user, password);){
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setInt(1,2);
            preparedStatement.setString(2, "Priyanshu");
            preparedStatement.setString(3, "priyanshu@gmail.com");
            preparedStatement.setString(4, "India");
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            printSQLException(e);
        }
    }

    // QUERY

    private static final String QUERY = "select id,name,email,country from Users where id =?";
    private static final String ALL_QUERY = "select * from users";

    public void Query(){
        // All Query

        try(Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(ALL_QUERY);){

            System.out.println("---------All Query-----------");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int id= rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                System.out.println(id + "," + name + "," + email + ',' + country);
            }

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //Individual Query
        try(Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);){
            System.out.println("---------Individual Query-----------");
            preparedStatement.setInt(1,2);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int id= rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                System.out.println(id + "," + name + "," + email + ',' + country);
            }

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    // Update
    private static final String updating = "update users set name = ?, email = ? where id = ?";

    public  void  updateRecord() throws SQLException{
        try(Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement preparedStatement = connection.prepareStatement(updating)){
            preparedStatement.setString(1, "Priyan");
            preparedStatement.setString(2, "Priyan@gmail.com");
            preparedStatement.setInt(3, 2);
            preparedStatement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Delete
    private static final String DELETE_USERS_SQL = "DELETE from users where id = ?;";

    public  void  deleteQuery() throws SQLException{
        try(Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL)){
            preparedStatement.setInt(1, 2);
            preparedStatement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }



    public static void main(String[] args) throws SQLException {
        Crud app = new Crud();

        /*//Connect_JDBC
        app.connect();
*//*
        // Create  Table
        app.CreateTable();
*/
        //Insertation in table
        app.InsertationinTable();

      /*  // Retreave or Query
        app.Query();
*//*
        //Update
        app.updateRecord();*/

        // Delete Query
        app.deleteQuery();








    }

}
