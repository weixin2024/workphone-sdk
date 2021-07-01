package com.jubotech.business.web.domain;

import java.io.Serializable;
import java.util.Date;

public class CircleInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String sourcewechatid;
	private String wechatid;
	private String wechatnickname;
	private String circleid;
	private String content;
	private String publishtime;
	private String thumbimages;
	private String images;
	private String link;
	private String videothumbimg;
	private String videourl;
	private String videodescription;
	private String videomediaid;
	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSourcewechatid() {
		return sourcewechatid;
	}

	public void setSourcewechatid(String sourcewechatid) {
		this.sourcewechatid = sourcewechatid;
	}

	public String getWechatid() {
		return wechatid;
	}

	public void setWechatid(String wechatid) {
		this.wechatid = wechatid;
	}

	public String getWechatnickname() {
		return wechatnickname;
	}

	public void setWechatnickname(String wechatnickname) {
		this.wechatnickname = wechatnickname;
	}

	public String getCircleid() {
		return circleid;
	}

	public void setCircleid(String circleid) {
		this.circleid = circleid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getVideothumbimg() {
		return videothumbimg;
	}

	public void setVideothumbimg(String videothumbimg) {
		this.videothumbimg = videothumbimg;
	}

	public String getVideourl() {
		return videourl;
	}

	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}

	public String getVideodescription() {
		return videodescription;
	}

	public void setVideodescription(String videodescription) {
		this.videodescription = videodescription;
	}

	public String getVideomediaid() {
		return videomediaid;
	}

	public void setVideomediaid(String videomediaid) {
		this.videomediaid = videomediaid;
	}
 
	public String getThumbimages() {
		return thumbimages;
	}

	public void setThumbimages(String thumbimages) {
		this.thumbimages = thumbimages;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
