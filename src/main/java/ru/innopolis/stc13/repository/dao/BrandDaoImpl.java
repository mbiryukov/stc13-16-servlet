package ru.innopolis.stc13.repository.dao;

import ru.innopolis.stc13.pojo.Brand;
import ru.innopolis.stc13.repository.connectionManager.ConnectionManager;
import ru.innopolis.stc13.repository.connectionManager.ConnectionManagerJdbcImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrandDaoImpl implements BrandDao {
    private static ConnectionManager connectionManager =
            ConnectionManagerJdbcImpl.getInstance();

    @Override
    public List<Brand> getBrandList() {
        List<Brand> result = null;
        try (Connection connection = connectionManager.getConnection();
             Statement statement = connection.createStatement();) {

            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM manufacturer");) {
                result = new ArrayList<>();
                while (resultSet.next()) {
                    result.add(new Brand(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3)));

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insert(Brand brand) {
        ConnectionManager connectionManeger = ConnectionManagerJdbcImpl.getInstance();
        int i = 0;
        try(Connection connection = connectionManeger.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO manufacturer VALUES (DEFAULT, ?, ?) RETURNING id");
            preparedStatement.setString(1, brand.getName());
            preparedStatement.setString(2, brand.getCountry());
            ResultSet resultSet = preparedStatement.executeQuery();
//            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if ( resultSet.next() ) {
                i = (int) resultSet.getInt("id");
                brand.setId(i);
                System.out.println(i);}
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return i;
    }
}
