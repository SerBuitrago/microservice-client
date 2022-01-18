package com.pragma.infrastructure.util;

public class PragmaVariable {

	public static final String METHOD_FIND_BY_ID = "/{id}";
	public static final String METHOD_FIND_ALL = "";
	public static final String METHOD_SAVE = "";
	public static final String METHOD_DELETE_BY_ID = "/{id}";

	public static final String ENDPOINT_CONTROLLER = "api";
	
	public static final String ENDPOINT_CONTROLLER_CLIENT = ENDPOINT_CONTROLLER + "/client";
	public static final String ENDPOINT_CONTROLLER_CLIENT_METHOD_FIND_BY_ID = METHOD_FIND_BY_ID;
	public static final String ENDPOINT_CONTROLLER_CLIENT_METHOD_FIND_ALL = METHOD_FIND_ALL;
	public static final String ENDPOINT_CONTROLLER_CLIENT_METHOD_DELETE_BY_ID = METHOD_DELETE_BY_ID;
	
	public static final String ENDPOINT_CONTROLLER_IMAGE_MYSQL = ENDPOINT_CONTROLLER + "/image/mysql";
	public static final String ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_FIND_BY_ID = METHOD_FIND_BY_ID;
	public static final String ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_FIND_ALL = METHOD_FIND_ALL;
	public static final String ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_DELETE_BY_ID = METHOD_DELETE_BY_ID;
	
	public static final String ENDPOINT_CONTROLLER_IMAGE_MONGODB = ENDPOINT_CONTROLLER + "/image/mongodb";
	public static final String ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_FIND_BY_ID = METHOD_FIND_BY_ID;
	public static final String EENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_FIND_ALL = METHOD_FIND_ALL;
	public static final String ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_DELETE_BY_ID = METHOD_DELETE_BY_ID;
}
