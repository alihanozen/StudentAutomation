package otomasyon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ogrenci extends insan implements interogrenci,ortak {

	public ogrenci(String name, String surname, int id, String password) {
		super(name, surname, id, password);
	}
	@Override
	public void setPassword(String password) {
		super.setPassword(password);
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}
	
	public static void dersgoster(Connection con) {
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("select * from dersler");
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				int no = res.getInt("id");
				String adi = res.getString("dersadi");
				if (no != 0) {
					System.out.println(adi + " " + no);
				}
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void sifredegistir(Connection con, int id, String password){
		PreparedStatement pst;
		try {
			pst=con.prepareStatement("update ogrenci set password = ? where id = ?");
			pst.setString(1, password);
			pst.setInt(2, id);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
    }
	
	public static void derssec(Connection con, String ders1 ,String ders2, int id){
		PreparedStatement pst;
		try {
			pst=con.prepareStatement("update ogrenci set ders1= ?, ders2 = ? where id = ?");
			pst.setString(1, ders1);
			pst.setString(2, ders2);
			pst.setInt(3, id);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
    }
	
	public static void notgor(Connection con,int id){
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("select * from ogrenci where id = ?");
			pst.setInt(1, id);

			ResultSet result =pst.executeQuery();
			while(result.next()){
				String as = result.getString("ders1");
				String bs = result.getString("ders2");
				float a = result.getFloat("not1");
				float b = result.getFloat("not2");
				System.out.println(as + ":" + a + "//" + bs + ":" + b);
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
   }
}