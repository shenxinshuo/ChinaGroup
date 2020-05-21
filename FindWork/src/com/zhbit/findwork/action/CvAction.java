package com.zhbit.findwork.action;
import java.io.File;
/**
 * ������Ϣaction��
 * @author ����ƽ
 * @date 2020��5��18��
 */
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.entity.Cv;
import com.zhbit.findwork.service.CvService;

public class CvAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private Cv cv;
	private CvService cvService;
	private String message;				//���ڷ�����Ϣ��ҳ�棬��ʾ�û�
	private String errorMessage;		//��ʾ�쳣��Ϣ
	ActionContext context = ActionContext.getContext();
	private List<Cv> list = new ArrayList<Cv>();
	
	public Cv getCv() {
		return cv;
	}
	public void setCv(Cv cv) {
		this.cv = cv;
	}
	public CvService getCvService() {
		return cvService;
	}
	public void setCvService(CvService cvService) {
		this.cvService = cvService;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public List<Cv> getList() {
		return list;
	}
	public void setList(List<Cv> list) {
		this.list = list;
	}
	//������Ϣ��֤
	public void validateAdd(){
		//�жϵ绰�����ʽ�Ƿ���ȷ���������ʽ
		String tel = "((^(13|15|18|17|19)[0-9]{9}$)|(^0[1,2]{1}\\d{1}-?\\d{8}$)|(^0[3-9] {1}\\d{2}-?\\d{7,8}$)|(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)|(^0[3-9]{1}\\d{2}-? \\d{7,8}-(\\d{1,4})$))";
		String na = "(^[0-9]*$)";
		if (cv.getName()==null||cv.getName().equals(na)||cv.getName().equals("")) {
			this.addFieldError("name", "�û�����ʽ����ȷ�����������ֳ��֣�");
			System.out.println("0");
		}
		if (!cv.getTelephone().matches(tel)) {
			this.addFieldError("telephone", "�ֻ������ʽ����ȷ");
		}
		if (cv.getWant_low_wages()==0 || cv.getWant_large_wages()==0) {
			this.addFieldError("want_low_wages", "������д����ȷ");
			this.addFieldError("want_large_wages", "������д����ȷ");
		}else if (cv.getWant_low_wages()>cv.getWant_large_wages()||cv.getWant_low_wages()<1000 ||cv.getWant_large_wages()>99999) {
			this.addFieldError("want_low_wages", "������д����ȷ");
			this.addFieldError("want_large_wages", "������д����ȷ");
		}
		if (cv.getPolitics_status()==null ||cv.getPolitics_status().equals("")) {
			this.addFieldError("politics_status", "������ò����Ϊ��");
		}
		if (cv.getEducation_background()==null||cv.getEducation_background().equals("")) {
			this.addFieldError("education_background", "ѧ������Ϊ��");
		}
		if (cv.getWant_post()==null || cv.getWant_post().equals("")) {
			this.addFieldError("want_post", "��ְ������Ϊ��");
		}
		if (cv.getLive_city()==null||cv.getLive_city().equals("")) {
			this.addFieldError("live_city", "��ס���в���Ϊ��");
		}
		if (cv.getLive_province()==null || cv.getLive_province().equals("")) {
			this.addFieldError("live_province", "��סʡ�ݲ���Ϊ��");
		}
		if (cv.getWant_joy_type()==null || cv.getWant_joy_type().equals("")) {
			this.addFieldError("want_joy_type", "�������Ͳ���Ϊ��");
		}
		if (cv.getWant_city()==null || cv.getWant_city().equals("")) {
			this.addFieldError("want_city", "��ȥ�ĳ��в���Ϊ��");
		}
		if (cv.getWant_province()==null || cv.getWant_province().equals("")) {
			this.addFieldError("want_province", "��ȥ��ʡ�ݲ���Ϊ��");
		}
	}
	/**
	 * ����������Ϣ
	 */
	public String add(){
		cv = cvService.getCvByID(1);
		boolean result = cvService.addCv(cv);
		if (result ) {
			message="���ӳɹ�";
			return "add";
		}else {
			errorMessage="���Ӳ��ɹ�";
			return "input";
		}
		
	}
	//�޸���Ϣ��֤
		public void validateUpdate(){
			//�жϵ绰�����ʽ�Ƿ���ȷ���������ʽ
			String tel = "((^(13|15|18|17|19)[0-9]{9}$)|(^0[1,2]{1}\\d{1}-?\\d{8}$)|(^0[3-9] {1}\\d{2}-?\\d{7,8}$)|(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)|(^0[3-9]{1}\\d{2}-? \\d{7,8}-(\\d{1,4})$))";
			String na = "(^[0-9]*$)";
			if (cv.getName()==null||cv.getName().equals(na)||cv.getName().equals("")) {
				this.addFieldError("name", "�û�����ʽ����ȷ�����������ֳ��֣�");
				System.out.println("0");
			}
			if (!cv.getTelephone().matches(tel)) {
				this.addFieldError("telephone", "�ֻ������ʽ����ȷ");
			}
			if (cv.getWant_low_wages()==0 || cv.getWant_large_wages()==0) {
				this.addFieldError("want_low_wages", "������д����ȷ");
				this.addFieldError("want_large_wages", "������д����ȷ");
			}else if (cv.getWant_low_wages()>cv.getWant_large_wages()||cv.getWant_low_wages()<1000 ||cv.getWant_large_wages()>99999) {
				this.addFieldError("want_low_wages", "������д����ȷ");
				this.addFieldError("want_large_wages", "������д����ȷ");
			}
			if (cv.getPolitics_status()==null ||cv.getPolitics_status().equals("")) {
				this.addFieldError("politics_status", "������ò����Ϊ��");
			}
			if (cv.getEducation_background()==null||cv.getEducation_background().equals("")) {
				this.addFieldError("education_background", "ѧ������Ϊ��");
			}
			if (cv.getWant_post()==null || cv.getWant_post().equals("")) {
				this.addFieldError("want_post", "��ְ������Ϊ��");
			}
			if (cv.getLive_city()==null||cv.getLive_city().equals("")) {
				this.addFieldError("live_city", "��ס���в���Ϊ��");
			}
			if (cv.getLive_province()==null || cv.getLive_province().equals("")) {
				this.addFieldError("live_province", "��סʡ�ݲ���Ϊ��");
			}
			if (cv.getWant_joy_type()==null || cv.getWant_joy_type().equals("")) {
				this.addFieldError("want_joy_type", "�������Ͳ���Ϊ��");
			}
			if (cv.getWant_city()==null || cv.getWant_city().equals("")) {
				this.addFieldError("want_city", "��ȥ�ĳ��в���Ϊ��");
			}
			if (cv.getWant_province()==null || cv.getWant_province().equals("")) {
				this.addFieldError("want_province", "��ȥ��ʡ�ݲ���Ϊ��");
			}
		}
	/**
	 * �޸ļ�����Ϣ
	 */
	public String update(){
		boolean result =  cvService.updateCv(cv);
		if (result) {
			//�޸ĳɹ�
			message = "�޸ĳɹ�";
			return "update";
		}else {
			return "error";
		}
		
	}
	/**
	 * ɾ��������Ϣ
	 */
	public String delete(){
		int id = cv.getId();
		cvService.deleteCvByID(id);	
		return "delete";
		
	}
	
	public String show(){
		cv = cvService.getCvByID(1);
		if (cv==null) {
			return "error";
		}else {
			return "show";
		}
	}
	
	public String showDetail(){
		int id = cv.getId();
		cv = cvService.getCvByID(id);
		return "showDetail";
	}

	
}