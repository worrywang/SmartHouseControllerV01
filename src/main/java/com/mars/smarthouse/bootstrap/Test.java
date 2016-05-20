package com.mars.smarthouse.bootstrap;

import com.alibaba.fastjson.JSON;
import com.mars.smarthouse.bean.iocd.Deployment;
import com.mars.smarthouse.bean.iocd.Machine;

/**
 * Created by Administrator on 2016/5/1.
 */
public class Test {

	public static void main(String[] args) {
		System.out.println("current test.........");
		Machine m = new Machine();
		m.setId("hahah");
		m.setDeployment(new Deployment());
		String json_str = JSON.toJSONString(m);
		System.out.println("json str: "+json_str);
		Machine m2 = JSON.parseObject(json_str,Machine.class);
		System.out.println(m2);
	}
}
