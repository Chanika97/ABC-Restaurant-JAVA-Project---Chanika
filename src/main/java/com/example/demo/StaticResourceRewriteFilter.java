package com.example.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StaticResourceRewriteFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String requestURI = httpRequest.getRequestURI();

        // Check if URL needs rewriting
        if (!requestURI.endsWith(".html") && !requestURI.contains(".")) {
            requestURI += ".html";
        }

        // Serve static resources
        RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(requestURI);
        dispatcher.forward(httpRequest, httpResponse);
    }

    @Override
    public void destroy() {
    }
}
