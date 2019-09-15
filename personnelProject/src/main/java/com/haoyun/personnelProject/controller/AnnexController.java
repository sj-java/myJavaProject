package com.haoyun.personnelProject.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.haoyun.personnelProject.bean.AnnexBean;
import com.haoyun.personnelProject.service.AnnexService;
import com.haoyun.personnelProject.util.Result;

@Controller
@RequestMapping("/annex")
public class AnnexController {
	
	private static final Logger log = LoggerFactory.getLogger(AnnexController.class);
	@Autowired
	private AnnexService annexService;
	
	/**
	 * 文件上传
	 * @return
	 */
	@RequestMapping("upload")
	@ResponseBody
	public Result upload(@RequestParam(value="file",required=true)MultipartFile file,
			@RequestParam(value="belongId",required=true)String belongId) {
			
		if(file.isEmpty()) {
			return Result.resultError("文件为空");
		}
		Map<String,String> map=new HashMap<String,String>();
		map.put("belongId", belongId);
		//文件名
		String annexName=file.getOriginalFilename();
		map.put("annexName", annexName);
		log.info("上传文件名为："+annexName);
		//后缀名
		String lastName=annexName.substring(annexName.lastIndexOf("."));
		map.put("lastName", lastName);
		log.info("上传文件后缀名为："+lastName);
		//设置文件存储路径
		String filePath="C:/Users/uploadFile/";
		String path=filePath+annexName;
		map.put("annexUrl", path);
		File dest=new File(path);
		if(!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			file.transferTo(dest);	
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			map.put("uploadDate", sf.format(new Date()));
			annexService.addAnnexBean(map);
			return Result.resultSuccess("文件上传成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.resultError("文件上传失败");
	}
	@RequestMapping("getFileMsg")
	@ResponseBody
	public Result getFileMsg(@RequestParam(value="id",required=true)String id) {
		
		Map<String,String> map=new HashMap<String,String>();
		map.put("id", id);
		try {
			List<AnnexBean> annexList=annexService.findAnnexBean(map);
			return Result.resultSuccess(annexList);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Result.resultError("文件查询失败");
	}
}
