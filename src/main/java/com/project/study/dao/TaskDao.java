package com.project.study.dao;

import com.project.study.dto.EssayDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskDao {

    int createNewEssay(EssayDto essayDto);

    int markEssayAsCompleted(EssayDto essayDto);

    List<EssayDto> getAllEssay(EssayDto essayDto);

    int sendEssayAnswer(EssayDto dto);
}
