package com.project.study.service;

import com.project.study.dto.EssayDto;

import java.util.List;

public interface TaskService {

    int createNewEssay(EssayDto essayDto);

    int markEssayAsCompleted(EssayDto essayDto);

    List<EssayDto> getAllEssay(EssayDto essayDto);

    int sendEssayAnswer(EssayDto essayDto);
}
