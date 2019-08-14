package com.lz.algorithmManager.service;

import com.lz.algorithmManager.modal.Param;

public interface AlgorithmService {
	
	Object getAlgorithm();
	
	Object getAlgorithmData(Param param)throws Exception;

}
