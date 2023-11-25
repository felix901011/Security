package ncu.cc.oauthclient.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
    @RequestMapping("/")
    public String home() {
        return "home";
    }

//    @RequestMapping("/user")
//    public String user() {
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication instanceof OAuth2AuthenticationToken) {
//            final var token = (OAuth2AuthenticationToken) authentication;
//            token.getPrincipal().getAttributes().forEach((k, v) -> {
//                System.out.printf("%s : %s\n", k, v); 
//            });
//        }
//        return "user";
//    }
    @RequestMapping("/user")
    public String user(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (authentication instanceof OAuth2AuthenticationToken) {
            final var token = (OAuth2AuthenticationToken) authentication;
            token.getPrincipal().getAttributes().forEach((k, v) -> {
                System.out.printf("%s : %s\n", k, v);
            });
            
            // 傳遞一些用戶信息到視圖
            model.addAttribute("userName", token.getName());
        }
        
        return "userLoggedInPage"; // 返回用戶登入成功的視圖
    }


    @RequestMapping("/about")
    public String about() {
        return "about";
    }
}
