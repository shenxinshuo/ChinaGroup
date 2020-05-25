package com.zhbit.findwork.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.findwork.dao.AdvertiseDao;
import com.zhbit.findwork.entity.Advertise;
import com.zhbit.findwork.entity.Business;
import com.zhbit.findwork.entity.Cv;
import com.zhbit.findwork.entity.Post;
import com.zhbit.findwork.entity.User;
import com.zhbit.findwork.service.AdvertiseService;
import com.zhbit.findwork.service.BusinessService;
import com.zhbit.findwork.service.CvService;
import com.zhbit.findwork.service.PostService;

public class AdvertiseAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private Advertise advertise;
	private AdvertiseService advertiseService;
	private PostService postService;
	private String message;				//用于返回信息给页面，提示用户
	private String errorMessage;		//显示异常信息
	private CvService cvService;
	private int cid;
	private int currentPage;
	private int lines;             //总条数
	private int totalPages; 
	private List<Cv> cvs;
	private List<String> plist;
	private static int page_line = 5;
	private int firstResult;
	
	public void addAdvertise(){
		/*HttpServletResponse response=ServletActionContext.getResponse(); 
		response.setContentType("text/html;charset=utf-8"); */
		// PrintWriter out = null;
		Business b =  (Business) ServletActionContext.getRequest().getSession().getAttribute("LOGINED_USER");
		//advertise.setCity(b.getCity());
		
		System.out.println(advertise.getCity());
		
		
		
//		advertise.setBusiness(b);
//		advertise.setBid(b.getId());
//		advertise.setBusinessName(b.getName());
//		Post p = postService.getPostByID(advertise.getPost().getPid());
//		advertise.setPost(p);
//		advertise.setPostName(p.getPname());
//		try {
//			advertiseService.addAdvertese(advertise);
//			//out = response.getWriter();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		/* out.println("success"); 
		 out.flush(); 
		 out.close(); */
	}
	
	public String showReceivedCV(){
		
		//投递总数
		lines = advertiseService.getCVCountOfAdvertise(advertise.getId());
		plist = new ArrayList<String>();
		
		for(int i=0,j=0;i<lines;i+=5,j++){
			plist.add(String.valueOf(j+1));
		}
		
		totalPages = plist.size();
		if(currentPage == 0){
			currentPage = 1;
		}
		firstResult = (currentPage-1)*page_line;
		cvs = advertiseService.getCVOfAdvertise(advertise.getId(), firstResult, page_line);
		return "showReceivedCV";
		
	}
	
	public String toUnFinAdvertise(){
		Business b =  (Business) ServletActionContext.getRequest().getSession().getAttribute("LOGINED_USER");
		Advertise advertise = new Advertise();
		advertise.setCheck(0);
		advertise.setDeleteFlag(0);
		advertise.setBid(b.getId());
		List<Advertise>  l = advertiseService.getAdvertiseByExample(advertise);
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("list", l);
		return "toUnFinAdvertise";
	}
	
	public void deleteAdvertise(){
		try {
			advertiseService.deleteAdvertiseByID(advertise.getId());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public String toUpdateAdvertise(){
		int check = advertise.getCheck();
		advertise = advertiseService.getAdvertiseByID(advertise.getId());
		advertise.setCheck(check);
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("advertise", advertise);
		List<Map<String,String>> l = new ArrayList<Map<String,String>>();
		Map<String, String> m = new HashMap<String, String>();
		m.put("name", "全职");
		m.put("value", "全职");
		l.add(m);
		m = new HashMap<String, String>();
		m.put("name", "实习");
		m.put("value", "实习");
		l.add(m);
		m = new HashMap<String, String>();
		m.put("name", "兼职");
		m.put("value", "兼职");
		l.add(m);
		req.setAttribute("advertiseType", l);
		req.setAttribute("isEdit", 1);
		return "toUpdateAdvertise";
	}
	
	
	public void updateAdvertise(){
		try {
			/*Business b =  (Business) ServletActionContext.getRequest().getSession().getAttribute("LOGINED_USER");
			advertise.setCity(b.getCity());
			advertise.setBusiness(b);
			advertise.setBid(b.getId());
			advertise.setBusinessName(b.getName());*/
			advertiseService.updateAdvertese(advertise);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public String toFinAdvertise(){
		Business b =  (Business) ServletActionContext.getRequest().getSession().getAttribute("LOGINED_USER");
		Advertise advertise = new Advertise();
		advertise.setCheck(1);
		advertise.setDeleteFlag(0);
		advertise.setBid(b.getId());
		List<Advertise>  l = advertiseService.getAdvertiseByExample(advertise);
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("list", l);
		return "toFinAdvertise";
	}
	
	public String detailAdvertise(){
		Advertise  as =  advertiseService.getAdvertiseByID(advertise.getId());
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("as", as);
		//Business b =  (Business) ServletActionContext.getRequest().getSession().getAttribute("LOGINED_USER");
		/*User user= new User();
		user.setId(1);
		ActionContext ac = ActionContext.getContext();
		  ac.getSession().put("LOGINED_USER", user);*/
		//User user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
		Integer s = (Integer) ActionContext.getContext().getSession().get("LOGINED_ROLE");
		int isUser = 9;
		if(s==2){
			isUser=1;
			List<Cv> cvs = new ArrayList<Cv>();
			req.setAttribute("cvs", cvs);
		}
		if(s==1){
			isUser=0;
			User user=(User)ActionContext.getContext().getSession().get("LOGINED_USER");
			List<Cv> cvs = cvService.getCvListByUserId(user.getId());
			req.setAttribute("cvs", cvs);
		}
		req.setAttribute("isUser", isUser);
		return "detailAdvertise";
	}
	
	
	public void toudiAdvertise(){
		Cv c = cvService.getCvByID(cid);
		Advertise as =  advertiseService.getAdvertiseByID(advertise.getId());
		/*Advertise as =  new Advertise();
		Post p = new Post();
		p.setPid(1);
		as.setPost(p);*/
		Set<Cv> set =  as.getCvs(); 
		set.add(c);
		as.setCvs(set);
		try {
			advertiseService.updateAdvertese(as);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public String getCvs(){
		Advertise as =  advertiseService.getAdvertiseByID(advertise.getId());
		Set<Cv> set = as.getCvs();
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("set", set);
		req.setAttribute("sets", set.size());
		return "getCvs";
	}
	
	public String toAddAdvertise(){
		List<Post> posts = postService.getAllPost();
		HttpServletRequest req = ServletActionContext.getRequest();
		List<Map<String,Object>> l = new ArrayList<Map<String,Object>>();
		for (Post p : posts) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("value", p.getPid());
			map.put("name", p.getPname());
			l.add(map);
		}
		req.setAttribute("l", l);
		return "toAddAdvertise";
	}
	
	public String toAdd(){
		return "toAdd";
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
	public Advertise getAdvertise() {
		return advertise;
	}
	public void setAdvertise(Advertise advertise) {
		this.advertise = advertise;
	}
	public AdvertiseService getAdvertiseService() {
		return advertiseService;
	}
	public void setAdvertiseService(AdvertiseService advertiseService) {
		this.advertiseService = advertiseService;
	}

	public void setCvService(CvService cvService) {
		this.cvService = cvService;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}



	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getLines() {
		return lines;
	}

	public void setLines(int lines) {
		this.lines = lines;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<String> getPlist() {
		return plist;
	}

	public void setPlist(List<String> plist) {
		this.plist = plist;
	}

	public static int getPage_line() {
		return page_line;
	}

	public static void setPage_line(int page_line) {
		AdvertiseAction.page_line = page_line;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public PostService getPostService() {
		return postService;
	}

	public CvService getCvService() {
		return cvService;
	}

	public void setCvs(List<Cv> cvs) {
		this.cvs = cvs;
	}
	
}
