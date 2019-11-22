package hello;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import java.util.List;
import hello.entities.*;
import hello.repositories.*;

@ControllerAdvice
public class AuthControllerAdvice {

    @Autowired   
    private MembershipService membershipService;

    @Autowired
    private UserRepository userRepository;

    @ModelAttribute("isLoggedIn")
    public boolean getIsLoggedIn(OAuth2AuthenticationToken token){
        return token != null;
    }

    @ModelAttribute("id")
    public String getUid(OAuth2AuthenticationToken token){
        if (token == null) return "";
        System.out.println("1");
        String uid = token.getPrincipal().getAttributes().get("id").toString();
        // System.out.println("2");
        // List<AppUser> users = userRepository.findByUid(uid);
        // System.out.println("3");
        // if (users.size()==0) {
        //     System.out.println("4");
        //     AppUser u = new AppUser();
        //     System.out.println("5");
        //     u.setUid(uid);
        //     System.out.println("6");
        //     u.setLogin(token2login(token));
        //     System.out.println("7");
        //     userRepository.save(u);
        //     System.out.println("8");
        // }

        return uid;
    }

    @ModelAttribute("login")
    public String getLogin(OAuth2AuthenticationToken token){
        if (token == null) return "";
        return token2login(token);
    }

    @ModelAttribute("isMember")
    public boolean getIsMember(OAuth2AuthenticationToken token){
        return membershipService.isMember(token);
    }
    @ModelAttribute("isAdmin")
    public boolean getIsAdmin(OAuth2AuthenticationToken token){
        return membershipService.isAdmin(token);
    }

    @ModelAttribute("role")
    public String getRole(OAuth2AuthenticationToken token){
        return membershipService.role(token);
    }

    private String token2login(OAuth2AuthenticationToken token) {
        return token.getPrincipal().getAttributes().get("login").toString();
    }

}