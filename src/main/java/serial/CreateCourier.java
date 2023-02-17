package serial;

public class CreateCourier {
    private String login;
    private String password;
    private String firstName;
    private Integer id;

    public CreateCourier(String name, String password, String firstName) {
        this.login = name;
        this.password = password;
        this.firstName = firstName;
    }

    public CreateCourier() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String name) {
        this.login = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}