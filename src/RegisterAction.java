import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author gejing gjblmdlm@sina.com
 * @version Creation Time：2014-6-24 下午3:14:51
 * 注册页面对应的业务控制器
 */
public class RegisterAction extends ActionSupport{

	private String userName;
	private String password1;
	private String password2;
	private List<UserInfoPO> list;
	private String mess=INPUT;
	
	
	public void validate(){
		
		if (getUserName()==null||getUserName().length()==0) {
			addFieldError("userName", "用户名不能为空");
		}else {
			LoginRegisterInfo info=new LoginRegisterInfo();
			list=info.queryInfo("userName", getUserName());
			UserInfoPO ui=new UserInfoPO();
			for (int i = 0; i < list.size(); i++) {
				ui=list.get(i);
				if (ui.getUserName().equals(getUserName())) {
					addFieldError("userName", "该用户名已存在");
				}
			}
		}
		
		if (getPassword1()==null||getPassword1().length()==0) {
			addFieldError("password1", "密码不许为空");
		}else if (getPassword2()==null||getPassword2().length()==0) {
			addFieldError("password2", "重复密码不许为空");
		}else if(!getPassword1().equals(getPassword2())) {
			addFieldError("password2", "两次密码不一致");
		}
		
		
		
		
		
		
	}
	
	public String execute() throws Exception{
		LoginRegisterInfo lr=new LoginRegisterInfo();
		UserInfoPO ui=new UserInfoPO();
		ui.setPassword(getPassword1());
		ui.setUserName(getUserName());
		String ri=lr.saveInfo(ui);
		if ("success".equals(ri)) {
			mess=SUCCESS;
		}
		return mess;
	}
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	
	

}
