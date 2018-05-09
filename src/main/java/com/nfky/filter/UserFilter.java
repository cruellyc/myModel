package com.nfky.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;

import com.nfky.util.Profile;

/**
* 用户登录过滤
* @author liyc
* @version 创建时间：2018年5月4日 下午3:00:53
*/
public class UserFilter implements Filter {

	private Logger logger=Logger.getLogger(this.getClass());
	@Autowired
	private Profile profile;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		String uri=request.getRequestURI();
		if(uri.indexOf("/login")>0){
			setMdcMobile(logger,"00000000000",req.getRemoteAddr());
			chain.doFilter(req, res);
		}else{
			if(profile!=null && profile.getId()>0){
				setMdcMobile(logger,profile.getMobile(),req.getRemoteAddr());
			}else{
				setMdcMobile(logger,"00000000000",req.getRemoteAddr());
				logger.info("**************未登录***************");
				HttpServletResponse response=(HttpServletResponse) res;
				outResponse(response,"{\"success\":true,\"code\":0,\"desc\":\"未登录\",\"items\":null}");
				return;
			}
			
			logger.info("****uri:"+uri);
			logger.info("**************param***************");
			Enumeration enu=req.getParameterNames();
			while(enu.hasMoreElements()){
				String paraName=(String)enu.nextElement();
				logger.info(paraName+": "+req.getParameter(paraName));
			}
			logger.info("**********************************");
			
			chain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 输出Ajax响应
	 * @param response
	 * @param str
	 */
	private void outResponse(HttpServletResponse response, String str) {
		PrintWriter out = null;
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
			out = response.getWriter();
			out.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 设置登录号码及输出ip
	 * @param logger
	 * @param mobile
	 * @param ip
	 */
	private void setMdcMobile(Logger logger,String mobile,String ip){
		MDC.put("userId", mobile);
		logger.info("****ip:"+ip);
	}

}
