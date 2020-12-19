package me.hellozin.about.controller;

import java.util.List;
import me.hellozin.about.entity.Subscribe;
import me.hellozin.about.service.SubscribeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscribeController {

    private final SubscribeService subscribeService;

    public SubscribeController(SubscribeService subscribeService) {
        this.subscribeService = subscribeService;
    }

    @GetMapping("/subscribe/list")
    public List<Subscribe> getSubscribes(@RequestParam long consumerId) {
        return subscribeService.getAllSubscribesByConsumerId(consumerId);
    }

    @PostMapping("/subscribe/{producerId}")
    public Subscribe subscribe(@PathVariable long producerId, @RequestParam long consumerId) {
        return subscribeService.subscribe(consumerId, producerId);
    }

    @DeleteMapping("/subscribe/{producerId}")
    public void unSubscribe(@PathVariable long producerId, @RequestParam long consumerId) {
        subscribeService.unSubscribe(consumerId, producerId);
    }
}
