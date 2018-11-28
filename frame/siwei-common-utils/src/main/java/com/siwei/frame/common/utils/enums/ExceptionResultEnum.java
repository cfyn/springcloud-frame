package com.siwei.frame.common.utils.enums;

/**
 * 异常类型枚举类
 * @author lxn
 * @date 2017年10月23日
 */
public enum ExceptionResultEnum {
	UNKNOW_ERROR(-1, "unknow error"),
	SUCCESS(200, "success"),
	SYSTEM_ERROR(500, "system error"),

	UNAUTHORIZED(401, "未认证,token为空"),
	PARAM_ERROR(402, "所需参数传入错误"),
	NO_PERMISSION(403, "没有权限访问"),
    NOT_FOUND(404, "接口不存在"),
    REQUEST_TIME_OUT(408, "请求超时"),
    ACCOUNT_NOT_EXIST(409, "账号不存在"),
    USERNAME_PASSWORT_ERROR(410, "用户名或密码错误"),
    USER_AUTHENTICATION_FALIED(411, "用户验证失败"),
    TOKEN_VALIDATE_ERROR(412, "token验证失败"),
    TOKEN_ANALYSIS_ERROR(413, "token解析失败"),
    CLASS_METHOD_ERROR(414, "反射获取方法失败"),
    UNKNOW_SYSTEM_CODE(415, "未知的系统码"),
    USER_HAVE_NO_MENU_PERMISSION(416, "用户没有菜单权限"),
    
    LOGIN_TIMEOUT_ERROR(420, "登陆超时，请重新登录"),
	
	DB_ERROR(421, "数据库执行错误"),
	DB_SAVE_ERROR(422, "数据库保存数据错误"),
	DB_UPDATE_ERROR(423, "数据库修改数据错误"),
	DB_DUPLICATE_ENTRY_EXIT_ERROR(424, "数据库中唯一标识已存在"),
	
	EXCEL_UPLOAD_FORMAT_ERROR(431, "Excel文件解析错误，请确认文件格式"),
	EXCEL_SHEET_ANALIZE_ERROR(432, "Excel文件页解析错误，请确认"),
	EXCEL_MODULE_ANALIZE_ERROR(433, "Excel文件表头列数解析错误"),
	EXCEL_WORKBOOK_ANALIZE_ERROR(434, "导入失败，Excel工作簿解析错误"),
	EXCEL_UPPER_LIMIT_ERROR(435, "总记录条数超上限，单次最大导入10000条，请分批处理"),
	EXCEL_FLOOR_LIMIT_ERROR(436, "文件中未获取到有效记录"),
	FILE_EXCEL_READ_ERROR(437, "excel文件读取出错,请检查表格数据"),
//	
//	LOGIN_ERROR(101, "登录错误"),
//	
//	DB_DUPLICATE_ENTRY_EXIT_ERROR(105, "唯一标识已存在"),
//	DB_DUPLICATE_ENTRY_NOT_EXIT_ERROR(106, "唯一标识传入错误"),
//	
//	FILE_NOT_UPLOAD_ERROR(301, "所需文件没有上传"),
//	FILE_NOT_EXIST_ERROR(302, "文件不存在"),
//	FILE_UPLOAD_ERROR(303, "文件上传出错"),
//	FILE_TYPE_ERROR(304, "上传文件类型出错"),
//	FILE_RESOLVER_ERROR(306, "文件转换错误"),
//	FILE_DOWNLOAD_ERROR(306, "文件下载错误"),
//	FILEDOWNLOAD_ERROR(307,"文件下载失败"),
	
	ANNOTATION_GET_ERROR(441, "获取权限注解内容错误"),
	PERMISSION_ANALYSIS_ERROR(442, "权限列表解析失败"),
	LOG_SAVE_ERROR(443, "日志保存错误"),
	
	NO_PERMISSION_ON_THIS_SYSTEM(451, "没有访问该系统的权限"),
    USERLOGIN_ALREADY_EXISTS(452, "用户登录信息已存在"),
    ROLE_CODE_ALREADY_EXISTS(453, "角色码已存在"),
    USER_UNENABLED(454, "用户已被禁用"),
    USER_HAS_NO_PERMISSION(455, "用户在该系统没有权限"),
	
	SERVER_ERROR(500, "服务器开小差，请稍后重试"),
	;

	private Integer code;
	private String message;

	private ExceptionResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}

