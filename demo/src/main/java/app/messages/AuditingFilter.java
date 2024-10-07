package app.messages;

import java.io.IOException;
import java.util.Date;

import org.springframework.web.filter.GenericFilterBean;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class AuditingFilter extends GenericFilterBean{
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
     throws IOException, ServletException {
        long start = new Date().getTime();
        chain.doFilter(req, res);
        long elapsed = new Date().getTime() - start;
        HttpServletRequest request = (HttpServletRequest) req;
        logger.debug("Request[uri=" + request.getRequestURI() + ", method ="+
         request.getMethod() + "] completed in " + elapsed + "ms");
     }
}
