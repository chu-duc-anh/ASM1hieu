package StudentManagement;

public class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        if (marks >= 9.0) return "Excellent";
        else if (marks >= 7.5) return "Very Good";
        else if (marks >= 6.5) return "Good";
        else if (marks >= 5.0) return "Medium";
        else return "Fail";
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks + ", Rank: " + getRank();
    }
}
