package com.ism.repository.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ism.entities.Client;
import com.ism.repository.RepositoryClient;

public class ClientRepositoryBD extends RepositoryBDImpl<Client> implements RepositoryClient<Client> {
    private Object ps;

    @Override
    public Client selectByTelephone(String telephone) {
        PreparedStatement ps;
        Client client = null;
        Connection connect = null;
        try {
            String sql = "select * FROM Client WHERE telephone like ?";
            this.getConnexion();
            this.initPreparedStatement(sql);
            ((ClientRepositoryBD) this.ps).setString(telephone);
            ResultSet rs = this.executeQuery(sql);

            if (rs.next()) {
                client = new Client();
                client.setSurname(rs.getString("surnom"));
                client.setTelephone(rs.getString("telephone"));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données");
        }
        return client;
    }

    private ResultSet executeQuery(String sql) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'executeQuery'");
    }

    private void setString(String telephone) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setString'");
    }

    private void initPreparedStatement(String sql) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initPreparedStatement'");
    }

    private void getConnexion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getConnexion'");
    }

    @Override
    public void insert(Client client) {
        PreparedStatement stmt;
        int nbre = 0;
        Connection connect;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/connection", "root", "");
            String sql = "INSERT INTO `Client` (`surname`, `telephone`, `addresse`) VALUES(?,?,?)";
            stmt = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, client.getSurname());
            stmt.setString(2, client.getTelephone());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {

            }
            System.err.println("Connection BD etablie");
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement du fichier");
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données");
        }
    }

    @Override
    public List<Client> selectAll() {
        List<Client> clients = new ArrayList<>();
        Connection connect;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/connection", "root", "");
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from `client`");
            while (rs.next()) {
                Client client = new Client();
                client.setSurname(rs.getString("surname"));
                client.setTelephone(rs.getString("telephone"));
                clients.add(client);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erreur de connexion à la base de données");
        }
        return clients;
    }

    @Override
    public Client selectBySurname(String surname) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectBySurname'");
    }

    @Override
    public int insert(String sql) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

}
