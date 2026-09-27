package com.carmo.First_App_Spring.Controllers;


import com.carmo.First_App_Spring.Domain.User;
import com.carmo.First_App_Spring.Services.HelloWorldService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")   // pagina inicial que ira ser base de todos os as outras rotas da mesma classe
public class HelloWorldController {
    private final HelloWorldService service;

    public HelloWorldController (HelloWorldService service) {
        this.service = service; //injeção de dependencia
    }


//    @GetMapping("/hello")  // /teste/helloworld
//    public String helloWorld(@RequestBody User user) {
//        return service.helloName(user);
//    }


    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld() {
        return new ResponseEntity<>("Hello World",HttpStatus.OK);
    }

}
