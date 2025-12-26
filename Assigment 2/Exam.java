import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Exam {
    private int examId;
    private String examName;
    private List<Question> questions;
    private List<Candidate> candidates;
    private String category;

    public Exam(int examId, String examName, String category) {
        this.examId = examId;
        this.examName = examName;
        this.category = category;
        this.questions = new ArrayList<>();
        this.candidates = new ArrayList<>();
    }

    public int getExamId() { return examId; }
    public String getExamName() { return examName; }
    public String getCategory() { return category; }
    public List<Question> getQuestions() { return questions; }
    public List<Candidate> getCandidates() { return candidates; }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    public List<Candidate> filterCandidatesByMinScore(int minScore) {
        return candidates.stream()
                .filter(c -> c.getScore() >= minScore)
                .collect(Collectors.toList());
    }

    public List<Question> searchQuestionsByKeyword(String keyword) {
        return questions.stream()
                .filter(q -> q.getText().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Candidate> getCandidatesSortedByScore() {
        List<Candidate> sorted = new ArrayList<>(candidates);
        sorted.sort(Comparator.comparingInt(Candidate::getScore).reversed());
        return sorted;
    }

    public List<Question> getQuestionsSortedById() {
        List<Question> sorted = new ArrayList<>(questions);
        sorted.sort(Comparator.comparingInt(Question::getId));
        return sorted;
    }

    public int getTotalCandidates() { return candidates.size(); }
    public int getTotalQuestions() { return questions.size(); }
    public double getAverageScore() {
        if (candidates.isEmpty()) return 0;
        return candidates.stream()
                .mapToInt(Candidate::getScore)
                .average()
                .orElse(0);
    }

    @Override
    public String toString() {
        return "Exam{id=" + examId + ", name='" + examName + "', category='" + category +
                "', questions=" + questions.size() + ", candidates=" + candidates.size() + "}";
    }
}