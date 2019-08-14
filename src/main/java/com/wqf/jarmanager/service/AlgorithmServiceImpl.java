package com.wqf.jarmanager.service;

import java.io.File;

import org.springframework.stereotype.Service;

import com.wqf.jarmanager.modal.GitInfo;
import com.wqf.jarmanager.modal.Param;
import com.wqf.jarmanager.modal.ParamEX;
import com.wqf.jarmanager.utils.Configuration;
import com.wqf.jarmanager.utils.Jgit;
import com.wqf.jarmanager.utils.JobManager;
import com.wqf.jarmanager.utils.PluginLoader;
import com.wqf.jarmanager.utils.PluginUtils;


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
