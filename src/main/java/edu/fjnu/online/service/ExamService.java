package edu.fjnu.online.service;

import edu.fjnu.online.domain.Exam;

import java.util.List;

public interface ExamService {
    public void create();
    public List<Exam> find(Exam exam);
    public Exam get(int id);
    public void insert(Exam exam);
    public void update(Exam exam);
    public void delete(int id);
    public List<Exam> getExamInfoByUserId(String userId);
    public List<Exam> getExamInfoByUserIdAndStatus(Exam exam);
}
