package com.pragma.infrastructure.util;

public class PragmaVariable {
	
	public static final String MICROSERVICE_CLIENT = "pragma-client";
	public static final String MICROSERVICE_IMAGE_MYSQL = "pragma-image-mysql";
	public static final String MICROSERVICE_IMAGE_MONGODB = "pragma-image-mongodb";
	
	public static final String CIRCUIT_BREAKER_CLIENT = "pragmaClient";
	public static final String CIRCUIT_BREAKER_CLIENT_METHOD_SAVE = "fallBackSave";
	public static final String CIRCUIT_BREAKER_CLIENT_METHOD_DELETE = "fallBackDelete";

	public static final String METHOD_FIND_BY_ID = "/{id}";
	public static final String METHOD_FIND_ALL = "";
	public static final String METHOD_SAVE = "";
	public static final String METHOD_UPDATE = "";
	public static final String METHOD_DELETE_BY_ID = "/{id}";

	public static final String ENDPOINT_CONTROLLER = "api";
	
	public static final String ENDPOINT_CONTROLLER_CLIENT = ENDPOINT_CONTROLLER + "/client";
	public static final String ENDPOINT_CONTROLLER_CLIENT_METHOD_FIND_BY_ID = METHOD_FIND_BY_ID;
	public static final String ENDPOINT_CONTROLLER_CLIENT_METHOD_FIND_TYPE_AND_DOCUMENT = "/find/type/{type}/document/{document}";
	public static final String ENDPOINT_CONTROLLER_CLIENT_METHOD_FIND_ALL = METHOD_FIND_ALL;
	public static final String ENDPOINT_CONTROLLER_CLIENT_METHOD_FIND_ALL_HIGHER_OR_EQUALS_AGE = "/all/find/age/{age}";
	public static final String ENDPOINT_CONTROLLER_CLIENT_METHOD_FIND_ALL_TYPE = "/all/find/type/{type}";
	public static final String ENDPOINT_CONTROLLER_CLIENT_METHOD_SAVE = METHOD_SAVE;
	public static final String ENDPOINT_CONTROLLER_CLIENT_METHOD_UPDATE = METHOD_UPDATE;
	public static final String ENDPOINT_CONTROLLER_CLIENT_METHOD_DELETE_BY_ID = METHOD_DELETE_BY_ID;
	
	public static final String ENDPOINT_CONTROLLER_IMAGE_MYSQL = ENDPOINT_CONTROLLER + "/image/mysql";
	public static final String ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_FIND_BY_ID = METHOD_FIND_BY_ID;
	public static final String ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_FIND_ALL = METHOD_FIND_ALL;
	public static final String ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_SAVE = METHOD_SAVE;
	public static final String ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_UPDATE = METHOD_UPDATE;
	public static final String ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_DELETE_BY_ID = METHOD_DELETE_BY_ID;
	
	public static final String ENDPOINT_CONTROLLER_IMAGE_MONGODB = ENDPOINT_CONTROLLER + "/image/mongodb";
	public static final String ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_FIND_BY_ID = METHOD_FIND_BY_ID;
	public static final String ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_FIND_ALL = METHOD_FIND_ALL;
	public static final String ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_SAVE = METHOD_SAVE;
	public static final String ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_UPDATE = METHOD_UPDATE;
	public static final String ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_DELETE_BY_ID = METHOD_DELETE_BY_ID;
}
