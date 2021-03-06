package com.aem.bala.core.models;

public class PageModel {
	private String pageName;
	private String pageTemplate;
	private String pageTitle;
	private String pageParent;
	private String pageDescreption;

	public PageModel() {
		super();

	}

	public PageModel(String pageName, String pageTemplate, String pageTitle, String pageParent) {
		super();
		this.pageName = pageName;
		this.pageTemplate = pageTemplate;
		this.pageTitle = pageTitle;
		this.pageParent = pageParent;
	}

	public String getPageDescreption() {
		return pageDescreption;
	}

	public void setPageDescreption(String pageDescreption) {
		this.pageDescreption = pageDescreption;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getPageTemplate() {
		return pageTemplate;
	}

	public void setPageTemplate(String pageTemplate) {
		this.pageTemplate = pageTemplate;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getPageParent() {
		return pageParent;
	}

	public void setPageParent(String pageParent) {
		this.pageParent = pageParent;
	}


}
