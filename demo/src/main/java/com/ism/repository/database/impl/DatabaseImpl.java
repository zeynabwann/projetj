package com.ism.repository.database.impl;

import java.sql.*;

import com.ism.repository.database.Database;

public class DatabaseImpl implements Database {
    private final String url = "jdbc:mysql://localhost:3306/connection";
    private final String user = "root";
    private final String password = "root";
    protected PreparedStatement ps;
    protected Connection connect = null;

    @Override
    public void getConnexion() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void CloseConnexion() throws SQLException {
        if (connect != null && !connect.isClosed()) {
            connect.close();

        }
    }
    

    @Override
    public ResultSet executeQuery(String sql) throws SQLException {
        this.initPreparedStatement(sql);
        return ps.executeQuery();
    }

    @Override
    public int executeUpdate(String sql) throws SQLException {
        this.initPreparedStatement(sql);
        return ps.executeUpdate();
    }

    @Override
    public void  initPreparedStatement(String sql) throws SQLException {

        if (sql.toUpperCase().trim().startsWith("INSERT")) {
            ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            
        }
        else{
            ps = connect.prepareStatement(sql);
        }


    }

}
