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
			errors.put("username", "�û�������Ϊ�գ���");
		}else{
			if(!this.username.matches("[A-Za-z]{3,8}")){
				isOK = false;
				errors.put("username", "�û�������Ҫ��3-8λ��ĸ����");
			}
		}
		
		
		if(this.password==null || this.password.trim().equals("")){
			isOK = false;
			errors.put("password", "���벻��Ϊ�գ���");
		}else{
			if(!this.password.matches("[a-zA-Z0-9]{3,8}")){
				isOK = false;
				errors.put("password", "�������Ҫ��3-8λ���ֻ���ĸ����");
			}
		}
		
		if(this.password2==null || this.password2.trim().equals("")){
			isOK = false;
			errors.put("password2", "ȷ�����벻��Ϊ�գ���");
		}else{
			if(!this.password.equals(this.password2)){
				isOK = false;
				errors.put("password2", "��������Ҫһ�£���");
			}
		}
		
		
		//�������䲻��Ϊ�գ�����Ҫ��һ����ʽ�Ϸ�������
		if(this.email==null || this.email.trim().equals("")){
			isOK = false;
			errors.put("email", "���䲻��Ϊ�գ���");
		}else{
			// aaa@sina.com  aaa@sina.com.cn   aa_bb.cc@sina.com.cn
			//  \\w+@\\w+(\\.\\w+)+
			if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
				isOK = false;
				errors.put("email", "�����ʽ���ԣ�����");
			}
		}
		
		return isOK;
		
	}
}
