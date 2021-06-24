package otomasyon;

public abstract class insan {
	String name;
    String surname;
    int id;
    private String password;

    public insan(String name, String surname, int id, String password) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.password = password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
