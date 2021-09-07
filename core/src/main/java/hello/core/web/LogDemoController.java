package hello.core.web;

import hello.core.common.MyLogger;
import hello.core.logdemo.LogDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;
    
    @RequestMapping("log-demo")
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURI().toString();
        myLogger.setRequestURL(requestURL);
        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
