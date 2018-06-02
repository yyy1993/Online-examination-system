package edu.fjnu.online.dao.impl;

import edu.fjnu.online.dao.QuestionDao;
import edu.fjnu.online.domain.Question;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public class QuestionDaoImpl extends BaseDaoImpl< Question> implements QuestionDao {
	public QuestionDaoImpl() {
		this.setNs("edu.fjnu.online.mapper.QuestionMapper.");
	}

    public Question getQuestion(int id){ return this.getSqlSession().selectOne(this.getNs()+"getQuestion", id);}
	public List<Question> createPaper(Map map) {
		return this.getSqlSession().selectList(this.getNs()+"createPaper", map);
	}
}
