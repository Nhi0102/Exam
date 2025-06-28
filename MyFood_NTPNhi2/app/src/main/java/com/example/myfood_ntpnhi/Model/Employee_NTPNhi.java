package com.example.myfood_ntpnhi.Model;



public class Employee_NTPNhi {
    private int id;
    private String username;
    private String password;

    public Employee_NTPNhi() {}

    public Employee_NTPNhi(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter - Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
