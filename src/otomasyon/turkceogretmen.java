package otomasyon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class turkceogretmen extends ogretmen implements interogretmen,ortak {
	Connection con;
	static Scanner scan = new Scanner(System.in);

	public turkceogretmen(String name, String surname, int id, String password) {
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

	public static void sifredegistir(Connection con, int id, String password){
		PreparedStatement pst;
		try {
			pst=con.prepareStatement("update ogretmen set password = ? where id = ?");
			pst.setString(1, password);
			pst.setInt(2, id);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
    }

	
	public static void ogrencigoster(Connection con) {
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("select * from ogrenci");
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				int no = res.getInt("id");
				String adi = res.getString("name");
				String soyadi = res.getString("surname");
				String d1 = res.getString("ders1");
				String d2 = res.getString("ders2");
				if (d1.equalsIgnoreCase("türkçe")) {
					System.out.println(adi + " " + soyadi + " " + no + " " + d1);
				}
				if (d2.equalsIgnoreCase("türkçe")) {
					System.out.println(adi + " " + soyadi + " " + no + " " + d2);
				}
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void notgir(Connection con, int id) {
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("select * from ogrenci where id = ?");
			pst.setInt(1, id);

			ResultSet res = pst.executeQuery();
			while (res.next()) {
				String as = res.getString("ders1");
				String bs = res.getString("ders2");
				float a;
				if (as.equalsIgnoreCase("türkçe")) {
					System.out.println("Türkçe Notu: ");
					a = scan.nextFloat();
					pst = con.prepareStatement("update ogrenci set not1= ? where id = ?");
					pst.setFloat(1, a);
					pst.setInt(2, id);
					pst.execute();
				}
				if (bs.equalsIgnoreCase("türkçe")) {
					System.out.println("Türkçe Notu: ");
					a = scan.nextFloat();
					pst = con.prepareStatement("update ogrenci set not2= ? where id = ?");
					pst.setFloat(1, a);
					pst.setInt(2, id);
					pst.execute();
				}
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void harfnotu(Connection con, int id) {
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("select * from ogrenci where id = ?");
			pst.setInt(1, id);

			ResultSet res = pst.executeQuery();
			while (res.next()) {
				String as = res.getString("ders1");
				String bs = res.getString("ders2");
				if (as.equalsIgnoreCase("türkçe")) {
					float not1 = res.getFloat("not1");
					pst = con.prepareStatement("update ogrenci set harfnotu= ? where id = ?");
					if (not1 < 35) {
						String a = "F";
						pst.setString(1, a);
					}
					if (not1 >= 35 && not1 < 50) {
						String a = "D";
						pst.setString(1, a);
					}
					if (not1 >= 50 && not1 < 70) {
						String a = "C";
						pst.setString(1, a);
					}
					if (not1 >= 70 && not1 < 85) {
						String a = "B";
						pst.setString(1, a);
					}
					if (not1 >= 85 && not1 <= 100) {
						String a = "A";
						pst.setString(1, a);
					}
					pst.setInt(2, id);
					pst.execute();
				}
				if (bs.equalsIgnoreCase("türkçe")) {
					float not1 = res.getFloat("not2");
					pst = con.prepareStatement("update ogrenci set harfnotu2 = ? where id = ?");
					if (not1 < 35) {
						String a = "F";
						pst.setString(1, a);
					}
					if (not1 >= 35 && not1 < 50) {
						String a = "D";
						pst.setString(1, a);
					}
					if (not1 >= 50 && not1 < 70) {
						String a = "C";
						pst.setString(1, a);
					}
					if (not1 >= 70 && not1 < 85) {
						String a = "B";
						pst.setString(1, a);
					}
					if (not1 >= 85 && not1 <= 100) {
						String a = "A";
						pst.setString(1, a);
					}
					pst.setInt(2, id);
					pst.execute();
				} 
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
