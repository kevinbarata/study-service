package com.project.study.dao;

import com.project.study.dto.ELearningDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LearningDao {

    int createELearningMaterial(ELearningDto dto);

    List<ELearningDto> getAllMaterial(ELearningDto dto);
}
