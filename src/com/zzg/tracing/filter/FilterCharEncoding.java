package com.zzg.tracing.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "FilterCharEncoding", urlPatterns = {"/*"})
public class FilterCharEncoding implements Filter {

    private String charEncoding = "utf-8";

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        System.out.println("==========FilterOne开始执行dofilter方法====");
        if (!charEncoding.equals(req.getCharacterEncoding())) {
            req.setCharacterEncoding(charEncoding);
        }
        resp.setCharacterEncoding(charEncoding);
        chain.doFilter(req, resp);
//        System.out.println("==========FilterOne结束执行dofilter方法====");
    }

    public void init(FilterConfig config) throws ServletException {


    }

}
