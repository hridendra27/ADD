package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import DaoDb.DaoDb;
import Model.CrudModel;
import Services.employee;

@Controller 

public class Controller_ex extends HttpServlet {

	private ApplicationContext ctx;

	@RequestMapping ("dump/add")	  
	public String add(HttpServletRequest req, HttpServletResponse res) {  
		
		//CrudModel cm=new CrudModel();
	
		System.out.println("Hy");	
		int id=Integer.parseInt(req.getParameter("t1"));
		String ename= req.getParameter("t2");
		
	    ctx = new ClassPathXmlApplicationContext("NewFile.xml");  
	      
	    DaoDb dao=(DaoDb)ctx.getBean("edao"); 
	    
	   // int status=dao.saveEmployee(new employee(id,ename));  
	    //System.out.println(status);  
	          
	   // int status1=dao.updateEmployee(new employee(102,"Sonoo")); 
	   // System.out.println(status1); 
	    
	    /*Employee e=new Employee(); 
	    e.setId(102); 
	    int status=dao.deleteEmployee(e); 
	    System.out.println(status);*/  
	    ArrayList <String> m1=new ArrayList <String>();
	    employee e=new employee();
	    e.setId(id); 
	    m1 = (ArrayList<String>) dao.retriveEmployee(e);
	    System.out.println(m1);
	    for (Object a:m1) {
	    	System.out.println(a);
	    }
	    Gson gy = new Gson();
	    String jsons = gy.toJson(m1);
	   System.out.println(jsons);
	    
		System.out.println("Hy");
	    return "index.jsp";
	}  

}
