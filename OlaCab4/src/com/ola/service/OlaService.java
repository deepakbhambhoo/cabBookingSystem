package com.ola.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import com.ola.dao.CabDao;
import com.ola.dao.ConnectionDB;
import com.ola.dao.UserDao;
import com.ola.dao.UserHistoryDao;
import com.ola.modal.Cab;
import com.ola.modal.User;
import com.ola.modal.UserHistory;

public class OlaService {

	List<Cab> cabList;
	List<User> userList;
	CabDao cabDao;
	UserDao userDao;
	UserHistoryDao userHistoryDao;

	public OlaService() {
		Connection conn = ConnectionDB.connectionDb();
		cabDao = new CabDao(conn);
		userDao = new UserDao(conn);
		userHistoryDao = new UserHistoryDao(conn);
		try {
			cabList = cabDao.getAllCab();
			userList = userDao.getAllUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void registerCabDriver(Cab cab) {
		try {
			cabDao.registerCab(cab);
			this.cabList = cabDao.getAllCab();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void registerUser(User user) {
		try {
			userDao.registerUser(user);
			this.userList = userDao.getAllUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void unregisterCabDriver(Cab cab) {
		try {
			cabDao.unRegisterCab(cab);

			this.cabList = cabDao.getAllCab();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void unregisterUser(User user) {
		try {
			userDao.unRegisterUser(user);
			this.userList = userDao.getAllUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Cab cabBooking(User user) {
		String userIBookCar = user.getUserId();
		String bookCabID = null;
		ListIterator<Cab> listIterator = cabList.listIterator();
		while (listIterator.hasNext()) {
			Cab cabAvailable = listIterator.next();
			if (cabAvailable.isAvailable()) {

				System.out.println("Cab Booking Sucessfully");
				try {
					cabDao.unRegisterCab(cabAvailable);
					cabAvailable.setAvailable(false);
					cabDao.registerCab(cabAvailable);
					this.cabList = cabDao.getAllCab();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				bookCabID = cabAvailable.getCabNumber();
				createUserHistory(userIBookCar, bookCabID);
				return cabAvailable;
			}
		}
		return null;
	}

	public boolean cabCancel(Cab cab) {
		try {
			cabDao.unRegisterCab(cab);
			cab.setAvailable(true);
			cabDao.registerCab(cab);
			this.cabList = cabDao.getAllCab();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public UserHistory createUserHistory(String userIBookCar, String bookCabID) {
		UserHistory userHistory = new UserHistory(userIBookCar, bookCabID, new Date());
		try {
			userHistoryDao.insetUserHistory(userHistory);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public UserHistory getUserHistory(String userid) {
		UserHistory userHistory = null;
		try {
			userHistory = userHistoryDao.getUserHistroy(userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userHistory;

	}

	public List<Cab> getCabList() {
		return cabList;
	}

	public void setCabList(List<Cab> cabList) {
		this.cabList = cabList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public CabDao getCabDao() {
		return cabDao;
	}

	public void setCabDao(CabDao cabDao) {
		this.cabDao = cabDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}