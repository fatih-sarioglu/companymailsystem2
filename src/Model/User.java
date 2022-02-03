package Model;

import Helper.DbConnection;

public class User {
    private String name, address, type, password;
    private int id;

    DbConnection conn = new DbConnection();
    
    public User(String name, String address, String type, int id, String password) {
        this.name = name;
        this.address = address;
        this.type = type;
        this.id = id;
        this.password = password;
    }

    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
