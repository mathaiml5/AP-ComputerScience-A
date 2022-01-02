import java.util.Objects;

/**
 * class StudentRecord is the basic class that has methods to read scores and populate grades for each record.
 *
 * @author Vishak Srikanth
 * @version 10/6/20
 *
 * This class creates and stores relevant data for a student record object read from input data for student name,
 * scores in 3 quizzes (each 10 points) midterm (100 points) and final (100 points)
 * The overall score is calculated using a weighted average (final exam counts for 40% of the grade, midterm counts for
 * 35% of the grade, 3 quizzes together count for a total of 25% of the grade) and final grade is computed based on:
 * Any grade of 90 or more is an A,
 * any grade of 80 or more (but less than 90) is a B,
 * any grade of 70 or more (but less than 80) is a C,
 * any grade of 60 or more (but less than 70) is a D, and
 * any grade below 60 is an F.
 */
public class StudentRecord
{
    //raw scores are stored as double in order to allow teachers to give half points
    //if teacher chooses to give partial credit via half points
    private String name;
    private double quiz_1_percent;
    private double quiz_1_grade_raw_score;
    private double quiz_2_percent;
    private double quiz_2_grade_raw_score;
    private double quiz_3_percent;
    private double quiz_3_grade_raw_score;
    private double average_quiz_percent;
    // Midterm
    private double midterm_percent;
    private double midterm_raw_score;
    // Final
    private double final_percent;
    private double final_raw_score;
    //Overall
    private double percent_grade_overall;
    private char letter_grade= 'F';

    /** Set Methods for Student Name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method gets the student's name.
     * @param: none
     * @return: name: the student's name
     */
    public String getName() {
        return name;
    }

    /** This method gets the student's Quiz 1 percentage score
     *
     * @return: quiz_1_percent: Percentage scrore in Quiz 1
     */
    public double getQuiz_1_percent() {
        return quiz_1_percent;
    }

    /** This method sets the student's Quiz 1 percentage score
     *
     * @param quiz_1_percent
     */
    public void setQuiz_1_percent(double quiz_1_percent) {
        this.quiz_1_percent = quiz_1_percent;
    }

    /** This method gets the student's Quiz 1 raw score
     *
     * @return: quiz_1_grade_raw_score: Quiz 1 Raw score
     */
    public double getQuiz_1_grade_raw_score() {
        return quiz_1_grade_raw_score;
    }

    /** This method sets the student's Quiz 1 raw score
     *
     * @param quiz_1_grade_raw_score
     */
    public void setQuiz_1_grade_raw_score(double quiz_1_grade_raw_score) {
        this.quiz_1_grade_raw_score = quiz_1_grade_raw_score;
    }

    /** This method gets the student's Quiz 2 percentage score
     *
     * @return: quiz_2_percent: Percentage score in Quiz 2
     */
    public double getQuiz_2_percent() {
        return quiz_2_percent;
    }

    /** This method sets the student's Quiz 2 percentage score
     *
     *
     * @param quiz_2_percent
     */
    public void setQuiz_2_percent(double quiz_2_percent) {
        this.quiz_2_percent = quiz_2_percent;
    }

    /** This method gets the student's Quiz 2 raw score
     *
     * @return quiz_2_grade_raw_score: Raw score in Quiz 2
     */
    public double getQuiz_2_grade_raw_score() {
        return quiz_2_grade_raw_score;
    }

    /** This method sets the student's Quiz 2 raw score
     *
     * @param quiz_2_grade_raw_score
     */
    public void setQuiz_2_grade_raw_score(double quiz_2_grade_raw_score) {
        this.quiz_2_grade_raw_score = quiz_2_grade_raw_score;
    }

    /** This method gets the student's Quiz 3 percentage score
     *
     * @return
     */
    public double getQuiz_3_percent() {
        return quiz_3_percent;
    }

    /** This method gets the student's Quiz 2 percentage score
     *
     * @param quiz_3_percent
     */
    public void setQuiz_3_percent(double quiz_3_percent) {
        this.quiz_3_percent = quiz_3_percent;
    }

