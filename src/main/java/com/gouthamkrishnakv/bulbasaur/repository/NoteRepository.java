package com.gouthamkrishnakv.bulbasaur.repository;

import java.util.UUID;

import com.gouthamkrishnakv.bulbasaur.model.Note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, UUID> {
}
