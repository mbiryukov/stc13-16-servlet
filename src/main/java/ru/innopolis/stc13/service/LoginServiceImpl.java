package ru.innopolis.stc13.service;

import ru.innopolis.stc13.pojo.User;
import ru.innopolis.stc13.repository.dao.UserDao;
import ru.innopolis.stc13.repository.dao.UserDaoImpl;
import ru.innopolis.stc13.utils.UtilMD5;

import java.sql.SQLException;

public class LoginServiceImpl implements LoginService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public int getRole(String login) {
        User user;
        if (login != null) {
            try {
                user = userDao.getUserByLogin(login);
                if (user == null){
                    return -1;
                }
                return user.getRole();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override
    public boolean checkAuth(String login, String password) {
        User user;

        if (login != null) {
            try {
                user = userDao.getUserByLogin(login);
                if (user != null){
                    if (user.getPassword().equals(UtilMD5.md5Custom(password)))
                        return true;
                } else {
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(UtilMD5.md5Custom("1234"));

    }
}
