package com.karuturirs.gcp.webapp.filter;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


@Component
public class MDCFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request != null) {
            try {
                String requestId = (request.getHeader("RequestId") != null) ? request.getHeader("RequestId") : UUID.randomUUID().toString();
                String clientID = (request.getHeader("ClientId") != null) ? request.getHeader("ClientId") : "";
                MDC.put("RequestId", requestId);
                MDC.put("ClientId", clientID);
                filterChain.doFilter(request, response);
            } finally {
                MDC.remove("RequestId");
                MDC.remove("ClientId");
            }
        }

    }
}
