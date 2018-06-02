package edu.fjnu.online.domain;

public class Exam {
    private String examId;
    private String userId;
    private String paperId;
    private String questionsId;
    private String options;
    private int status;
    private int score;

    public String getExamId() {
        return examId;
    }
    public void setExamId(String examId) {this.examId = examId;}
    public String getUserId(){return userId;}
    public void setUerId(String userId) {this.userId = userId;}
    public String getPaperId(){return paperId;}
    public void setPaperId(String paperId) {this.paperId = paperId;}
    public String getQuestionsId(){return questionsId;}
    public void setQuestionsId(String questionsId) {this.questionsId = questionsId;}
    public String getOption(){return options;}
    public void setOption(String options) {this.options = options;}
    public int getStatus(){return status;}
    public void setStatus(int status){this.status = status;}
    public int getScore(){return score;}
    public void setSCore(int score){this.score = score;}
}
