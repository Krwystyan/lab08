package it.unibo.deathnote;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;

import it.unibo.deathnote.api.DeathNote;
import it.unibo.deathnote.impl.DeathNoteImplementation;

class TestDeathNote{
    final static String DEFAULT_VICTIM = "Mario Rossi";
    final DeathNote dbook = new DeathNoteImplementation();

    @BeforeEach
    void initialize(){
        dbook.writeName(DEFAULT_VICTIM);
    }

    @Test
    void tesGetRules(){
        Exception e = assertThrows(IllegalArgumentException.class, () -> dbook.getRule(0));
        assertNotNull(e.getMessage());
        assertFalse(e.getMessage().isEmpty() || e.getMessage().isBlank());
        e = assertThrows(IllegalArgumentException.class, () -> dbook.getRule(-1));
        assertNotNull(e.getMessage());
        assertFalse(e.getMessage().isEmpty() || e.getMessage().isBlank());

    }
}