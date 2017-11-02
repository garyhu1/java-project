package com.garyhu.test;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLog4j {

	// 基于类的名称获取日志对象
	static Logger logger = Logger.getLogger(TestLog4j.class);
	public static void main(String[] args) {
		//进行默认配置
//		BasicConfigurator.configure();
		//自定义设置
//		PropertyConfigurator.configure("d:\\java-project\\workspace\\mybatis\\src\\log4j.properties");
		//也可以用自定义的xml文件来配置
		PropertyConfigurator.configure("d:\\java-project\\workspace\\mybatis\\src\\log4j.xml");
		//设置日志输出级别
		logger.setLevel(Level.DEBUG);
		//进行不同级别的日志输出
		logger.trace("跟踪信息");
		logger.debug("测试信息");
		logger.info("输出信息");
		logger.warn("警告信息");
		logger.error("错误信息");
		logger.fatal("致命信息");
	}
}
