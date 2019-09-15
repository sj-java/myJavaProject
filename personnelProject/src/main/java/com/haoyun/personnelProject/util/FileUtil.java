package com.haoyun.personnelProject.util;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件处理工具类
 * @author Admin
 *
 */
public class FileUtil {
	
	private static final Logger log = LoggerFactory.getLogger(FileUtil.class);
	
	public String uploadFile(MultipartFile file) {
		
		try {
            if (file.isEmpty()) {
                return ResultType.UPDATE_FAULT;
            }
            // 获取文件名
            String fileName = file.getOriginalFilename();
            log.info("上传的文件名为：" + fileName);
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            log.info("文件的后缀名为：" + suffixName);
            // 设置文件存储路径
            String filePath = "/Users/dalaoyang/Downloads/";
            String path = filePath + fileName;
            File dest = new File(path);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();// 新建文件夹
            }
            file.transferTo(dest);// 文件写入
            return ResultType.UPDATE_SUCCESS;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultType.UPDATE_FAULT;
	}
}
