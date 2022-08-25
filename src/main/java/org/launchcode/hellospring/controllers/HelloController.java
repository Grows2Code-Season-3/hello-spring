package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping(value="basePath")
public class HelloController {

    @GetMapping("")  // respond to GET requests at root path ("/")
    @ResponseBody
    public String index() {
        return "Hello, Spring!";
    }

    // responds to GET requests at /goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring :(";
    }

    // response to GET requests of the form /hello?name=LaunchCode
    @GetMapping("hello")
    @ResponseBody
    public String hello(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Path parameter example
    // respond to GET requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloPathParams(@PathVariable String name) {
        return "<h1>Hello, " + name + "!</h1>";
    }

    // respond to GET requests at /sayHello, and display a basic form
    @GetMapping("sayHello")
    @ResponseBody
    public String helloForm() {
        return "<form action='/sayHello/submit' method='POST'>" +
                "<input name='name' type='text'>" +
                "<button>Greet Me!</button>" +
                "</form>";
    }

    // respond to GET requests at /sayHello/submit?name=LaunchCode
    // *and* to POST requests at /sayHello/submit w/ name=LaunchCode
    @RequestMapping(value="sayHello/submit", method={RequestMethod.GET, RequestMethod.POST})
    // can handle only posts w/ @PostMapping("sayHello/submit")
    @ResponseBody
    public String processHelloForm(@RequestParam String name) {
        return "<h1>Hello, " + name + "!</h1>";
    }

}
