/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otomasyon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class otomasyon {
	static Connection connect;
	static Scanner scan = new Scanner(System.in);

	public static void menuogrenci(int numaran) {
		System.out.println("1-Ders Seçimi / 2-Not Görüntüle / 3-Şifre Değiştir /4- Çıkış");
		System.out.println("İşlem: ");
		int sec1 = scan.nextInt();
		switch (sec1) {
		case 1:
			ogrenci.dersgoster(connect);
			System.out.println("İki adet ders seçme hakkınız vardır.");
			scan.nextLine();
			System.out.println("Ders 1: ");
			String l1 = scan.nextLine();
			System.out.println("Ders 2: ");
			String l2 = scan.nextLine();
			ogrenci.derssec(connect, l1, l2, numaran);
			menuogrenci(numaran);
			break;
		case 2:
			ogrenci.notgor(connect, numaran);
			menuogrenci(numaran);
			break;
		case 3:
			scan.nextLine();
			System.out.println("Yeni Şifre: ");
			String ysifre = scan.nextLine();
			ogrenci.sifredegistir(connect, numaran, ysifre);
			menuogrenci(numaran);
			break;
		case 4:
			anamenu();
			break;
		}
	}

	public static void menumemur(int numaran6) {
		memur memur1 = new memur("Ali", "Özen", 214563, "memur");
		/*
		 * memur memur1 = new memur("Ali", "Özen", 214563, "memur"); String mmr =
		 * "insert into memur(name,surname,id,password) values(?,?,?,?)"; try { pst =
		 * connect.prepareStatement(mmr); pst.setString(1, "Ali"); pst.setString(2,
		 * "Özen"); pst.setInt(3, 214563); pst.setString(4, "memur"); pst.execute(); }
		 * catch (SQLException e) { e.printStackTrace(); }
		 */
		System.out.println("1-Öğrenci Ekle / 2-Yoklama Al / 3-Ders Programı Hazırlama / 4-Şifre Değiştir / 5-Ders Ekle / 6-Ders Sil / 7-Çıkış");
		System.out.println("İşlem: ");
		int sec3 = scan.nextInt();
		scan.nextLine();
		switch (sec3) {
		case 1:
			memur1.ogrencigoster(connect);
			System.out.println("Ad:");
			String Ad = scan.nextLine();
			System.out.println("Soyad:");
			String Soyad = scan.nextLine();
			System.out.println("Numara:");
			int numara = scan.nextInt();
			scan.nextLine();
			System.out.println("Geçici Parola:");
			String parola = scan.nextLine();
			memur1.ogrenciekle(connect, Ad, Soyad, memur1.kalangun, numara, parola);
			System.out.println("Öğrenci başarıyla eklendi.");
			menumemur(numaran6);
			break;
		case 2:
			memur1.ogrencigoster(connect);
			System.out.println("Devamsızlık yapan öğrencinin numarası: ");
			int num = scan.nextInt();
			memur1.yoklamaal(connect, memur1.kalangun, num);
			System.out.println(num + " numaralı öğrencinin devamsızlık hakkı 1 gün azaltıldı.");
			menumemur(numaran6);
			break;
		case 3:
			memur1.dersprogrami();
			menumemur(numaran6);
			break;
		case 4:
			System.out.println("Yeni Şifre: ");
			String ysifre1 = scan.nextLine();
			memur1.sifredegistir(connect, numaran6, ysifre1);
			menumemur(numaran6);
			break;
		case 5:
			memur1.dersgoster(connect);
			System.out.println("Ders Adı:");
			String dersad = scan.nextLine();
			System.out.println("Ders Numarası:");
			int dersnum = scan.nextInt();
			scan.nextLine();
			System.out.println("Dersi Veren Öğretmen Numarası:");
			int ogrnum = scan.nextInt();
			memur1.dersekle(connect, dersad, dersnum, ogrnum);
			System.out.println("Ders başarıyla eklendi.");
			menumemur(numaran6);
			break;
		case 6:
			memur1.dersgoster(connect);
			System.out.println("Silinecek Ders Numarası:");
			int dersnum1 = scan.nextInt();
			memur1.derssil(connect,dersnum1);
			System.out.println("Ders başarıyla silindi.");
			menumemur(numaran6);
			break;
		case 7:
			anamenu();
			break;
		}
	}

	public static void menumatogretmen(int numaran2) {
		matogretmen ogr1 = new matogretmen("Ali", "Demir", 978645, "12345");
		/*
		 * matogretmen ogr1 = new matogretmen("Ali", "Demir", 978645, "12345"); String
		 * ogrm =
		 * "insert into ogretmen(name,surname,id,password,brans) values(?,?,?,?,?)"; try
		 * { pst = connect.prepareStatement(ogrm); pst.setString(1, "Ali");
		 * pst.setString(2, "Demir"); pst.setInt(3, 978645); pst.setString(4, "12345");
		 * pst.setString(5, "Matematik"); pst.execute(); } catch (SQLException e) {
		 * e.printStackTrace(); }
		 */
		System.out.println("1-Not Gir / 2-Harf Notu Açıkla /3-Şifre Değiştir/ 4-Çıkış");
		System.out.println("İşlem: ");
		int sec = scan.nextInt();
		switch (sec) {
		case 1:
			ogr1.ogrencigoster(connect);
			System.out.println("Matematik notu girilecek öğrencinin numarası: ");
			int num = scan.nextInt();
			ogr1.notgir(connect, num);
			menumatogretmen(numaran2);
			break;
		case 2:
			ogr1.ogrencigoster(connect);
			System.out.println("Matematik harf notu açıklanacak öğrencinin numarası: ");
			int num2 = scan.nextInt();
			ogr1.harfnotu(connect, num2);
			menumatogretmen(numaran2);
			break;
		case 3:
			scan.nextLine();
			System.out.println("Yeni Şifre: ");
			String ysifre2 = scan.nextLine();
			ogr1.sifredegistir(connect, numaran2, ysifre2);
			menumatogretmen(numaran2);
			break;
		case 4:
			anamenu();
			break;
		}
	}

	public static void menuturkceogretmen(int numaran3) {
		turkceogretmen ogr2 = new turkceogretmen("Ali", "Demir", 978646, "1234");
		/*
		 * turkceogretmen ogr2 = new turkceogretmen("Ali", "Demir", 978646, "1234");
		 * String ogr =
		 * "insert into ogretmen(name,surname,id,password,brans) values(?,?,?,?,?)"; try
		 * { pst = connect.prepareStatement(ogr); pst.setString(1, "Ali");
		 * pst.setString(2, "Demir"); pst.setInt(3, 978646); pst.setString(4, "1234");
		 * pst.setString(5, "Türkçe"); pst.execute(); } catch (SQLException e) {
		 * e.printStackTrace(); }
		 */
		System.out.println("1-Not Gir /2-Harf Notu Açıkla /3-Şifre Değiştir /4-Çıkış");
		System.out.println("İşlem: ");
		int sec3 = scan.nextInt();
		switch (sec3) {
		case 1:
			ogr2.ogrencigoster(connect);
			System.out.println("Türkçe notu girilecek öğrencinin numarası: ");
			int num = scan.nextInt();
			ogr2.notgir(connect, num);
			menuturkceogretmen(numaran3);
			break;
		case 2:
			ogr2.ogrencigoster(connect);
			System.out.println("Türkçe harf notu açıklanacak öğrencinin numarası: ");
			int num3 = scan.nextInt();
			ogr2.harfnotu(connect, num3);
			menuturkceogretmen(numaran3);
			break;
		case 3:
			scan.nextLine();
			System.out.println("Yeni Şifre: ");
			String ysifre3 = scan.nextLine();
			ogr2.sifredegistir(connect, numaran3, ysifre3);
			menuturkceogretmen(numaran3);
			break;
		case 4:
			anamenu();
			break;
		}
	}

	public static void menuingogretmen(int numaran4) {
		ingogretmen ogr3 = new ingogretmen("Ali", "Demir", 978647, "123");
		/*
		 * ingogretmen ogr3 = new ingogretmen("Ali", "Demir", 978647, "123"); String og
		 * = "insert into ogretmen(name,surname,id,password,brans) values(?,?,?,?,?)";
		 * try { pst = connect.prepareStatement(og); pst.setString(1, "Ali");
		 * pst.setString(2, "Demir"); pst.setInt(3, 978647); pst.setString(4, "123");
		 * pst.setString(5, "İngilizce"); pst.execute(); } catch (SQLException e) {
		 * e.printStackTrace(); }
		 */
		System.out.println("1-Not Gir / 2-Harf Notu Açıkla /3-Şifre Değiştir /4-Çıkış");
		System.out.println("İşlem: ");
		int sec4 = scan.nextInt();
		switch (sec4) {
		case 1:
			ogr3.ogrencigoster(connect);
			System.out.println("İngilizce notu girilecek öğrencinin numarası: ");
			int num = scan.nextInt();
			ogr3.notgir(connect, num);
			menuingogretmen(numaran4);
			break;
		case 2:
			ogr3.ogrencigoster(connect);
			System.out.println("İngilizce harf notu açıklanacak öğrencinin numarası: ");
			int num4 = scan.nextInt();
			ogr3.harfnotu(connect, num4);
			menuingogretmen(numaran4);
			break;
		case 3:
			scan.nextLine();
			System.out.println("Yeni Şifre: ");
			String ysifre4 = scan.nextLine();
			ogr3.sifredegistir(connect, numaran4, ysifre4);
			menuingogretmen(numaran4);
			break;
		case 4:
			anamenu();
			break;
		}
	}

	public static void anamenu() {
		System.out.println("1-Öğrenci / 2-Öğretim Üyesi / 3-İdari Memur ");
		System.out.println("Giriş Türü: ");
		int giris = scan.nextInt();
		while (giris < 4) {
			switch (giris) {
			// Öğrenci kısmı
			case 1:
				System.out.println("Öğrenci Numarası: ");
				int numaran = scan.nextInt();
				scan.nextLine();
				System.out.println("Parola: ");
				String parolan = scan.nextLine();
				PreparedStatement pst;
				try {
					pst = connect.prepareStatement("select * from ogrenci");
					ResultSet res = pst.executeQuery();
					while (res.next()) {
						String adin = res.getString("name");
						String soyadin = res.getString("surname");
						String sifren = res.getString("password");
						int non = res.getInt("id");
						if (non == numaran && sifren.equalsIgnoreCase(parolan)) {
							System.out.println("Hoşgeldin " + adin + " " + soyadin);
							menuogrenci(numaran);
						}
					}
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;

			// öğretmen kısmı
			case 2:
				System.out.println("1-Matematik Öğretmeni / 2-Türkçe Öğretmeni / 3-İngilizce Öğretmeni");
				System.out.println("İşlem: ");
				int sec2 = scan.nextInt();
				switch (sec2) {
				case 1:
					System.out.println("Öğretmen Numarası: ");
					int numaran2 = scan.nextInt();
					scan.nextLine();
					System.out.println("Parola: ");
					String parolan2 = scan.nextLine();
					PreparedStatement pst2;
					try {
						pst2 = connect.prepareStatement("select * from ogretmen");
						ResultSet res = pst2.executeQuery();
						while (res.next()) {
							String adin = res.getString("name");
							String soyadin = res.getString("surname");
							String sifren = res.getString("password");
							String gorev = res.getString("brans");
							int non = res.getInt("id");
							if (non == numaran2 && sifren.equalsIgnoreCase(parolan2)
									&& gorev.equalsIgnoreCase("matematik")) {
								System.out.println("Hoşgeldin " + adin + " " + soyadin);
								menumatogretmen(numaran2);

							}
						}
						pst2.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;

				case 2:

					System.out.println("Öğretmen Numarası: ");
					int numaran3 = scan.nextInt();
					scan.nextLine();
					System.out.println("Parola: ");
					String parolan3 = scan.nextLine();
					PreparedStatement pst3;
					try {
						pst3 = connect.prepareStatement("select * from ogretmen");
						ResultSet res = pst3.executeQuery();
						while (res.next()) {
							String adin = res.getString("name");
							String soyadin = res.getString("surname");
							String sifren = res.getString("password");
							String gorev = res.getString("brans");
							int non = res.getInt("id");
							if (non == numaran3 && sifren.equalsIgnoreCase(parolan3)
									&& gorev.equalsIgnoreCase("türkçe")) {
								System.out.println("Hoşgeldin " + adin + " " + soyadin);
								menuturkceogretmen(numaran3);

							}
						}
						pst3.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;

				case 3:
					System.out.println("Öğretmen Numarası: ");
					int numaran4 = scan.nextInt();
					scan.nextLine();
					System.out.println("Parola: ");
					String parolan4 = scan.nextLine();
					PreparedStatement pst4;
					try {
						pst4 = connect.prepareStatement("select * from ogretmen");
						ResultSet res = pst4.executeQuery();
						while (res.next()) {
							String adin = res.getString("name");
							String soyadin = res.getString("surname");
							String sifren = res.getString("password");
							String gorev = res.getString("brans");
							int non = res.getInt("id");
							if (non == numaran4 && sifren.equalsIgnoreCase(parolan4)
									&& gorev.equalsIgnoreCase("ingilizce")) {
								System.out.println("Hoşgeldin " + adin + " " + soyadin);
								menuingogretmen(numaran4);

							}
						}
						pst4.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;

				}
				break;

			// Memur kısmı
			case 3:
				System.out.println("Memur Numarası: ");
				int numaran6 = scan.nextInt();
				scan.nextLine();
				System.out.println("Parola: ");
				String parolan6 = scan.nextLine();
				PreparedStatement pst3;
				try {
					pst3 = connect.prepareStatement("select * from memur");
					ResultSet res = pst3.executeQuery();
					while (res.next()) {
						String adin = res.getString("name");
						String soyadin = res.getString("surname");
						String sifren = res.getString("password");
						int non = res.getInt("id");
						if (non == numaran6 && sifren.equalsIgnoreCase(parolan6)) {
							System.out.println("Hoşgeldin " + adin + " " + soyadin);
							menumemur(numaran6);
						}
					}
					pst3.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;

			}

		}
	}

	public static void main(String[] args) {
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/aksis", "root", "");
			connect.createStatement();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		anamenu();
	}
}
