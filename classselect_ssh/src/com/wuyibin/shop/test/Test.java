package com.wuyibin.shop.test;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class Test {
	public static void main(String[] args) {
		 Configuration cfg=new Configuration().configure();  
         
	        //工具类  
	        SchemaExport export=new SchemaExport(cfg);  
	        //打到控制台，输出到数据库  
	        export.create(true, true);  
	}
}
