package dev.hashnode.hpareek.OAuth2DemoResourceServer.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/authors") // This class handles requests for /authors
public class AuthorController {

    @GetMapping("/all") // This method handles requests for /authors/all
    public List<String> getAuthor() {
        List<String> authorList = new ArrayList<>();
        authorList.add("Author 1");
        authorList.add("Author 2");
        authorList.add("Author 3");
        return authorList;
    }
}
