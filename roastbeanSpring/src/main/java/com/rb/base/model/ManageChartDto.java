package com.rb.base.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
 
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
 
public class ManageChartDto {
 
	private static JdbcTemplate jdbcTemplate;
	static Map<Object,Object> map = null;
	static List<List<DataPointModel>> list = new ArrayList<List<DataPointModel>>();
	static List<DataPointModel> dataPoints1 = new ArrayList<DataPointModel>();
	
	static {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/roastbean");
        dataSource.setUsername("root");
        dataSource.setPassword("qwer1234");
        jdbcTemplate = new JdbcTemplate(dataSource);
	}
 
	public static class DataPointModel {
		int x;
		int y;
		
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
	}
	
	public static class DatabaseConnectionException  extends RuntimeException{
		
		private static final long serialVersionUID = 1L;
 
		public DatabaseConnectionException(String message) {
			super(message);
		}
	}
	//x 제품명 , y 판매량 
	private static void getDataPoints(){
		System.out.println("ManageChartDto START");
//        String sql = "select  x.order_date,  ifnull(y.n,0) as order_price from (select a.Date as order_date\n"
//        		+ "	    from (select curdate() - INTERVAL (a.a) DAY as Date from (select 0 as a union all select 1 union all select 2 union all select 3 union all select 4 union all select 5 union all select 6) as a) a)x left outer join \n"
//        		+ "		(SELECT date(order_date) as d,sum(order_qty) as c , sum(order_price) as n FROM orders  WHERE DATE(order_date) = curdate() group by date(order_date))y on x.order_date= y.d order by x.order_date;";
        String sql = "select product_id as x, sum(order_qty)as y from orders group by product_id;";
		
		System.out.println("ManageChartDto sql : "+sql);
        
        try {
        	dataPoints1 = jdbcTemplate.query(sql, new RowMapper<DataPointModel>() {
 
				@Override
				public DataPointModel mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	DataPointModel dataPoint = new DataPointModel();
	     
	            	dataPoint.setX(rs.getInt("order_date"));
	            	dataPoint.setY(rs.getInt("order_price"));
	     System.out.println("ManageChartDto dataPoint : "+dataPoint);
	                return dataPoint;
				}});
        }
        catch(Exception e){
        	dataPoints1 = null;
        	throw new DatabaseConnectionException("Error while getting dataPoints");
        }
		list.add(dataPoints1);
	}
	
	public static List<List<DataPointModel>> getCanvasjsDataList() {
		getDataPoints();
		return list;
	}
}               
