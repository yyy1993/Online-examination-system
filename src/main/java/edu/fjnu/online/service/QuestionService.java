package edu.fjnu.online.service;

import com.github.pagehelper.PageInfo;
import edu.fjnu.online.domain.Question;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface QuestionService {
	public void create();
	public List<Question> find(Question question);
	public Question get(Serializable id);
	public void insert(Question question);
	public void update(Question question);
	public void delete(int id);
	public List<Question> createPaper(Map map);
	public PageInfo<Question> findByPage(Question question, Integer pageNo,Integer pageSize);
	public Question getQuestion(int id);
}
