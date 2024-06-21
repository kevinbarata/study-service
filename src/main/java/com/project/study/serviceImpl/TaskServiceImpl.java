package com.project.study.serviceImpl;

import com.project.study.dao.TaskDao;
import com.project.study.dto.EssayDto;
import com.project.study.enumerate.TaskStatusEnum;
import com.project.study.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public int createNewEssay(EssayDto essayDto) {
        essayDto.setStatus(Integer.parseInt(TaskStatusEnum.INCOMPLETE.getCode()));
        essayDto.setTaskApplyTime(new Date());
        int insert = taskDao.createNewEssay(essayDto);
        return insert;
    }

    @Override
    public int markEssayAsCompleted(EssayDto essayDto) {
        essayDto.setStatus(Integer.parseInt(TaskStatusEnum.COMPLETED.getCode()));
        essayDto.setTaskCompletionTime(new Date());
        int update = taskDao.markEssayAsCompleted(essayDto);
        return update;
    }

    @Override
    public List<EssayDto> getAllEssay (EssayDto essayDto) {
        List<EssayDto> list = taskDao.getAllEssay(essayDto);
        return list;
    }

    @Override
    public int sendEssayAnswer(EssayDto essayDto) {
        essayDto.setTaskCompletionTime(new Date());
        int send = taskDao.sendEssayAnswer(essayDto);
        return send;
    }
}
