package dev.hashnode.hpareek.oauth2clientserver.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @GetMapping("/self")
    public Map<String, String> getAuthenticatedUser(
        @AuthenticationPrincipal OAuth2User principal
    ) {
        Map<String, String> map = new HashMap<>();
        map.put("name", principal.getAttribute("given_name"));
        map.put("email", principal.getAttribute("email"));
        map.put("id", principal.getName());
        return map;
    }
}
