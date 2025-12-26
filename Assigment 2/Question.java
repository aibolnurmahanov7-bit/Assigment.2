import java.util.Arrays;
import java.util.Objects;

public class Question {
    private int id;
    private String text;
    private String[] options;
    private int correctOptionIndex;
    private String category;
    private int difficulty; // 1-легко, 2-средне, 3-сложно

    public Question(int id, String text, String[] options, int correctOptionIndex, String category, int difficulty) {
        this.id = id;
        this.text = text;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
        this.category = category;
        this.difficulty = difficulty;
    }

    public int getId() { return id; }
    public String getText() { return text; }
    public String[] getOptions() { return options; }
    public int getCorrectOptionIndex() { return correctOptionIndex; }
    public String getCategory() { return category; }
    public int getDifficulty() { return difficulty; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id == question.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Question{id=" + id + ", text='" + text.substring(0, Math.min(20, text.length())) + "...', " +
                "category='" + category + "', difficulty=" + difficulty + "}";
    }
}
