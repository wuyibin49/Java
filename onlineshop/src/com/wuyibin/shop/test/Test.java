package com.wuyibin.shop.test;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class Test {
	public static void main(String[] args) {
		 Configuration cfg=new Configuration().configure();  
         
	        //������  
	        SchemaExport export=new SchemaExport(cfg);  
	        //�򵽿���̨����������ݿ�  
	        export.create(true, true);  
	}
}
