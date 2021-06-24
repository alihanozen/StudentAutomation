package otomasyon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Scanner;

public class memur extends insan implements intermemur, ortak {
	public memur(String name, String surname, int id, String password) {
		super(name, surname, id, password);
	}

	Connection con;
	Scanner scan = new Scanner(System.in);
	static int kalangun = 30;

	@Override
	public void setPassword(String password) {
		super.setPassword(password);
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	public static void sifredegistir(Connection con, int id, String password) {
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("update memur set password = ? where id = ?");
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
				if (no != 0) {
					System.out.println(adi + " " + soyadi + " " + no);
				} else {
					System.out.println("Kayıtlı öğrenci bulunamadı.");
				}
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void ogrenciekle(Connection con, String name, String surname, int kalangun, int id, String password) {
		String b = "insert into ogrenci(name,surname,kalangun,id,password) values(?,?,?,?,?)";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(b);
			pst.setString(1, name);
			pst.setString(2, surname);
			pst.setInt(3, kalangun);
			pst.setInt(4, id);
			pst.setString(5, password);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	
	public static void dersekle(Connection con, String dersadi,int id, int ogretmen) {
		String a = "insert into dersler(dersadi,id,ogretmen) values(?,?,?)";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(a);
			pst.setString(1, dersadi);
			pst.setInt(2, id);
			pst.setInt(3, ogretmen);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void derssil(Connection con, int id) {
		String c = "delete from dersler where id = ?";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(c);;
			pst.setInt(1, id);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void yoklamaal(Connection con, int kalangun, int id) {
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("select * from ogrenci where id = ?");
			pst.setInt(1, id);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				int gun = res.getInt("kalangun");
				gun = gun - 1;
				pst = con.prepareStatement("update ogrenci set kalangun= ? where id = ?");
				pst.setInt(1, gun);
				pst.setInt(2, id);
				pst.execute();
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void dersprogrami() {
		String d1 = "Matematik";
		String d2 = "İngilizce";
		String d3 = "Türkçe";
		System.out.println(d1 + " için gün giriniz:");
		String day1 = scan.nextLine();
		System.out.println(day1 + " günü için başlangıç saati giriniz:");
		float time1 = scan.nextFloat();
		System.out.println(day1 + " günü için bitiş saati giriniz:");
		float time2 = scan.nextFloat();

		scan.nextLine();
		System.out.println(d2 + " için gün giriniz:");
		String day2 = scan.nextLine();
		System.out.println(day2 + " günü için başlangıç saati giriniz:");
		float time3 = scan.nextFloat();
		System.out.println(day2 + " günüiçin bitiş saati giriniz:");
		float time4 = scan.nextFloat();

		scan.nextLine();
		System.out.println(d3 + " için gün giriniz:");
		String day3 = scan.nextLine();
		System.out.println(day3 + " günü için başlangıç saati giriniz:");
		float time5 = scan.nextFloat();
		System.out.println(day3 + " günü için bitiş saati giriniz:");
		float time6 = scan.nextFloat();

		if ((day1.equalsIgnoreCase(day2) && ((time3 >= time1 && time3 <= time2) || (time4 >= time1 && time4 <= time2)))
				|| (time4 <= time3 || time2 <= time1)) {
			System.out.println("Girilen zaman aralıkları uygun değil. Ders programı oluşturulamadı.");
		} else if ((day1.equalsIgnoreCase(day3)
				&& ((time5 >= time1 && time5 <= time2) || (time6 >= time1 && time6 <= time2)))
				|| (time6 <= time5 || time2 <= time1)) {
			System.out.println("Girilen zaman aralıkları uygun değil. Ders programı oluşturulamadı.");
		} else if ((day2.equalsIgnoreCase(day3)
				&& ((time3 >= time5 && time3 <= time6) || (time4 >= time5 && time4 <= time6)))
				|| (time4 <= time3 || time6 <= time5)) {
			System.out.println("Girilen zaman aralıkları uygun değil. Ders programı oluşturulamadı.");
		} else {
			System.out.println("Program:");
			System.out.println(d1 + ":" + day1 + "/" + time1 + "-" + time2);
			System.out.println(d2 + ":" + day2 + "/" + time3 + "-" + time4);
			System.out.println(d3 + ":" + day3 + "/" + time5 + "-" + time6);
		}
	}
}
