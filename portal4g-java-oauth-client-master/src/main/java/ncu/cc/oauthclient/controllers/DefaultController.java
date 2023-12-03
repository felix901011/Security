package ncu.cc.oauthclient.controllers;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
    @RequestMapping("/")
    public String home() {
        return "home";
    }
    
    
//    @RequestMapping("/user")
//    public String user(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication instanceof OAuth2AuthenticationToken) {
//            final var token = (OAuth2AuthenticationToken) authentication;
//
//            Map<String, Object> attributes = token.getPrincipal().getAttributes();
//            String chinesename = (String) attributes.get("chineseName");
//            //String academyRecordsName = (String) ((Map) attributes.get("academyRecords")).get("name");
//
//            // 將用戶屬性放入模型中
//            model.addAttribute("chineseName", chinesename);
//            //model.addAttribute("academyRecordsName", academyRecordsName);
//        }
//
//        return "user"; // 返回視圖名稱
//    }
    
//    
//    @RequestMapping("/about")
//    public String about() {
//        return "about";
//    }
    @RequestMapping("/user")
    public String user(Model model) {
    	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	
        //if (authentication != null) {
    	if (authentication instanceof OAuth2AuthenticationToken) {
            final var token = (OAuth2AuthenticationToken) authentication;
            Map<String, Object> attributes = token.getPrincipal().getAttributes();
            String chinesename = (String) attributes.get("chineseName");
            String academyRecordsName = (String) ((Map) attributes.get("academyRecords")).get("name");

            model.addAttribute("chineseName", chinesename);
            model.addAttribute("academyRecordsName", academyRecordsName);
            System.out.println(chinesename+"\n"+academyRecordsName);
            
            if (academyRecordsName != null && academyRecordsName.equals("資訊管理學系")) {
           // if (academyRecordsName != null) {
                // 如果 academyRecordsName 等於 "資訊管理系"
                return "user";
            }
            else {
                // 如果 academyRecordsName 不等於 "資訊管理系"跳轉到其他
              return "about";
            }
        }
		

        // 默認情況
        return "about";
    }
    
    
    
//    @RequestMapping("/about")
//    public String about(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication instanceof OAuth2AuthenticationToken) {
//            final var token = (OAuth2AuthenticationToken) authentication;
//
//            Map<String, Object> attributes = token.getPrincipal().getAttributes();
//            String chinesename = (String) attributes.get("chineseName");
//
//            // 将用户属性放入模型中
//            model.addAttribute("chineseName", chinesename);
//        }
//
//        return "about"; // 返回视图名称
//    }

}
