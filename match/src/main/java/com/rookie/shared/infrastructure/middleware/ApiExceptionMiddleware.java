package com.rookie.shared.infrastructure.middleware;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.NestedServletException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rookie.shared.domain.ApiController;
import com.rookie.shared.domain.bus.command.error.CommandHandlerExecutionError;
import com.rookie.shared.domain.bus.query.error.QueryHandlerExecutionError;
import com.rookie.shared.domain.error.DomainError;
import com.rookie.shared.infrastructure.HttpResponse;
@Service
public final class ApiExceptionMiddleware implements Filter {
    private RequestMappingHandlerMapping mapping;

    public ApiExceptionMiddleware(RequestMappingHandlerMapping mapping) {
        this.mapping = mapping;
    }

    @Override
    public void doFilter(
        ServletRequest request,
        ServletResponse response,
        FilterChain chain
    ) throws ServletException {
        HttpServletRequest  httpRequest  = ((HttpServletRequest) request);
        HttpServletResponse httpResponse = ((HttpServletResponse) response);

        try {

        	try {
        	  chain.doFilter(request, response);
        	} catch (NestedServletException exception) {
        		Object possibleController = (
        			    (HandlerMethod) Objects.requireNonNull(
        				  mapping.getHandler(httpRequest)).getHandler()
        			    ).getBean();
        	  if (possibleController instanceof ApiController) {
        	    handleCustomError(response, httpResponse, (ApiController) possibleController, exception);
        	  } else {
        	    throw new ServletException(exception);
        	  }
        	}
            } catch (Exception e) {
        	throw new ServletException(e);
            }
          }

    private void handleCustomError(
        ServletResponse response,
        HttpServletResponse httpResponse,
        ApiController possibleController,
        NestedServletException exception
    ) throws IOException {
        HashMap<Class<? extends DomainError>, HttpStatus> errorMapping = possibleController
            .errorMapping();
        Throwable error = (
            exception.getCause() instanceof CommandHandlerExecutionError ||
            exception.getCause() instanceof QueryHandlerExecutionError
        )
            ? exception.getCause().getCause() : exception.getCause();

        int    statusCode   = statusFor(errorMapping, error);
        String errorMessage = error.getMessage();

        httpResponse.reset();
        httpResponse.setHeader("Content-Type", "application/json");
        httpResponse.setStatus(statusCode);
        PrintWriter writer = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String json;

        List<String> listaErrores = new ArrayList<String>();
        listaErrores.add(errorMessage);
        json =  mapper.writeValueAsString(HttpResponse.responseWithError(statusCode, listaErrores));
        writer.write(json);
        writer.close();
    }

    private int statusFor(HashMap<Class<? extends DomainError>, HttpStatus> errorMapping, Throwable error) {
        return errorMapping.getOrDefault(error.getClass(), HttpStatus.INTERNAL_SERVER_ERROR).value();
    }
}