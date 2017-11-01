package com.garyhu.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.xwork.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.garyhu.pojo.UploadedImageFile;

@Controller
public class UploadedController {

	@RequestMapping("/uploadImage")
	public ModelAndView upload(HttpServletRequest req,UploadedImageFile imgFile)
	         throws IllegalStateException,IOException{
		//获取一个随机的文件名，防止上传相同文件时覆盖原文件
		String name = RandomStringUtils.randomAlphanumeric(10);
		String newFileName = name+".jpg";
		//获取web下的image路径
		String dir = req.getServletContext().getRealPath("/image");
		File newFile = new File(dir,newFileName);
		//创建image目录
		newFile.getParentFile().mkdirs();
		//把上传的图片文件复制到newFile中
		imgFile.getImage().transferTo(newFile);
		
		ModelAndView mav = new ModelAndView("showUploadImage");
		mav.addObject("imageName",newFileName);
		return mav;
	}
}
