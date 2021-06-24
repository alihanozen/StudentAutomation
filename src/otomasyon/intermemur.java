package otomasyon;

import java.sql.Connection;

public interface intermemur {
	public static void ogrenciekle(Connection con, String name, String surname, int kalangun, int id, String password){}
	public static void yoklamaal(Connection con, int kalangun, int id){}
	public void dersprogrami();
	public static void ogrencigoster(Connection con){}
}
