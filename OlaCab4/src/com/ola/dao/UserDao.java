package com.ola.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ola.modal.User;

public class UserDao {
	Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public void registerUser(User user) throws SQLException {
		String userSql = "INSERT INTO USER VALUES('" + user.getUserName() + "','" + user.getUserId() + "',"
				+ user.getPhone() + ",'" + user.getLocation() + "'," + user.getWallet() + ")";
		PreparedStatement prepareStatement = this.conn.prepareStatement(userSql);
		prepareStatement.execute();
		System.out.println(userSql);
	}

	public User getUser() throws SQLException {
		String getUser = "SELECT * FROM USER WHERE USER_ID= 'Deep@123'";
		PreparedStatement prepareStatement = this.conn.prepareStatement(getUser);
		try {
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				String userName = rs.getString(1);
				String userId = rs.getString(2);
				Long phone = rs.getLong(3);
				String location = rs.getString(4);
				Float wallet = rs.getFloat(5);
				User user = new User(userName, userId, phone, location, wallet);

				return user;

			}
			System.out.println("test3");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	public List<User> getAllUser() throws SQLException{
		String getUser = "SELECT * FROM USER";
		List<User> listUser=new ArrayList<User>();
		PreparedStatement prepareStatement = this.conn.prepareStatement(getUser);
		try {
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				String userName = rs.getString(1);
				String userId = rs.getString(2);
				Long phone = rs.getLong(3);
				String location = rs.getString(4);
				Float wallet = rs.getFloat(5);
				User user = new User(userName, userId, phone, location, wallet);
				listUser.add(user);
			

			}
			System.out.println("test2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listUser;

	
	}

	public void unRegisterUser(User user) throws SQLException {

		String deleteUser = "DELETE FROM USER WHERE USER_ID='" + user.getUserId() + "'";
		PreparedStatement prepareStatement = this.conn.prepareStatement(deleteUser);
		prepareStatement.execute();
		System.out.println("User Has Been Delete");

	}

	public static void main(String[] args) {
		Connection conn = ConnectionDB.connectionDb();
		User user = new User("Deepak", "Deep@123", Long.parseLong("7015157647"), "Gurgaon", Float.parseFloat("100"));

		UserDao userDao = new UserDao(conn);

		try {
			// userDao.registerUser(user);
			// User userData = userDao.getUser();
			// System.out.println(userData);
			userDao.unRegisterUser(user);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
