package raghu.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class MyCustomErrorController implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

//    @RequestMapping("/error")
    public @ResponseBody String handleException(HttpServletRequest httpServletRequest){
        ServletWebRequest servletWebRequest = new ServletWebRequest(httpServletRequest);
        Map<String,Object> errorMap = errorAttributes.getErrorAttributes(servletWebRequest, ErrorAttributeOptions.defaults());
        StringBuilder builder = new StringBuilder();
        errorMap.forEach((k,v)->{
            builder.append(k);
            builder.append(" ");
            builder.append(v);
        });

        return builder.toString();
    }

    @RequestMapping("/error")
    public @ResponseBody Map<String,Object> handleExceptionJson(HttpServletRequest httpServletRequest){
        ServletWebRequest servletWebRequest = new ServletWebRequest(httpServletRequest);
        Map<String,Object> errorMap = errorAttributes.getErrorAttributes(servletWebRequest, ErrorAttributeOptions.defaults());
        return errorMap;
    }

}
