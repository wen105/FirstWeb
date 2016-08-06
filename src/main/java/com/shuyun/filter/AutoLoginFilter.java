package com.shuyun.filter;


import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by shuyun on 2016/8/3.
 */
public class AutoLoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        Object object=request.getSession().getAttribute("admin");
        if(object!=null){
            request.getRequestDispatcher("./sc.jsp").forward(request,response);
            return;
        }
        Cookie autoCookie=null;
        Cookie cookies[]=request.getCookies();
        if(cookies!=null){
            for (Cookie cookie:cookies){
                if ("autologin".equals(cookie.getName())){
                    autoCookie=cookie;
                }
            }

            if(autoCookie==null){
                filterChain.doFilter(request,response);
                return;
            }
            String value=autoCookie.getValue();
        }else{
            filterChain.doFilter(request,response);
        }

    }

    public void destroy() {

    }
}
