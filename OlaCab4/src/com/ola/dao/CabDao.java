package com.ola.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ola.modal.Cab;

public class CabDao {
	Connection conn;

	public CabDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public void registerCab(Cab cab) throws SQLException {
		String cabSql = "INSERT INTO CAB VALUES('" + cab.getCabName() + "','" + cab.getCabNumber() + "','"
				+ cab.getDriverName() + "'," + cab.getPhone() + ",'" + cab.getCity() + "'," + cab.isAvailable() + ")";
		PreparedStatement prepareStatement = this.conn.prepareStatement(cabSql);
		prepareStatement.execute();
		System.out.println(cabSql);
	}

	public Cab getCab(String cabNumber) throws SQLException {
		String getCab = "SELECT * FROM CAB WHERE CAB_NUMBER= '" + cabNumber + "'";
		PreparedStatement prepareStatement = this.conn.prepareStatement(getCab);
		try {
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {

				String cabName = rs.getString(1);
				String cabNumber2 = rs.getString(2);
				String driverName = rs.getString(3);
				long phone = rs.getLong(4);
				String city = rs.getString(5);
				boolean available = rs.getBoolean(6);
				Cab cab = new Cab(cabName, cabNumber2, driverName, phone, city, available);
				return cab;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	//to get all data of cab 
	public List<Cab> getAllCab() throws SQLException{
		String getCab = "SELECT * FROM CAB";
		List<Cab> listCab= new ArrayList<Cab>();
		PreparedStatement prepareStatement = this.conn.prepareStatement(getCab);
		try {
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {

				String cabName = rs.getString(1);
				String cabNumber2 = rs.getString(2);
				String driverName = rs.getString(3);
				long phone = rs.getLong(4);
				String city = rs.getString(5);
				boolean available = rs.getBoolean(6);
				Cab cab = new Cab(cabName, cabNumber2, driverName, phone, city, available);
				listCab.add(cab);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCab;

	}

	public void unRegisterCab(Cab cab) throws SQLException{
		String cabUnRegistrain="DELETE FROM CAB WHERE CAB_NUMBER='" + cab.getCabNumber() + "'";
		PreparedStatement prepareStatement = this.conn.prepareStatement(cabUnRegistrain);
		prepareStatement.execute();
		System.out.println("Cab Has Been Delete");
	}
	
	
	
	public static void main(String[] args) {
		Connection conn = ConnectionDB.connectionDb();
		Cab cab = new Cab("I 20", "HR 24 V 8650", "ANIL", Long.parseLong("9610107999"), "Delhi", true);
		CabDao cabDao = new CabDao(conn);
		try {
			/*cabDao.registerCab(cab);
			Cab myCab=cabDao.getCab("HR 24 V 8650");
			System.out.println(myCab);*/
			cabDao.unRegisterCab(cab);
		} catch (Exception e) {
		}

	}

}
