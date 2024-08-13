package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.dbconnection;
import model.user;

public class userdao {
    public static void  inseruser(user u) {
    	try {
			
		Connection conn = dbconnection.createConnection();
    	String sql ="insert into user1(name,contact,address,email,password) values(?,?,?,?,?)";
    	PreparedStatement pst = conn.prepareStatement(sql);
    	pst.setString(1, u.getName());
    	pst.setLong(2, u.getContact());
    	pst.setString(3, u.getAddress());
    	pst.setString(4, u.getEmail());
    	pst.setString(5, u.getPassword());
    	pst.executeUpdate();
    	System.out.println("data inserted");
    	} catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    	
    	
    }
    public static user checkLogin(user u) {
    	user u1 = null;
    	try {
			Connection conn = dbconnection.createConnection();
			String sql ="select * from user1 where email=? and password=?";
			PreparedStatement pst= conn.prepareStatement(sql);
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			ResultSet rs =pst.executeQuery();
			if(rs.next()) {
				u1  =new user();
				u1.setId(rs.getInt("id"));
				u1.setName(rs.getString("name"));
				u1.setContact(rs.getLong("contact"));
				u1.setAddress(rs.getString("address"));
				u1.setEmail(rs.getString("email"));
				u1.setPassword(rs.getString("password"));
			}
			
			
    	} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return u1;
    	
    }
    public static List<user> getAlluser(){
    	List<user> list = new ArrayList<user>();
    	try {
			Connection conn = dbconnection.createConnection();
			String sql ="select * from user1";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				user u = new user();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setContact(rs.getLong("contact"));
				u.setAddress(rs.getString("address"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				list.add(u);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
    }
    public static user getUserById(int id) {
    	user u =null;
    	try {
			Connection conn = dbconnection.createConnection();
			String sql="select * from user1 where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				 u = new user();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setContact(rs.getLong("contact"));
				u.setAddress(rs.getString("address"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return u;
    }
    public static void updateuser(user u) {
    	try {
			Connection conn = dbconnection.createConnection();
			String sql = "update user1 set name=?,contact=?,address=?,email=?,password=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, u.getName());
	    	pst.setLong(2, u.getContact());
	    	pst.setString(3, u.getAddress());
	    	pst.setString(4, u.getEmail());
	    	pst.setString(5, u.getPassword());
		    pst.setInt(6, u.getId());
		    pst.executeUpdate();
		    System.out.println("data udated");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    public static void deleteUser(int id) {
    	try {
			Connection conn = dbconnection.createConnection();
			String sql ="delete from user1 where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("data delete");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    
   
}
