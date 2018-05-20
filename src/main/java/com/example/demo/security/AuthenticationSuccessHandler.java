package com.example.demo.security;

import com.example.demo.model.dto.MyUserPrincipal;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengtao on 2/25/18.
 */
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private RequestCache requestCache = new HttpSessionRequestCache();
    private final ObjectMapper mapper;

    @Autowired
    AuthenticationSuccessHandler(MappingJackson2HttpMessageConverter messageConverter) {
        this.mapper = messageConverter.getObjectMapper();
    }

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
        HttpSession session = request.getSession();
        MyUserPrincipal authUser = (MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        response.setContentType("application/json");
        Map<String, Object> authSuccessMap = new HashMap<String, Object>();
        authSuccessMap.put("authenticated", true);
        authSuccessMap.put("username", authUser.getUsername());
        authSuccessMap.put("role", authUser.getAuthorities());
        PrintWriter writer = response.getWriter();
        mapper.writeValue(writer, authSuccessMap);
        writer.flush();

        //super.onAuthenticationSuccess( request, response, authentication );
        /*SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest == null) {
            clearAuthenticationAttributes(request);
            return;
        }
        String targetUrlParam = getTargetUrlParameter();
        if (isAlwaysUseDefaultTargetUrl() || (targetUrlParam != null && StringUtils.hasText(request.getParameter(targetUrlParam)))) {
            requestCache.removeRequest(request, response);
            clearAuthenticationAttributes(request);
            return;
        }
        clearAuthenticationAttributes(request);
        */
    }

    public void setRequestCache(RequestCache requestCache) {
        this.requestCache = requestCache;
    }
}