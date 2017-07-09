package com.orangehrm.data;

public class User {

    private UserRole role;
    private String employeeName;
    private String username;
    private String name;
    private String password;
    private Status status;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getStatus() {
        return status.value();
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getUserRole(){
        return role.value();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName(){
        return name;
    }


    public User(UserRole role, String username, String password, String name, String employeeName) {
        this.role = role;
        this.username = username;
        this.password = password;
        this.name = name;
        this.employeeName = employeeName;
        this.status = Status.ENABLED;
    }

    public User(UserRole role){
        if (role.equals(UserRole.ADMIN)) {
            setUsername("Admin");
            setPassword("admin");
            setName("Admin");
            setRole(role);
            setStatus(Status.ENABLED);
        }else if(role.equals(UserRole.ESS)) {
            FakerData data = new FakerData();
            String name = data.getNameFaker();
            String password = data.getPasswordFaker();
            setUsername(name);
            setName(name);
            setEmployeeName("dummy name");
            setPassword(password);
            setRole(role);
            setStatus(Status.ENABLED);
                }
            }

    @Override
    public String toString() {
        return "User{" +
                "role=" + role +
                ", employeeName='" + employeeName + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}






