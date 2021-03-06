/**
 * 
 */
package com.dubbo.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.bean.TestBeans;
import com.dubbo.handle.ThreadTests;

/**
 * @author:VIPKID ZengWeiLong
 * @date:2015-9-7
 */
@Service(cluster="failsafe",loadbalance="roundrobin",version="0.0.1")
public class DemoServer2Impl implements DemoService {
	
	public String sayHello(String str,TestBeans bean){
		//处理请求
		System.out.println("第2个服务得到Bean："+bean.getDubbos());
		new Thread(new ThreadTests(str+"")).start();
		return str+"===我是第2个服务。";
	}

}
