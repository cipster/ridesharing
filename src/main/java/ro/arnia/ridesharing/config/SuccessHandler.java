package ro.arnia.ridesharing.config;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import ro.arnia.ridesharing.domain.model.Person;
import ro.arnia.ridesharing.domain.model.repository.PersonRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    PersonRepository repository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JSONObject jsonResponse = new JSONObject();
        String username = ((User)authentication.getPrincipal()).getUsername();
        Person person = repository.findByUser(username);

        try {
            jsonResponse.put("Welcome", username );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        response.getWriter().write(jsonResponse.toString());
    }
}
