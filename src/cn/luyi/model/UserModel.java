package cn.luyi.model;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.luyi.domain.User;
import cn.luyi.utils.JDBCUtils;

/**
 * �������ݵ�JavaBean
 * @author luyi
 *
 */
public class UserModel {
	
	public User login(User user) throws SQLException{
		//�������ݿ⣺ͨ��������û���������ȥ���ݿ��н��в�ѯ
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		User exitUser = queryRunner.query("select * from user where username = ? and password = ?",
				new BeanHandler<User>(User.class), user.getUsername(), user.getPassword());
		return exitUser;
	}	
	
}
