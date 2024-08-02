package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.snap;

public class snapservices {
	
	private Connection conn;

	public snapservices(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addingsnap(snap s) {
		boolean f=false;
		try {
			String sql="insert into snap(name, email, password, conformpassword) values(?,?,?,?)";
			
			PreparedStatement pmst=conn.prepareStatement(sql);
			
			pmst.setString(1, s.getName());
			pmst.setString(2, s.getEmail());
			pmst.setString(3, s.getPassword());
			pmst.setString(4, s.getConformpassword());
			
			int i=pmst.executeUpdate();
			
			if(i>0) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<snap> getall(){
		List<snap> ll=new ArrayList<snap>();
		snap sn=null;
		try {
			String sql = "select * from snap";
			PreparedStatement pmst = conn.prepareStatement(sql);
			ResultSet rs = pmst.executeQuery();
			while (rs.next()) {
				sn=new snap();
				sn.setId(rs.getInt(1));
				sn.setName(rs.getString(2));
				sn.setEmail(rs.getString(3));
				sn.setPassword(rs.getString(4));
				sn.setConformpassword(rs.getString(5));
				ll.add(sn);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ll;
	}
	
	public snap getbyId(int id) {
		snap sn=null;
		try {
			String sql = "select * from snap where id= ?";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setInt(1, id);
			ResultSet rs = pmst.executeQuery();
			while(rs.next()) {
				sn=new snap();
					sn.setId(rs.getInt(1));
					sn.setName(rs.getString(2));
					sn.setEmail(rs.getString(3));
					sn.setPassword(rs.getString(4));
					sn.setConformpassword(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sn;
	}

	public boolean deletebyId(int id) {
		boolean f =false;
		try {
			String sql="delete from snap where id=?";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setInt(1, id);
			int i =pmst.executeUpdate();
			if (i>0) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean deletebyEmail(String email) {
		boolean f=false;
		try {
			String sql="delete from snap where email=?";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setString(1, email);
			int i = pmst.executeUpdate();
			if(i>0) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean updatesnap(snap s) {
		boolean f=false;
		try {
			String sql="update snap set name=?, emai=?, password=?,conformpassword=? where id=?";
			PreparedStatement pmst =conn.prepareStatement(sql);
			pmst.setString(1, s.getName());
			pmst.setString(2, s.getEmail());
			pmst.setString(3, s.getPassword());
			pmst.setString(4, s.getConformpassword());
			pmst.setInt(5, s.getId());
			int i=pmst.executeUpdate();
			if(i>0) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}


