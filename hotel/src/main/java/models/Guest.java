package models;

public class Guest {
    private int id = 0;
    private String lastName;

    public Guest(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "lastName='" + lastName + '\'' +
                '}';
    }
}
