package edu.fjnu.online.service.impl;

import edu.fjnu.online.dao.ExamDao;
import edu.fjnu.online.domain.Exam;
import edu.fjnu.online.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    ExamDao examDao;
    public void create()
    {
        examDao.create();
    }
    public List<Exam> find(Exam exam)
    {
        return examDao.find(exam);
    }
    public Exam get(int id)
    {
        return examDao.get(id);
    }
    public void insert(Exam exam)
    {
        examDao.insert(exam);
    }
    public void update(Exam exam)
    {
        examDao.update(exam);
    }
    public void delete(int id)
    {
        examDao.delete(id);
    }
    public List<Exam> getExamInfoByUserId(String userId)
    {
        return examDao.getExamInfoByUserId(userId);
    }
    public List<Exam> getExamInfoByUserIdAndStatus(Exam exam)
    {
        return examDao.getExamInfoByUserIdAndStatus(exam);
    }
}
