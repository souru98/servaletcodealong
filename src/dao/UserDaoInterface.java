package dao;

import model.user;

public interface UserDaoInterface {
int signup(user user) throws ClassNotFoundException;
boolean loginUser(user user) throws ClassNotFoundException;


}
