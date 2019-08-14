package com.wqf.jarmanager.service;

import com.wqf.jarmanager.modal.Param;

public interface AlgorithmService {
	
	Object getAlgorithm();
	
	Object getAlgorithmData(Param param)throws Exception;

}
