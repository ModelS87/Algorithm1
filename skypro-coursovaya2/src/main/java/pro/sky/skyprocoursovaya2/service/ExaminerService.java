package pro.sky.skyprocoursovaya2.service;

import pro.sky.skyprocoursovaya2.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);

}
