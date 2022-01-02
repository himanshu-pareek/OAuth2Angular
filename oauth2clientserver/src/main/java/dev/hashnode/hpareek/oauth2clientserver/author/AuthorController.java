package dev.hashnode.hpareek.oauth2clientserver.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private WebClient webClient;

    @GetMapping("/all")
    public Mono<Object> all() throws Throwable {
        return webClient.get()
                .uri("http://localhost:8080/authors/all")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Object.class);
    }
}
