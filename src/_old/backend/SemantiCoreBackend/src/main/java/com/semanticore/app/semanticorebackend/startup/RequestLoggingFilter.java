package com.semanticore.app.semanticorebackend.startup;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RequestLoggingFilter extends HttpFilter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        super.init(filterConfig);
        System.out.println("Request logging filter initialized.");
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Log incoming request
        System.out.println("Incoming request: " + request.getMethod() + " " + request.getRequestURI());

        // Continue with the filter chain
        chain.doFilter(request, response);

        // Log response status after request has been processed
        System.out.println("Response status: " + response.getStatus());
    }
}

