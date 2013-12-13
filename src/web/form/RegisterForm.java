package web.form;

import java.util.HashMap;
import java.util.Map;

public class RegisterForm {
	private String username;
	private String password;
	private String password2;
	private String email;
	private Map<String, String> errors = new HashMap<String, String>();
	
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean validate() {
		boolean isOK = true;
		
		if(this.username==null || this.username.trim().equals("")){
			isOK = false;
			errors.put("username", "用户名不能为空！！");
		}else{
			if(!this.username.matches("[A-Za-z]{3,8}")){
				isOK = false;
				errors.put("username", "用户名必须要是3-8位字母！！");
			}
		}
		
		
		if(this.password==null || this.password.trim().equals("")){
			isOK = false;
			errors.put("password", "密码不能为空！！");
		}else{
			if(!this.password.matches("[a-zA-Z0-9]{3,8}")){
				isOK = false;
				errors.put("password", "密码必须要是3-8位数字或字母！！");
			}
		}
		
		if(this.password2==null || this.password2.trim().equals("")){
			isOK = false;
			errors.put("password2", "确认密码不能为空！！");
		}else{
			if(!this.password.equals(this.password2)){
				isOK = false;
				errors.put("password2", "两次密码要一致！！");
			}
		}
		
		
		//电子邮箱不能为空，并且要是一个格式合法的邮箱
		if(this.email==null || this.email.trim().equals("")){
			isOK = false;
			errors.put("email", "邮箱不能为空！！");
		}else{
			// aaa@sina.com  aaa@sina.com.cn   aa_bb.cc@sina.com.cn
			//  \\w+@\\w+(\\.\\w+)+
			if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
				isOK = false;
				errors.put("email", "邮箱格式不对！！！");
			}
		}
		
		return isOK;
		
	}
}
