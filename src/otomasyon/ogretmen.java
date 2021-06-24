package otomasyon;

public abstract class ogretmen extends insan{
	String brans;
	public ogretmen(String name, String surname, int id, String password) {
		super(name, surname, id, password);
	}
	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}
}
