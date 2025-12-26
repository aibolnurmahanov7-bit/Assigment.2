import java.util.Objects;

public class Candidate extends User {
    private int score;
    private String specialization;

    public Candidate(int id, String name, String email, String specialization) {
        super(id, name, email);
        this.specialization = specialization;
        this.score = 0;
    }

    public int getScore() { return score; }
    public String getSpecialization() { return specialization; }

    public void setScore(int score) { this.score = score; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public void incrementScore() { score++; }
    public void resetScore() { score = 0; }

    @Override
    public String getRole() {
        return "Candidate";
    }

    @Override
    public String toString() {
        return super.toString() + ", specialization='" + specialization + "', score=" + score + "}";
    }
}