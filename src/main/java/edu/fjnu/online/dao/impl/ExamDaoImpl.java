package edu.fjnu.online.dao.impl;

import edu.fjnu.online.dao.ExamDao;
import edu.fjnu.online.domain.Exam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExamDaoImpl extends BaseDaoImpl<Exam> implements ExamDao {
    public ExamDaoImpl() {
        this.setNs("edu.fjnu.online.mapper.CourseMapper.");
    }
        //this.setNs("edu.fjnu.online.mapper.ExamMapper.");

    public List<Exam> getExamInfoByUserId(String userId) {
        return this.getSqlSession().selectList(this.getNs()+"getExamInfoByUserId",userId);
    }
    public List<Exam> getExamInfoByUserIdAndStatus(Exam exam) {
        return this.getSqlSession().selectList(this.getNs()+"getExamInfoByUserIdAndStatus",exam);
    }

}
