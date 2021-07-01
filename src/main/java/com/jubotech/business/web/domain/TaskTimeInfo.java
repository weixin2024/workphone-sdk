package com.jubotech.business.web.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TaskTimeInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer accountid;
	private Integer cid;
	private Integer did;
	private Integer tasktype;// 任务类型1群发消息2发朋友圈
	private Integer state;// 状态1开启中0已完成
	private String execute_time;// 执行时间
	private Integer restype;// 资源类型(群发好友:0文字 1图片 ；朋友圈:0链接 2图片 3短视频)
	private String content;// 内容
	private String comment;// 针对发朋友圈
	private Integer attachtype;// 附件类型
	private String attachtcontent;// 附件内容
	private String whoinvisible;// 不给谁看
	private Date update_time;
	private Date createTime;

	//////////////////////////////
	private String dname;// 所属部门名称

	// pc端定时传参///////////////////
	private String wechatId;//（通用参数） 要执行的微信号
	private List<String> wechatList;// 要群发的微信号
	private Integer pageSize = 20;// 每页多少条
	private Integer pageNo = 1;// 当前第几页
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public Integer getTasktype() {
		return tasktype;
	}

	public void setTasktype(Integer tasktype) {
		this.tasktype = tasktype;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getExecute_time() {
		return execute_time;
	}

	public void setExecute_time(String execute_time) {
		this.execute_time = execute_time;
	}

	public Integer getRestype() {
		return restype;
	}

	public void setRestype(Integer restype) {
		this.restype = restype;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getAttachtype() {
		return attachtype;
	}

	public void setAttachtype(Integer attachtype) {
		this.attachtype = attachtype;
	}

	public String getWhoinvisible() {
		return whoinvisible;
	}

	public void setWhoinvisible(String whoinvisible) {
		this.whoinvisible = whoinvisible;
	}

 

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public String getAttachtcontent() {
		return attachtcontent;
	}

	public void setAttachtcontent(String attachtcontent) {
		this.attachtcontent = attachtcontent;
	}

	public List<String> getWechatList() {
		return wechatList;
	}

	public void setWechatList(List<String> wechatList) {
		this.wechatList = wechatList;
	}

	public String getWechatId() {
		return wechatId;
	}

	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}

	public Integer getAccountid() {
		return accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

}
