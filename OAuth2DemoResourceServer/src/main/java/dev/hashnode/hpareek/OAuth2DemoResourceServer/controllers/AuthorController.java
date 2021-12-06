package dev.hashnode.hpareek.OAuth2DemoResourceServer.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/authors") // This class handles requests for /authors
public class AuthorController {

    @GetMapping("/all") // This method handles requests for /authors/all
    @PreAuthorize("hasAuthority('SCOPE_authors')")
    public List<String> getAuthor() {
        List<String> authorList = new ArrayList<>();
        authorList.add("Author 1");
        authorList.add("Author 2");
        authorList.add("Author 3");
        return authorList;
    }
}
