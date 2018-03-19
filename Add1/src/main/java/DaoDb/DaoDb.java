package DaoDb;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import Services.employee;

  

public class DaoDb {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	} 
	public int saveEmployee(employee e){  
		
		System.out.println(e.getId());
	    String query="insert  into employee values( "+e.getId()+",'"+e.getName()+"'); "; 
	    return jdbcTemplate.update(query);  
	}
	public int updateEmployee(employee e){  
	    String query="update employee set ename='"+e.getName()+"' where id="+e.getId()+"; ";  
	    return jdbcTemplate.update(query);  
	} 
	public int deleteEmployee(employee e){  
	    String query="delete from employee where id='"+e.getId()+"'; ";  
	    return jdbcTemplate.update(query);  
	}
	public List retriveEmployee(employee e) {
		String query= "select * from employee where id= '"+e.getId()+"'";
		//return (Map) jdbcTemplate.queryForList(query);
		List<Map<String, Object>> retList = jdbcTemplate.queryForList(query);
		return  retList;
	}
	
	public List retriveById(employee e) {
		String query= "select * from employee ;";
		//return (Map) jdbcTemplate.queryForList(query);
		List<Map<String, Object>> retList = jdbcTemplate.queryForList(query);
		return  retList;
	}
	
	
	
}
