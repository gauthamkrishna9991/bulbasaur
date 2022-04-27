package com.gouthamkrishnakv.bulbasaur.controller;

import java.util.UUID;
import java.net.URI;
import java.util.Optional;

import com.gouthamkrishnakv.bulbasaur.model.Note;
import com.gouthamkrishnakv.bulbasaur.repository.NoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("/acknowledge")
    public String hello() {
        return "ACK";
    }

    @GetMapping("/{id}")
    Optional<Note> getById(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        return noteRepository.findById(uuid);
    }

    @PostMapping("")
    ResponseEntity<Note> create(@RequestBody Note newNote) {
        Note persistedNote = noteRepository.save(newNote);
        return ResponseEntity.created(URI.create(String.format("/persons/%s", persistedNote.getId())))
                .body(persistedNote);
    }
}
