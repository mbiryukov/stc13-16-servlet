package ru.innopolis.stc13.repository.dao;

import ru.innopolis.stc13.pojo.User;

import java.sql.SQLException;

public interface UserDao {
     User getUserByLogin(String login) throws SQLException;
}