    /** This method gets the student's Quiz 3 raw score
     *
     * @return
     */
    public double getQuiz_3_grade_raw_score() {
        return quiz_3_grade_raw_score;
    }

    /** This method sets the student's Quiz 3 raw score
     *
     * @param quiz_3_grade_raw_score
     */
    public void setQuiz_3_grade_raw_score(double quiz_3_grade_raw_score) {
        this.quiz_3_grade_raw_score = quiz_3_grade_raw_score;
    }

    /** This method returns the student's Quiz average percent score
     *
     * @return: average_quiz_percent: Avergae % score in all 3 quizzes
     */
    public double getAverage_quiz_percent() {
        return average_quiz_percent;
    }

    /** This method sets the student's Quiz average percent score
     *
     * @param average_quiz_percent
     */
    public void setAverage_quiz_percent(double average_quiz_percent) {
        this.average_quiz_percent = average_quiz_percent;
    }

    /** This method returns the student's midterm percent score
     *
     * @return
     */
    public double getMidterm_percent() {
        return midterm_percent;
    }

    /** This method sets the student's midterm percent score
     *
     * @param midterm_percent
     */
    public void setMidterm_percent(double midterm_percent) {
        this.midterm_percent = midterm_percent;
    }

    /** This method returns the student's midterm raw score
     *
     * @return
     */
    public double getMidterm_raw_score() {
        return midterm_raw_score;
    }

    /** This method sets the student's midterm raw score
     *
     * @param midterm_raw_score
     */
    public void setMidterm_raw_score(double midterm_raw_score) {
        this.midterm_raw_score = midterm_raw_score;
    }

    /** This method returns the student's final percent score
     *
     * @return
     */
    public double getFinal_percent() {
        return final_percent;
    }

    /** This method sets the student's final percent score
     *
     * @param final_percent
     */
    public void setFinal_percent(double final_percent) {
        this.final_percent = final_percent;
    }

    /** This method returns the student' final raw score
     *
     * @return
     */
    public double getFinal_raw_score() {
        return final_raw_score;
    }

    /** This method sets the student' final raw score
     *
     * @param final_raw_score
     */
    public void setFinal_raw_score(double final_raw_score) {
        this.final_raw_score = final_raw_score;
    }

    /** This method returns the student' overall grade %
     *
     * @return
     */
    public double getPercent_grade_overall() {
        return percent_grade_overall;
    }

    /** This method sets the student' overall grade %
     *
     * @param percent_grade_overall
     */
    public void setPercent_grade_overall(double percent_grade_overall) {
        this.percent_grade_overall = percent_grade_overall;
    }

    /** This method returns the student' overall letter grade
     *
     * @return
     */
    public char getLetter_grade() {
        return letter_grade;
    }

    /** This method sets the student' overall letter grade
     *
     * @param letter_grade
     */
    public void setLetter_grade(char letter_grade) {
        this.letter_grade = letter_grade;
    }


    

    /**
     * Default constructor for objects of class StudentRecord
     */
    public StudentRecord()
    {
      name="";
      quiz_1_grade_raw_score=0;
      quiz_2_grade_raw_score=0;
      quiz_3_grade_raw_score=0;
      midterm_raw_score=0;
      final_raw_score=0;
      percent_grade_overall = 0;
    }

    /**
     * setter/mutator method which sets quiz scores,midterm and final scores
     *
     * @param  name_client:the name which the client enters, 
     * quiz_1_raw_score_client: score for quiz 1 which the client enters,
     * quiz_2_raw_score_client: score for quiz 2 which the client enters,
     * quiz_3_raw_score_client: score for quiz 3 which the client enters,
     * midterm_raw_score_client: score for midterm which the client enters,
     * final_raw_score_client: score for final which the client enters
     * 
     * @return    none(method is a void method)
     */
    public void setScoresAndName(String name_client,double 
    quiz_1_raw_score_client,double quiz_2_raw_score_client,
    double quiz_3_raw_score_client, double midterm_raw_score_client, 
    double final_raw_score_client)
    {
       name=name_client;
       quiz_1_grade_raw_score= quiz_1_raw_score_client;
       quiz_2_grade_raw_score= quiz_2_raw_score_client;
       quiz_3_grade_raw_score= quiz_3_raw_score_client;
       midterm_raw_score= midterm_raw_score_client;
       final_raw_score= final_raw_score_client;
    }

