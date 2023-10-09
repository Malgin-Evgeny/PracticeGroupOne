package api.getRequest;

public class UsersData {
    private int id;
    private String state;
    private String role;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String phone;
    private String email;
    private String login;
    private String parentName;
    private String parentPhone;
    private String age;
    private String gender;
    private String costType;
    private String currencyType;

    public UsersData() {
    }

    public UsersData(int id, String state, String role, String firstName, String lastName, String patronymic, String phone, String email, String login, String parentName, String parentPhone, String age, String gender, String costType, String currencyType) {
        this.id = id;
        this.state = state;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.phone = phone;
        this.email = email;
        this.login = login;
        this.parentName = parentName;
        this.parentPhone = parentPhone;
        this.age = age;
        this.gender = gender;
        this.costType = costType;
        this.currencyType = currencyType;
    }

    public int getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public String getRole() {
        return role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getParentName() {
        return parentName;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getCostType() {
        return costType;
    }

    public String getCurrencyType() {
        return currencyType;
    }
}
