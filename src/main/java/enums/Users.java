package enums;

public enum Users {

    PITERCHAILOVSKII("epam", "1234", "PITER CHAILOVSKII");

    private String name;
    private String password;
    private String userName;

    Users(String name, String password, String userName) {
        this.name = name;
        this.password = password;
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}
