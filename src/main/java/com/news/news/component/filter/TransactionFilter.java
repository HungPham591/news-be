package com.news.news.component.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@Component
//@Order(1)
public class TransactionFilter implements Filter {
    private final static Logger logger = LoggerFactory.getLogger(TransactionFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        logger.info("Initializing TransactionFilter :{}", this);
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            logger.info("Starting Transaction for req :{}", req.getRequestURI());
            chain.doFilter(request, response);
            logger.info("Committing Transaction for req :{}", req.getRequestURI());
        } catch (Exception e) {
            System.out.println("transaction filter error");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        logger.info("Destroying TransactionFilter :{}", this);
    }
}