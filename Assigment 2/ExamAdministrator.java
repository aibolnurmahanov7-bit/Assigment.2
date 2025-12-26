public class ExamAdministrator extends User {
    private String department;
    private int examsCreated;

    public ExamAdministrator(int id, String name, String email, String department) {
        super(id, name, email);
        this.department = department;
        this.examsCreated = 0;
    }

    public String getDepartment() { return department; }
    public int getExamsCreated() { return examsCreated; }

    public void setDepartment(String department) { this.department = department; }

    public void incrementExamsCreated() { examsCreated++; }

    @Override
    public String getRole() {
        return "Exam Administrator";
    }

    @Override
    public String toString() {
        return super.toString() + ", department='" + department + "', examsCreated=" + examsCreated + "}";
    }
}
