package com.example.demo.dao;

import com.example.demo.dao.entity.QuestionnaireEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface QuestionnareEntityMapper {
	List<QuestionnaireEntity> queryQuestionnaireList(QuestionnaireEntity questionnaireEntity);
	int addQuestionnaire(QuestionnaireEntity questionnaireEntity);
	int deleteQuestionnaireById(QuestionnaireEntity questionnaireEntity);
	int modifyQuestionnaireById(QuestionnaireEntity questionnaireEntity);

	QuestionnaireEntity selectQuestionnaireById(QuestionnaireEntity questionnaireEntity);
}
