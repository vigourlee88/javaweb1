package com.itheima.json;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.itheima.domain.Project;

public class JsonTest {
	
	//将一个Project对象转换成json
	@Test
	public void test1() {
		//1.创建一个Project对象
		Project p1 = new Project();
		p1.setId(1);
		p1.setCount(100);
		p1.setName("电视机");
		p1.setPrice(2000);
		
		//2.使用fastjson将p1转换成json数据
		//{id:xxx,name:xxx,price:xxx,count:xxx}
		
		String json = JSONObject.toJSONString(p1);
	    System.out.println(json);
	}
	
	//将List<Project>对象转换成json
		@Test
		public void test2() {
			//1.创建一个List<Project>对象
			Project p1 = new Project();
			p1.setId(1);
			p1.setCount(100);
			p1.setName("电视机");
			p1.setPrice(2000);
			
			Project p2 = new Project();
			p2.setId(2);
			p2.setCount(200);
			p2.setName("洗衣机");
			p2.setPrice(1000);
			
			List<Project> list = new ArrayList<Project>();
		    list.add(p1);
		    list.add(p2);
		    
		    //将list转换成json
		    //[{id:xx,name:xx...},{id:xxx,name:xxx}]
		    String json = JSONObject.toJSONString(list);
		    System.out.println(json);
		}


}
