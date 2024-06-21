package com.project.study.controller;

import com.project.study.dto.ELearningDto;
import com.project.study.dto.EssayDto;
import com.project.study.service.TaskService;
import com.project.study.util.ErrorCodeEnum;
import com.project.study.util.ResponseEntityBuilder;
import com.project.study.util.ResponseEntityDto;
import com.project.study.util.SuccessCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/task")
public class TaskController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TaskService taskService;


    //Create a new Essay
    @RequestMapping(value = "/createNewEssay", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntityDto createNewEssay(@RequestBody EssayDto essayDto) {
        logger.info("task.createNewEssay parameter = " + essayDto);
        if (essayDto != null) {
            int add = taskService.createNewEssay(essayDto);
            if (add == 1) {
                return ResponseEntityBuilder.buildNormalResponse(SuccessCodeEnum.CREATE_TASK_SUCCESS.getMessage(), add);
            }
            return ResponseEntityBuilder.buildNormalResponse();
        } else {
            return ResponseEntityBuilder.buildErrorResponse(ErrorCodeEnum.PARAM_VALUE_ERROR);
        }
    }

    //Mark Essay as completed.
    @RequestMapping(value = "/markEssayAsCompleted", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntityDto markEssayAsCompleted(@RequestBody EssayDto essayDto) {
        logger.info("task.markEssayAsCompleted parameter = " + essayDto);
        if (essayDto != null){
            int update = taskService.markEssayAsCompleted(essayDto);
            if (update == 1){
                return ResponseEntityBuilder.buildNormalResponse(SuccessCodeEnum.TASK_COMPLETED.getMessage(),update);
            }
            return ResponseEntityBuilder.buildNormalResponse();
        }else {
            return ResponseEntityBuilder.buildErrorResponse(ErrorCodeEnum.PARAM_VALUE_ERROR);
        }
    }
    @RequestMapping(value = "/getAllEssay", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntityDto getAllEssay(@RequestBody EssayDto essayDto) {
        logger.info("task.getAllEssay parameter = " + essayDto);
        if (essayDto != null){
            List<EssayDto> list = taskService.getAllEssay(essayDto);
            return ResponseEntityBuilder.buildNormalResponse(list);
        }else {
            return ResponseEntityBuilder.buildErrorResponse(ErrorCodeEnum.PARAM_VALUE_ERROR);
        }
    }

    @RequestMapping(value = "/sendEssayAnswer", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntityDto sendEssayAnswer(@RequestBody EssayDto dto) {
        logger.info("task.sendEssayAnswer parameter = " + dto);
        if (dto != null) {
            int add = taskService.sendEssayAnswer(dto);
            return ResponseEntityBuilder.buildNormalResponse(add);
        } else {
            return ResponseEntityBuilder.buildErrorResponse(ErrorCodeEnum.PARAM_VALUE_ERROR);
        }
    }


}
