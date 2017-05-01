/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.Data;

/**
 *
 * @author delijo01
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginFilter implements Filter {

    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        ServletContext sc = filterConfig.getServletContext();
        
        String filterName = filterConfig.getFilterName();
        String servletPath = "Servlet path: " + httpRequest.getServletPath();
        
        sc.log(filterName + " | " + servletPath + " | before request");
        chain.doFilter(httpRequest, httpResponse);
        sc.log(filterName + " | " + servletPath + " | after request");
    }
    
    @Override
    public void destroy() {
        filterConfig = null;
    }
}

