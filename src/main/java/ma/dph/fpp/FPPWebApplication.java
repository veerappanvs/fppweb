package ma.dph.fpp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.Principal;
import java.util.Collections;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import ma.dph.fpp.util.DSIPropertyUtil;


@Controller 
@SpringBootApplication
public class FPPWebApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

	static Logger log = Logger.getLogger(FPPWebApplication.class.getName());
	
	 @PostConstruct
	  public void init(){
	    // Setting Spring Boot SetTimeZone
	    TimeZone.setDefault(TimeZone.getTimeZone("EST"));
	  }
	
	static String currentProfile;
	
    public static void main( String[] args ) throws UnknownHostException
    {
        System.out.println( "FPP Web application using Spring!" );
      
        
        SpringApplication application = new SpringApplication(FPPWebApplication.class);
    	
    
    	application.run(args);
    }
    
  
    
   @GetMapping("/user")
    @ResponseBody
    public Principal user(Principal user) {
    	System.out.println("user ========>" + user.getName());
        return user;
    }
    
    @RequestMapping("/token")
	@ResponseBody
	public Map<String,String> token(HttpSession session) {
		return Collections.singletonMap("token", session.getId());
	}
    
    
    @RequestMapping("/dashboard")
	public String dashboard(Model model, Principal user){
		//log.debug("Welcome page: Session Id " + httpSession.getId() + " Creation Time: " + httpSession.getCreationTime());
//		httpSession.invalidate();
//		SecurityContextHolder.clearContext();
		return "dashboard";
	}
    
	
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model){
		//log.debug("Welcome page: Session Id " + httpSession.getId() + " Creation Time: " + httpSession.getCreationTime());
//		httpSession.invalidate();
//		SecurityContextHolder.clearContext();
		System.out.println("login ==>"+model);

		return "login";
	}
     
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		System.out.println("Access denied==>");
    	model.addAttribute("user", getPrincipal());
		
		return "accessDenied";
	}
    
  
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
}
