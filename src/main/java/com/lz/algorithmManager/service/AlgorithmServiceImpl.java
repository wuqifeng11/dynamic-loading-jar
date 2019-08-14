package com.lz.algorithmManager.service;

import java.io.File;

import org.springframework.stereotype.Service;

import com.lz.algorithmManager.modal.GitInfo;
import com.lz.algorithmManager.modal.Param;
import com.lz.algorithmManager.modal.ParamEX;
import com.lz.algorithmManager.utils.Configuration;
import com.lz.algorithmManager.utils.Jgit;
import com.lz.algorithmManager.utils.JobManager;
import com.lz.algorithmManager.utils.PluginLoader;
import com.lz.algorithmManager.utils.PluginUtils;

@Service
public class AlgorithmServiceImpl implements AlgorithmService {

//	@Autowired
//	AlgoritionMapper algoritionMapper;
	
	@Override
	public Object getAlgorithm() {
		String confPath = PluginLoader.getConfPath();
		File coreFile = new File(confPath);
		Configuration conf = Configuration.from(coreFile);
		return conf.get("plugins");
		
	}

	@Override
	public Object getAlgorithmData(Param param) throws Exception {
		if(param.getParamEX().getGitUrl() != null) {
			GitInfo gitInfo = gitClone(param.getParamEX());
			if(gitInfo.getErrorCode().getCode().equals("200")) {
				
				param.getParamEX().setSourcePath( gitInfo.getSourcePath());
			    String pluginClassName = PluginLoader.getPluginClassName(param.getAlName());
			    Class<?> cls = PluginUtils.loadClass(param.getAlName(), pluginClassName);
			    JobManager jobManager =  (JobManager) cls.newInstance();
			    Object algResults = jobManager.check(param);	
			    
			    return algResults;
			}else {
				return gitInfo.getErrorCode();
			}
		}else {
			String pluginClassName = PluginLoader.getPluginClassName(param.getAlName());
		    Class<?> cls = PluginUtils.loadClass(param.getAlName(), pluginClassName);
		    JobManager jobManager =  (JobManager) cls.newInstance();
		    Object algResults = jobManager.check(param);	
		    
		    return algResults;
		}

	}
	
	public GitInfo gitClone(ParamEX paramEX) throws Exception {
    	
    	String gitUrl = paramEX.getGitUrl();
		String breach = paramEX.getBranchOrTag();
		Jgit jgit = new Jgit();
		GitInfo gitInfo = jgit.gitClone(gitUrl,breach);
		
		return gitInfo;

    }
	
}
