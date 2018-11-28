package com.siwei.frame.zuul.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.siwei.frame.common.utils.enums.ExceptionResultEnum;
import com.siwei.frame.common.utils.helper.ResponseBody;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class SecurityFilter extends ZuulFilter {

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        String token = request.getHeader("token");
        if(StringUtils.isBlank(token)) {
        	ResponseBody errorResponseBody = new ResponseBody(ExceptionResultEnum.UNAUTHORIZED);
        	ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody(JSON.toJSONString(errorResponseBody));
            ctx.getResponse().setContentType("application/json;charset=UTF-8");
            return ctx;
        }
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
