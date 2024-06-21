package com.project.study.service;

import com.project.study.dto.ELearningDto;

import java.util.List;

public interface LearningService {

    int createELearningMaterial(ELearningDto dto);

    List<ELearningDto> getAllMaterial(ELearningDto dto);
}
