package com.example.calculator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class CalculatorController {

@GetMapping("/")
public RedirectView home() {
    return new RedirectView("/index.html");
}

    @GetMapping("/add")
    public Map<String, Object> add(@RequestParam int a, @RequestParam int b){
        Map<String, Object> result = new HashMap<>();
        result.put("operation", "addition");
        result.put("a", a);
        result.put("b", b);
        result.put("result", a+b);
        return result;
    }

    @GetMapping("/subtract")
    public Map<String, Object> subtract(@RequestParam int a, @RequestParam int b){
        Map<String, Object> result = new HashMap<>();
        result.put("operation","subtraction");
        result.put("a",a);
        result.put("b", b);
        result.put("result",a-b);
        return result;
    }

    @GetMapping("/multiply")
    public Map<String, Object> multiply(@RequestParam int a, @RequestParam int b){
        Map<String, Object> result = new HashMap<>();
        result.put("operation", "multiplication");
        result.put("a",a);
        result.put("b",b);
        result.put("result", a*b);
        return result;
    }

    @GetMapping("/divide")
    public Map<String, Object> divide(@RequestParam int a, @RequestParam int b){
        Map<String, Object> result = new HashMap<>();
        result.put("operation", "division");
        result.put("a", a);
        result.put("b", b);
        if(b == 0)
            result.put("error", "Division by zero is not allowed") ;
        else
            result.put("result", a/b);
        return result;     
    }
    
}
