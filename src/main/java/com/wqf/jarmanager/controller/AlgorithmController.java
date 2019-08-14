package com.wqf.jarmanager.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wqf.jarmanager.modal.Param;
import com.wqf.jarmanager.service.AlgorithmService;



@RestController
@RequestMapping("/algorithm")
public class AlgorithmController {
	
	@Autowired
	AlgorithmService algorithmService;

	//获取算法信息
	@RequestMapping(value = "/getAlgorithm", method=RequestMethod.GET)
	public Object getAlgorithm() {
		
		Object conf = algorithmService.getAlgorithm();
		
		return conf;
	}
	
	//获取算法处理结果
	@RequestMapping(value = "/getAlgorithmData", method=RequestMethod.POST)
    public Object getAlgorithmData(@RequestBody Param param) throws Exception {

      Object alg = algorithmService.getAlgorithmData(param);
      
      return alg;
	}

}
