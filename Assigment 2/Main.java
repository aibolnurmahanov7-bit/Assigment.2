import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ONLINE EXAMINATION SYSTEM - ASSIGNMENT 2 ===\n");

        System.out.println("1. Creating users (inheritance demonstration):");
        Candidate candidate1 = new Candidate(101, "Ivan Petrov", "ivan@example.com", "Java");
        Candidate candidate2 = new Candidate(102, "Maria Ivanova", "maria@example.com", "Python");
        Candidate candidate3 = new Candidate(103, "Alexey Smirnov", "alex@example.com", "Java");

        ExamAdministrator admin = new ExamAdministrator(201, "Dr. Smith", "smith@university.edu", "Computer Science");

        User[] users = {candidate1, candidate2, candidate3, admin};
        for (User user : users) {
            System.out.println("  " + user.getRole() + ": " + user.getName());
        }

        System.out.println("\n2. Creating exam with questions:");
        Exam javaExam = new Exam(1, "Java Programming Exam", "Programming");

        Question q1 = new Question(1, "What is the size of int in Java?",
                new String[]{"8 bits", "16 bits", "32 bits", "64 bits"}, 2, "Data Types", 1);
        Question q2 = new Question(2, "Which keyword is used for inheritance?",
                new String[]{"extends", "inherits", "implements", "super"}, 0, "OOP", 2);
        Question q3 = new Question(3, "What is the default value of boolean?",
                new String[]{"true", "false", "0", "null"}, 1, "Data Types", 1);
        Question q4 = new Question(4, "What is polymorphism in OOP?",
                new String[]{"One name, many forms", "Data hiding", "Inheritance", "Encapsulation"}, 0, "OOP", 3);

        javaExam.addQuestion(q1);
        javaExam.addQuestion(q2);
        javaExam.addQuestion(q3);
        javaExam.addQuestion(q4);

        javaExam.addCandidate(candidate1);
        javaExam.addCandidate(candidate2);
        javaExam.addCandidate(candidate3);

        candidate1.setScore(85);
        candidate2.setScore(92);
        candidate3.setScore(78);

        System.out.println("\n3. toString() demonstration:");
        System.out.println("  " + candidate1);
        System.out.println("  " + admin);
        System.out.println("  " + javaExam);

        System.out.println("\n4. equals() and hashCode() demonstration:");
        Candidate candidate1Copy = new Candidate(101, "Ivan Petrov", "ivan@example.com", "Java");
        System.out.println("  candidate1.equals(candidate1Copy): " + candidate1.equals(candidate1Copy));
        System.out.println("  candidate1.hashCode() == candidate1Copy.hashCode(): " +
                (candidate1.hashCode() == candidate1Copy.hashCode()));

        System.out.println("\n5. Data operations (filtering, searching, sorting):");

        List<Candidate> highScorers = javaExam.filterCandidatesByMinScore(80);
        System.out.println("  Candidates with score >= 80: " + highScorers.size());

        List<Question> oopQuestions = javaExam.searchQuestionsByKeyword("OOP");
        System.out.println("  Questions about OOP: " + oopQuestions.size());

        List<Candidate> sortedCandidates = javaExam.getCandidatesSortedByScore();
        System.out.println("  Candidates sorted by score (descending):");
        for (Candidate c : sortedCandidates) {
            System.out.println("    " + c.getName() + ": " + c.getScore() + " points");
        }

        List<Question> sortedQuestions = javaExam.getQuestionsSortedById();
        System.out.println("  Questions sorted by ID: " + sortedQuestions.size() + " questions");

        System.out.println("\n6. Exam statistics:");
        System.out.println("  Total candidates: " + javaExam.getTotalCandidates());
        System.out.println("  Total questions: " + javaExam.getTotalQuestions());
        System.out.println("  Average score: " + javaExam.getAverageScore());

        System.out.println("\n7. Polymorphism demonstration:");
        for (User user : users) {
            System.out.println("  " + user.getName() + " is a " + user.getRole());
        }
    }
}