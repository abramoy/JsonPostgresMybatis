package ie.developer.JsonPostgresMybatis.config;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ie.developer.JsonPostgresMybatis.model.Address;
import ie.developer.JsonPostgresMybatis.model.Customer;

@MappedJdbcTypes(JdbcType.OTHER)
@MappedTypes(Address.class)
public class JsonTypeHandler extends BaseTypeHandler<Customer> {

	ObjectMapper objMapper = new ObjectMapper();

  @Override
  public Customer getNullableResult(ResultSet rs, String columnName)
    throws SQLException {
	  Customer customer = null;
    try {
    	customer =  objMapper.readValue(rs.getString(columnName), Customer.class);
	} catch (JsonProcessingException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return customer;
  }

  @Override
  public Customer getNullableResult(ResultSet rs, int columnIndex)
    throws SQLException {
	  Customer customer = null;
	    try {
	    	customer =  objMapper.readValue(rs.getString(columnIndex), Customer.class);
		} catch (JsonProcessingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return customer;
  }

  @Override
  public Customer getNullableResult(CallableStatement cs, int columnIndex)
    throws SQLException {
	  Customer customer = null;
	    try {
	    	customer =  objMapper.readValue(cs.getString(columnIndex), Customer.class);
		} catch (JsonProcessingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return customer;
  }


@Override
public void setNonNullParameter(PreparedStatement ps, int i, Customer parameter, JdbcType jdbcType)
		throws SQLException {
	System.out.println("Hellos");
	
}
}
