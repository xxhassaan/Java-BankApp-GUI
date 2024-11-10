public class Person {
    private String name;
    private String tel;
    private String dob;  // Added dob field

    // Constructor
    public Person(String name, String tel, String dob) {
        this.name = name;
        this.tel = tel;
        this.dob = dob;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDob() {
        return dob;  // Added getter for dob
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone: " + tel + "\nDOB: " + dob;
    }
}
