package com.ola.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.ola.modal.UserHistory;

public class UserHistoryDao {
	Connection conn;

	public UserHistoryDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public void insetUserHistory(UserHistory userHistory) throws SQLException {
		Timestamp ts = new Timestamp(userHistory.getTime().getTime());
		String userHistorySql = "INSERT INTO USER_HISTORY VALUES('" + userHistory.getUserId() + "','"
				+ userHistory.getCabName() + "', '" + ts + "')";
		PreparedStatement prepareStatement = this.conn.prepareStatement(userHistorySql);
		prepareStatement.execute();
		System.out.println(userHistorySql);
	}

	public UserHistory getUserHistroy(String userid) throws SQLException {
		String userHistory = "SELECT * FROM USER_HISTORY WHERE USER_ID= '" + userid + "'";
		PreparedStatement prepareStatement = this.conn.prepareStatement(userHistory);
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			String userId = rs.getString(1);
			String cabName = rs.getString(2);
			Date time = rs.getTimestamp(3);
			UserHistory userHistory2 = new UserHistory(userId, cabName, time);
			return userHistory2;
		}
		return null;

	}

	/*public static void main(String[] args) throws SQLException {
		Connection conn = ConnectionDB.connectionDb();
		UserHistory userHistory = new UserHistory("Deep@123", "HR 24 V 8650", new Date());
		UserHistoryDao userHistoryDao = new UserHistoryDao(conn);
		try {
			userHistoryDao.insetUserHistory(userHistory);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserHistory userHistoryGet = userHistoryDao.getUserHistroy("Deep@123");
		System.out.println(userHistoryGet);
	}*/

}
