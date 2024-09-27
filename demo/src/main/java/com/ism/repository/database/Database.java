package com.ism.repository.database;
import java.sql.*;

public interface  Database {
    void getConnexion() throws SQLException;
    void CloseConnexion() throws SQLException;
    ResultSet executeQuery(String sql) throws SQLException;
    void  initPreparedStatement(String sql) throws SQLException;
    int executeUpdate(String sql) throws SQLException;

    



    
}