    /**
     * This method calculates the percent grade from scores.
     * @param: none
     * @return: none(method is a void methord)
     */
    public void scoreCalculator(){
       quiz_1_percent= quiz_1_grade_raw_score*10;
       quiz_2_percent= quiz_2_grade_raw_score*10;
       quiz_3_percent= quiz_3_grade_raw_score*10;
       midterm_percent=midterm_raw_score;
       final_percent = final_raw_score;
       average_quiz_percent = (quiz_1_percent + quiz_2_percent 
       + quiz_3_percent)/3;
       percent_grade_overall=average_quiz_percent * 0.25 + midterm_percent * 
       0.35+ final_percent * 0.40;
       letterGradeCalculator();
    }

    /**
     * This method calculates the letter grade from percent grade.
     * @param: none
     * @return: none(methord is a void methord)
     */
    public void letterGradeCalculator(){
       if(percent_grade_overall >= 90) {
         letter_grade = 'A';
       }
       if(percent_grade_overall >= 80 && percent_grade_overall < 90) {
         letter_grade = 'B';
       }
       if(percent_grade_overall >= 70 && percent_grade_overall < 80) {
         letter_grade = 'C';
       }
       if(percent_grade_overall >= 60 && percent_grade_overall < 70) {
         letter_grade = 'D';
       }
       if(percent_grade_overall < 60) {
         letter_grade = 'F';
       }
    }

    /** Creates a "stringified" version of the object and print out all fields of StudentRecord
     *
     * @return string
     */
    public String toString() {
        return "StudentRecord{" +
                "name='" + name + '\'' +
                ", quiz_1_percent=" + quiz_1_percent +
                ", quiz_1_grade_raw_score=" + quiz_1_grade_raw_score +
                ", quiz_2_percent=" + quiz_2_percent +
                ", quiz_2_grade_raw_score=" + quiz_2_grade_raw_score +
                ", quiz_3_percent=" + quiz_3_percent +
                ", quiz_3_grade_raw_score=" + quiz_3_grade_raw_score +
                ", average_quiz_percent=" + average_quiz_percent +
                ", midterm_percent=" + midterm_percent +
                ", midterm_raw_score=" + midterm_raw_score +
                ", final_percent=" + final_percent +
                ", final_raw_score=" + final_raw_score +
                ", percent_grade_overall=" + percent_grade_overall +
                ", letter_grade=" + letter_grade +
                '}';
    }

    /** Compares 2 Student records are equal by looking at StudentName as well as each raw score.
     *  Note: other variants are possible where we can only compare the name and identify equality but I choose the
     *  more comprehensive one for this implementation
     *
     * @param o: Another student record
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentRecord)) return false;
        StudentRecord that = (StudentRecord) o;
        return Double.compare(that.getQuiz_1_grade_raw_score(), getQuiz_1_grade_raw_score()) == 0 &&
                Double.compare(that.getQuiz_2_grade_raw_score(), getQuiz_2_grade_raw_score()) == 0 &&
                Double.compare(that.getQuiz_3_grade_raw_score(), getQuiz_3_grade_raw_score()) == 0 &&
                Double.compare(that.getMidterm_raw_score(), getMidterm_raw_score()) == 0 &&
                Double.compare(that.getFinal_raw_score(), getFinal_raw_score()) == 0 &&
                getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getQuiz_1_grade_raw_score(), getQuiz_2_grade_raw_score(), getQuiz_3_grade_raw_score(), getMidterm_raw_score(), getFinal_raw_score());
    }
}
