package com.siwei.frame.user.provider.intercepter;

import com.siwei.frame.user.provider.util.RedisOperator;
import com.siwei.frame.common.utils.entity.User;
import com.siwei.frame.common.utils.enums.ExceptionResultEnum;
import com.siwei.frame.common.utils.exception.CommonException;
import com.siwei.frame.common.utils.helper.GlobalConstant;
import com.siwei.frame.common.utils.util.AntPathMatcher;
import com.siwei.frame.common.utils.util.JWTUtil;
import com.siwei.frame.common.utils.util.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class TokenIntecepter implements HandlerInterceptor {
	
	@Autowired
	private RedisOperator redisOperator;
	
	private static final List<String> UN_CHECK_URIS = new ArrayList<>();
	static {
		UN_CHECK_URIS.add("/css/**");
		UN_CHECK_URIS.add("/fonts/**");
		UN_CHECK_URIS.add("/img/**");
		UN_CHECK_URIS.add("/js/**");
		UN_CHECK_URIS.add("/swagger-ui.html");
		UN_CHECK_URIS.add("/docs.html");
		UN_CHECK_URIS.add("/swagger-resources/**");
		UN_CHECK_URIS.add("/v2/**");
		UN_CHECK_URIS.add("/webjars/**");
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		try {
			String uri = ((HttpServletRequest) request).getRequestURI();
			for (String unCheckUri : UN_CHECK_URIS) {
				AntPathMatcher antPathMatcher = new AntPathMatcher();
				if (antPathMatcher.matches(unCheckUri, uri)) return true;
			}
			
			String token = ((HttpServletRequest) request).getHeader("token");
			if (StringUtils.isBlank(token)) {
				throw new CommonException(ExceptionResultEnum.UNAUTHORIZED);
			}

			Map<String, Object> claims = JWTUtil.parseJwt(token);
			String userJsonString = (String) claims.get("user");
			User user = JsonUtils.jsonToEntity(userJsonString, User.class);
			String rediskey = GlobalConstant.TOKEN_PREFIX + user.getId().toString() + "token";
			String redisToken = redisOperator.get(rediskey);
			if (StringUtils.isBlank(redisToken)) {
				throw new CommonException(ExceptionResultEnum.LOGIN_TIMEOUT_ERROR);
			} else if (!token.equals(redisToken)) {
				throw new CommonException(ExceptionResultEnum.TOKEN_VALIDATE_ERROR);
			}
			redisOperator.expire(rediskey, GlobalConstant.TOKEN_EXPIRE_SECOND * 60);
		} catch (IOException e) {
			e.printStackTrace();
			throw new CommonException(ExceptionResultEnum.TOKEN_ANALYSIS_ERROR);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
