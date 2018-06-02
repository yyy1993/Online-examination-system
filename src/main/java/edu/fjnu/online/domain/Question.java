package edu.fjnu.online.domain;

public class Question {
	/**问题编号*/
	private int questionId;
    /**问题类型* 0：单选题，1：多选题*/
    private int questionForm;
    /**问题类型* 0：专业题，1：逻辑题，2：心理题*/
    private int questionType;
	/**问题名称*/
	private String quesName;
	/**选项A*/
	private String optionA;
	/**选项A得分**/
	private int scoreA;
	/**选项B*/
	private String optionB;
    /**选项B得分**/
    private int scoreB;
	/**选项C*/
	private String optionC;
    /**选项C得分**/
    private int scoreC;
	/**选项D*/
	private String optionD;
    /**选项D得分**/
    private int scoreD;
    /**选项E*/
    private String optionE;
    /**选项E得分**/
    private int scoreE;
    /**选项F*/
    private String optionF;
    /**选项F得分**/
    private int scoreF;
	/**标准答案*/
	private String answer;
    /**答案详解**/
    private String answerDetail;
    /**备注**/
	private String remark;

	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
    public int getQuestionForm() {
        return questionForm;
    }
    public void setQuestionForm(int questionForm) {
        this.questionForm = questionForm;
    }
    public int getQuestionType() {
        return questionType;
    }
    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }
	public String getQuesName() {
		return quesName;
	}
	public void setQuesName(String quesName) {
		this.quesName = quesName;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public int getScoreA() { return scoreA; }
	public void setScoreA(int scoreA) { this.scoreA = scoreA; }
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) { this.optionB = optionB; }
    public int getScoreB() { return scoreB; }
    public void setScoreB(int scoreB) { this.scoreB = scoreB; }
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
    public int getScoreC() { return scoreC; }
    public void setScoreC(int scoreC) { this.scoreC = scoreC; }
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
    public int getScoreD() { return scoreD; }
    public void setScoreD(int scoreD) { this.scoreD = scoreD; }
    public String getOptionE() {
        return optionE;
    }
    public void setOptionE(String optionE) {
        this.optionE = optionE;
    }
    public int getScoreE() { return scoreE; }
    public void setScoreE(int scoreE) { this.scoreE = scoreE; }
    public String getOptionF() {
        return optionF;
    }
    public void setOptionF(String optionF) {
        this.optionF = optionF;
    }
    public int getScoreF() { return scoreF; }
    public void setScoreF(int scoreF) { this.scoreF = scoreF; }
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getAnswerDetail() {
		return answerDetail;
	}
	public void setAnswerDetail(String answerDetail) {
		this.answerDetail = answerDetail;
	}

	public Question() {
		
	}
	public Question(int questionId, int questionForm, int questionType, String quesName, String optionA, int scoreA,
			String optionB, int scoreB, String optionC, int scoreC, String optionD, int scoreD,String optionE, int scoreE, String optionF, int scoreF,
                    String answer, String remark, String answerDetail) {
		super();
		this.questionId = questionId;
		this.questionForm = questionForm;
		this.questionType = questionType;
		this.quesName = quesName;
		this.optionA = optionA;
		this.scoreA = scoreA;
		this.optionB = optionB;
		this.scoreB = scoreB;
		this.optionC = optionC;
		this.scoreC = scoreC;
		this.optionD = optionD;
		this.scoreD = scoreD;
        this.optionE = optionE;
        this.scoreE = scoreE;
        this.optionF = optionF;
        this.scoreF = scoreF;
		this.answer = answer;
		this.remark = remark;
		this.answerDetail = answerDetail;
	}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionForm=" + questionForm + ", questionType=" + questionType + ", quesName=" + quesName
				+ ", optionA=" + optionA +", scoreA=" + scoreA + ", optionB=" + optionB + ", scoreB=" + scoreB
				+ ", optionC=" + optionC + ", scoreC=" + scoreC + ", optionD=" + optionD + ", scoreD=" + scoreD + ", optionE=" + optionE + ", scoreE=" + scoreE + ", optionF=" + optionF + ", scoreF=" + scoreF
                + ", answer=" + answer + ", remark=" + remark + ", answerDetail="
				+ answerDetail + "]";
	}
}
