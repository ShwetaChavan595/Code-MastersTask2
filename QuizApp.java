import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String text;
    private List<String> options;
    private int correctAnswerIndex;

    public Question(String text, List<String> options, int correctAnswerIndex) {
        this.text = text;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getText() {
        return text;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", List.of("London", "Berlin", "Paris", "Madrid"), 2));
        questions.add(new Question("Which planet is known as the Red Planet?", List.of("Venus", "Mars", "Jupiter", "Saturn"), 1));
        questions.add(new Question("What is the largest mammal in the world?", List.of("Elephant", "Giraffe", "Blue Whale", "Lion"), 2));

        int score = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.getText());

            List<String> options = question.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }

            System.out.print("Your answer (1-" + options.size() + "): ");
            int userAnswer = scanner.nextInt();

            if (userAnswer - 1 == question.getCorrectAnswerIndex()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong. The correct answer is: " + options.get(question.getCorrectAnswerIndex()) + "\n");
            }
        }

        System.out.println("Quiz completed! Your score: " + score + " out of " + questions.size());
    }
}
