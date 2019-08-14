package com.lz.algorithmManager.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.beans.factory.annotation.Value;

import com.lz.algorithmManager.modal.ErrorCode;
import com.lz.algorithmManager.modal.GitInfo;

public class Jgit {
	
	private String sourcePath = "D:\\asm\\codescan\\";// 下载已有仓库到固定路径

	/**
	 * 克隆远程库
	 * 
	 */
	public GitInfo gitClone(String gitUrl,String breach) throws IOException, GitAPIException {

		GitInfo gitInfo = new GitInfo();
		ErrorCode errorCode = new ErrorCode();
		// 设置远程服务器上的用户名和密码
		UsernamePasswordCredentialsProvider usernamePasswordCredentialsProvider = new UsernamePasswordCredentialsProvider(
				"username", "password");
		String string = null;
		String[] ad = gitUrl.split("/");
		for (int i = 0; i < ad.length; i++) {
			string = ad[i];
		}
		String str = string.replace(".git", "");
		String path = sourcePath + str;
		File file = new File(path);
		if(file.exists()){
			errorCode.setCode("500");
			errorCode.setDesc("操作失败！文件已存在:"+path);
			gitInfo.setErroCode(errorCode);
			return gitInfo;//或者执行pull
		}else {
			CloneCommand cloneCommand = Git.cloneRepository();
			// 克隆代码库命令
			cloneCommand.setURI(gitUrl) // 设置远程URI
					.setBranch(breach) // 设置clone下来的分支
					.setDirectory(file) // 设置下载存放路径
					.setCredentialsProvider(usernamePasswordCredentialsProvider) // 设置权限验证
					.call();
			errorCode.setCode("200");
			errorCode.setDesc("操作成功！");
			gitInfo.setErroCode(errorCode);
			gitInfo.setSourcePath(path);
			return gitInfo;
		}	
	}
}
