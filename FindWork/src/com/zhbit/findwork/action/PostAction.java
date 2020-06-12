package com.zhbit.findwork.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ResolverUtil.NameEndsWith;
import com.zhbit.findwork.entity.Post;
import com.zhbit.findwork.entity.PostVo;
import com.zhbit.findwork.entity.Post_type;
import com.zhbit.findwork.service.PostService;
import com.zhbit.findwork.service.Post_typeService;


public class PostAction extends ActionSupport{
	
	private PostService postService;
	private Post_typeService post_typeService;

	private Post post;
	private PostVo postVo;
	private List<Post> posts;
	private List<Post_type> postTypes;
	private String ptype;
	private String message;//提示信息
	private String errorMessage;//错误提示信息
	private int currentPage;       //当前处于第几页
	private int lines;             //总条数
	private int totalPages;        //
	private List<String> plist;
	private static int page_line = 6;
	private int firstResult;

	/**
	 * 添加岗位表单验证
	 */
	public void validateAdd() {
		if (post.getPname() == null || "".equals(post.getPname())) {
			addFieldError("post.name", "岗位名称不能为空");
		} else {
			if (post.getPname().length()>20) {
				this.addFieldError("post.name", "岗位名称长度不能超过20");
			}
		}
	}
	
	//新增岗位
	public String add(){
		Post_type post_type = new Post_type();
		post_type.setPTid(Integer.parseInt(ptype));
		post.setPtype(post_type);
		int result = postService.addPost(post);
		if (result == 0) {
			//数据库中已有该角色
			errorMessage = "数据库中已有该岗位";
			return "showAdd";
		} else if (result == 1) {
			//插入成功
			message = "岗位新增成功";
			posts = postService.getAllPost();
			return "showAllPosts";
		}
		return "showAllRoles";
	}
	
	//跳转新增岗位页面
	public String toAddPost(){
		postTypes = post_typeService.getAllPost_type();
		return "toAddPost";
	}
	
	//跳转修改岗位列表页面
	public String toUpdatePost(){
		lines = postService.getCountByCheckFlag(0);
		plist = new ArrayList<String>();
		System.out.println("size:"+lines);
		for(int i=0,j=0;i<lines;i+=6,j++){
			plist.add(String.valueOf(j+1));
		}
		
		totalPages = plist.size();
		if(currentPage == 0){
			currentPage = 1;
		}
		firstResult = (currentPage-1)*page_line;
		posts = postService.getPostsByPageWithCheck(firstResult, page_line, 0);
		return "toUpdatePost";
	}
	
	//跳转修改岗位页面
	public String showUpdatePost(){
		post = postService.getPostByID(post.getPid());
		postVo = new PostVo(post.getPname(), post.getComment(), post.getPid());
		postTypes = post_typeService.getAllPost_type();
		return "showUpdatePost";
	}
	
	/**
	 * 修改岗位表单验证
	 */
	public void validateUpdate() {
		if (postVo.getPname() == null || "".equals(postVo.getPname())) {
			addFieldError("post.name", "岗位名称不能为空");
		} else {
			if (postVo.getPname().length()>20) {
				this.addFieldError("post.name", "岗位名称长度不能超过20");
			}
		}
	}
	
	//修改岗位
	public String update(){
		System.out.println("post:"+post.getPid()+"---"+postVo.getPname()+"--"+postVo.getComment());
		post.setPname(postVo.getPname());
		post.setComment(postVo.getComment());
		postService.updatePost(post);
		
		lines = postService.getCountByCheckFlag(0);
		plist = new ArrayList<String>();
		System.out.println("size:"+lines);
		for(int i=0,j=0;i<lines;i+=6,j++){
			plist.add(String.valueOf(j+1));
		}
		
		totalPages = plist.size();
		if(currentPage == 0){
			currentPage = 1;
		}
		firstResult = (currentPage-1)*page_line;
		posts = postService.getPostsByPageWithCheck(firstResult, page_line, 0);
		
		return "toUpdatePost";
	}
	
	//删除岗位
	public String deletePost(){
		System.out.println(post.getPid());
		
		postService.deletePost(post.getPid());
		
		lines = postService.getCountByCheckFlag(0);
		plist = new ArrayList<String>();
		System.out.println("size:"+lines);
		for(int i=0,j=0;i<lines;i+=6,j++){
			plist.add(String.valueOf(j+1));
		}
		
		totalPages = plist.size();
		if(currentPage == 0){
			currentPage = 1;
		}
		firstResult = (currentPage-1)*page_line;
		posts = postService.getPostsByPageWithCheck(firstResult, page_line, 0);
		
		return "deletePost";
	}
	
	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public PostVo getPostVo() {
		return postVo;
	}

	public void setPostVo(PostVo postVo) {
		this.postVo = postVo;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
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

	public List<Post_type> getPostTypes() {
		return postTypes;
	}

	public void setPostTypes(List<Post_type> postTypes) {
		this.postTypes = postTypes;
	}

	public Post_typeService getPost_typeService() {
		return post_typeService;
	}

	public void setPost_typeService(Post_typeService post_typeService) {
		this.post_typeService = post_typeService;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
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
		PostAction.page_line = page_line;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

}
