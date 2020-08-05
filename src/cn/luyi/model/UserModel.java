package cn.luyi.model;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.luyi.domain.User;
import cn.luyi.utils.JDBCUtils;

/**
 * 处理数据的JavaBean
 * @author luyi
 *
 */
public class UserModel {
	
	public User login(User user) throws SQLException{
		//连接数据库：通过传入的用户名和密码去数据库中进行查询
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		User exitUser = queryRunner.query("select * from user where username = ? and password = ?",
				new BeanHandler<User>(User.class), user.getUsername(), user.getPassword());
		return exitUser;
	}	
	
}
