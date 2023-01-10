package dev.gorj00.streamsschedule.controller;

import dev.gorj00.streamsschedule.exception.LiveStreamNotFoundException;
import dev.gorj00.streamsschedule.model.LiveStream;
import dev.gorj00.streamsschedule.repository.LiveStreamRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/streams")
public class LiveStreamController {
    private final LiveStreamRepository repository;

    public LiveStreamController(LiveStreamRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<LiveStream> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public LiveStream findById(@PathVariable String id) throws LiveStreamNotFoundException {
        return repository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LiveStream create(@Valid @RequestBody LiveStream stream) {
        return repository.create(stream);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody LiveStream stream,
                       @PathVariable String id) {
        repository.update(stream, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        repository.delete(id);
    }
}
