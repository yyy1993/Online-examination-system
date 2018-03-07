package edu.fjnu.online.dao;

import edu.fjnu.online.domain.Exam;

import java.util.List;

public interface ExamDao  extends BaseDao<Exam>{

    public List<Exam> getExamInfoByUserId(String userId);
    public List<Exam> getExamInfoByUserIdAndStatus(Exam exam);
}
