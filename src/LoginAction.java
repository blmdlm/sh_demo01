import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author gejing gjblmdlm@sina.com
 * @version Creation Time：2014-6-22 下午3:03:12
 * 处理登陆页面的控制器
 */
public class LoginAction extends ActionSupport {
	
	private String userName;
	private String password;
	private List<UserInfoPO> list;
	private String message="input";
	@Override
	public String execute() throws Exception{
		return message;
	}
	/**
	 * 验证输入
	 */
	public void validate(){
		System.out.println("validate(): "+getUserName()+" "+getPassword());
		if(getUserName()==null||getUserName().length()==0){
			addFieldError("userName", "用户名不能为空");
		}else {
			LoginRegisterInfo info=new LoginRegisterInfo();
			list=info.queryInfo("userName",getUserName());
			if (list.size()==0) {
				addFieldError("userName", "该用户还未注册");
			}else {
				UserInfoPO ui=new UserInfoPO();
				int count=0;
				for (int i = 0; i < list.size(); i++) {
					count++;
					ui=list.get(i);
					if (getUserName().equals(ui.getUserName())) {
						if (ui.getPassword().equals(getPassword())) {
							message="success";
						}else {
							addFieldError("password", "密码错误");
						}
					}
				}
			}
		}
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}

}
