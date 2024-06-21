package com.project.study.controller;

import com.project.study.dto.ELearningDto;
import com.project.study.service.LearningService;
import com.project.study.util.ErrorCodeEnum;
import com.project.study.util.ResponseEntityBuilder;
import com.project.study.util.ResponseEntityDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/learning")
public class LearningController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LearningService learningService;

    @RequestMapping(value = "/createELearningMaterial", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntityDto createELearningMaterial(@RequestBody ELearningDto dto) {
        logger.info("learning.createELearningMaterial parameter = " + dto);
        if (dto != null) {
            int add = learningService.createELearningMaterial(dto);
            return ResponseEntityBuilder.buildNormalResponse(add);
        } else {
            return ResponseEntityBuilder.buildErrorResponse(ErrorCodeEnum.PARAM_VALUE_ERROR);
        }
    }

    @RequestMapping(value = "/getAllMaterial", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntityDto getAllMaterial(@RequestBody ELearningDto dto) {
        logger.info("learning.getAllMaterial parameter = " + dto);
        if (dto != null){
            List<ELearningDto> list = learningService.getAllMaterial(dto);
            return ResponseEntityBuilder.buildNormalResponse(list);
        }else {
            return ResponseEntityBuilder.buildErrorResponse(ErrorCodeEnum.PARAM_VALUE_ERROR);
        }
    }

}
