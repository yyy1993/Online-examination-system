package edu.fjnu.online.dao;

import edu.fjnu.online.domain.Question;

import java.util.List;
import java.util.Map;

public interface QuestionDao extends BaseDao<Question>{

    public Question getQuestion(int id);
	public List<Question> createPaper(Map map);

}
