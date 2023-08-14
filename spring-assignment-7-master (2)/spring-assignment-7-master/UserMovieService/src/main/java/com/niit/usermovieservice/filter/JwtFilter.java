package com.niit.usermovieservice.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        ServletOutputStream pw = response.getOutputStream();

        //expects the token to come from the header
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        // expects the token to come from header
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer")) {
            //If token is not coming than set the response status as UNAUTHORIZED
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            pw.println("Missing or invalid Token ");
            pw.close();
        } else {//extract token from the header  // checking for success in else part
            String jwtToken = authHeader.substring(7);//Bearer => 6+1 since token begins with Bearer
            //token validation
            String email = Jwts.parser().setSigningKey("mysecret").parseClaimsJws(jwtToken).getBody().getSubject();
            request.setAttribute("email", email);
            System.out.println("Email: " + email);
            // pass the claims in the request, allowing the flow of request and response
            filterChain.doFilter(request,response);
        }
        //pass the claims in the request, anyone wanting to
    }
}
