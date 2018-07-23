package credit.credit.handler;

import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.NonUniqueResultException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CustomFailureHandler extends SimpleUrlAuthenticationFailureHandler implements AccessDeniedHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (exception.getClass().isAssignableFrom(DisabledException.class)) {
            response.sendRedirect("/verifyError");
        } else if (exception.getClass().isAssignableFrom(BadCredentialsException.class)) {
            response.sendRedirect("/inccorectError");
        } else if (exception.getClass().isAssignableFrom(NonUniqueResultException.class)) {
            response.sendRedirect("/userUpdatePassError");
        } else if (exception.getClass().isAssignableFrom(ResourceNotFoundException.class)) {
            response.sendRedirect("/resource");
        }
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, org.springframework.security.access.AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Authentication auth
                = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {

        response.sendRedirect(request.getContextPath() + "/accessError");
    }
    }
    @Controller
    public class SpringExceptionExample {
        @ExceptionHandler(ResourceNotFoundException.class)
        public String handleResourceNotFoundException() {
            return "404";
        }

    }}
