package ie.developer.JsonPostgresMybatis.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;

@Configuration
@MapperScan("ie.developer.JsonPostgresMybatis.mappers")
public class DatabaseConfig {
	
	@Bean
	public DataSource dataSourceConfig() throws IOException {
		DataSource embeddedPostgresDS = EmbeddedPostgres.builder()
                .start().getPostgresDatabase();
		return embeddedPostgresDS;
	}
	
	@Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSourceConfig());
        return factoryBean.getObject();
    }
	

}
