package com.project.webflux.application;

public  final class  StudentConstants {
	public static final String STUDENT = "student";
	public static final String STUDENT_ID_PATH_VARIABLE = "id";
	public static final String STUDENT_BY_ID = "/"+STUDENT+"/"+"{"+STUDENT_ID_PATH_VARIABLE+"}";
	public static final String ALL = "all";
	public static final String FIND_ALL = "/"+STUDENT+"/"+ALL;
	public static final Integer STUDENT_RETRIEVE_LIMIT= 100;
	public static final String INSERT = "insert";
	public static final String STUDENT_INSERT="/"+STUDENT+"/"+INSERT;
	public static final String FIRST_NAME="firstName";
	public static final String LAST_NAME= "lastName";
	public static final String GENDER = "gender";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String COURSE ="course";
	public static final String YEAR_OF_JOINING="yearOfJoining";
	public static final String IS_ACTIVE = "isActive";
	public static final String UPDATE="update";
	public static final String STUDENT_UPDATE_BY_ID = "/"+STUDENT+"/"+UPDATE+"/"+"{"+STUDENT_ID_PATH_VARIABLE+"}";
}
