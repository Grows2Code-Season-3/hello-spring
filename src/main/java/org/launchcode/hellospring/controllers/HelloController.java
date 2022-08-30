package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


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
    public String helloPathParams(String name) {
        return "<h1>Hello, " + name + "!</h1>";
    }

    // respond to GET requests at /sayHello, and display a basic form
    @GetMapping("sayHello")
    public String helloForm(Model model) {
        model.addAttribute("title", "Custom Greeting Form");
        return "form";
    }

    // respond to POST requests at /sayHello/submit
    @PostMapping("sayHello/submit")
    public String processHelloForm(@RequestParam String name, Model model) {
        model.addAttribute("greeting", "Hello, " + name + "!");
        model.addAttribute("title", "Your Custom Greeting");
        return "hello";
    }

    @GetMapping("list")
    public String displayList(Model model) {

        ArrayList<String> cheeses = new ArrayList<>();
//        cheeses.add("white cheddar");
//        cheeses.add("provolone");
//        cheeses.add("gouda");
//        cheeses.add("gorganzola");

        model.addAttribute("cheeses", cheeses);

        return "list";
    }

}
