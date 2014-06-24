import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 * @author gejing gjblmdlm@sina.com
 * @version Creation Time：2014-6-22 下午3:39:09
 * 将登陆和注册业务功能封装到该类
 */
public class LoginRegisterInfo {

	private Session session;
	private Transaction transaction;
	private Query query;
	HibernateSessionFactory hsf;
	
	
	public LoginRegisterInfo(){
		
	}
	
	public String saveInfo(UserInfoPO info){
		String mess="error";
		hsf=new HibernateSessionFactory();
		session=hsf.getSession();
		try{
		transaction=session.beginTransaction();
		session.save(info);
		transaction.commit();
		mess="success";
		return mess;
		}catch(Exception e){
			message("RegisterInfo.error"+e);
			e.printStackTrace();
			return mess;
		}
	
	}
	
	public List<UserInfoPO> queryInfo(String type,Object value){
		System.out.println("正在查询。。。"+value);
		hsf=new HibernateSessionFactory();
		session=hsf.getSession();
		try{
		String hqlsql="from UserInfoPO as u where u.userName=?";
		query=session.createQuery(hqlsql);
		query.setParameter(0, value);
		List list=query.list();
		if (null==list) {
			System.out.println("为空");
		}
		transaction=session.beginTransaction();
		transaction.commit();
		return list;
		}catch(Exception e){
			message("LoginRegisterInfo类中有异常"+e);
			e.printStackTrace();
			return null;
		}
	}
	
	
	public void message(String mess){
		int type=JOptionPane.YES_NO_OPTION;
		String title="提示信息";
		JOptionPane.showMessageDialog(null, mess,title,type);
	}
	

}













