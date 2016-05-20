package com.mars.smarthouse.bean;

/**
 * Created by Administrator on 2016/5/9.
 */
public class Language {
	private static boolean cn = false;
	//ÖĞÎÄ
	private String zh = null;
	//Ó¢ÎÄ
	private String en = null;

	private Language() {

	}

	public Language(String en, String zh) {
		this.en = en;
		this.zh = zh;
	}

	public String get() {
		return cn ? zh : en;
	}

	public String getZH(){
		return this.zh;
	}

	public String getEn(){
		return this.en;
	}
}
