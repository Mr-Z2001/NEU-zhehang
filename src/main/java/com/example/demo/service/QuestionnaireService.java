package com.example.demo.service;

import com.example.demo.dao.entity.QuestionnaireEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.QuestionnareEntityMapper;

import java.util.List;

import static com.example.demo.common.utils.UUIDUtil.*;

@Service
public class QuestionnaireService {
	@Autowired private QuestionnareEntityMapper questionnareEntityMapper;

	public List<QuestionnaireEntity> queryQuestionnaireList(QuestionnaireEntity questionnaireEntity){
		return questionnareEntityMapper.queryQuestionnaireList(questionnaireEntity);
	}

	public int addQuestionnaire(QuestionnaireEntity questionnaireEntity) {
		questionnaireEntity.setId(getQuestionnaireUUID());
		return questionnareEntityMapper.addQuestionnaire(questionnaireEntity);
	}

	public int deleteQuestionnaireById(QuestionnaireEntity questionnaireEntity) {
		return questionnareEntityMapper.deleteQuestionnaireById(questionnaireEntity);
	}

	public int modifyQuestionnaireById(QuestionnaireEntity questionnaireEntity) {
		return questionnareEntityMapper.modifyQuestionnaireById(questionnaireEntity);
	}

	public QuestionnaireEntity selectQuestionnaireById(QuestionnaireEntity questionnaireEntity) {
		return questionnareEntityMapper.selectQuestionnaireById(questionnaireEntity);
	}

}
