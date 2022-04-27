package com.gouthamkrishnakv.bulbasaur.service;

import com.gouthamkrishnakv.bulbasaur.model.Note;
import com.gouthamkrishnakv.bulbasaur.repository.NoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {
    NoteRepository noteRepository;


    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void addNote(Note newNote) {
        noteRepository.save(newNote);
    }
}
