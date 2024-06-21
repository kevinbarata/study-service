package com.project.study.serviceImpl;

import com.project.study.dao.LearningDao;
import com.project.study.dto.ELearningDto;
import com.project.study.service.LearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearningServiceImpl implements LearningService {

    @Autowired
    private LearningDao learningDao;

    @Override
    public int createELearningMaterial(ELearningDto dto) {
        int insert = learningDao.createELearningMaterial(dto);
        return insert;
    }

    @Override
    public List<ELearningDto> getAllMaterial(ELearningDto dto) {
        List<ELearningDto> list = learningDao.getAllMaterial(dto);
        return list;
    }
}
