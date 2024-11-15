package it.unibo.deathnote;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static java.lang.Thread.sleep;

import it.unibo.deathnote.api.DeathNote;
import it.unibo.deathnote.impl.DeathNoteImplementation;

class TestDeathNote{
    private final static String DEFAULT_VICTIM = "Mario Rossi";
    private final static String DEFAULT_CHECK_VICTIM = "Kaneda Tanjiro";
    private static final int INVALID_CAUSE_TIME = 100;
    private static final int INVALID_DETAILS_TIME = 6000 + INVALID_CAUSE_TIME;
    private DeathNote dbook;

    @BeforeEach
    void setup(){
        dbook = new DeathNoteImplementation();
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

    @Test
    void testRegularRules(){
        for(int i=0;i<DeathNote.RULES.size();i++){
            String check = dbook.getRule(i);
            assertNotNull(check);
            assertFalse(check.isBlank());
        }
    }

    @Test
    void testWriteName(){
        assertFalse(dbook.isNameWritten(DEFAULT_VICTIM));
        dbook.writeName(DEFAULT_VICTIM);
        assertTrue(dbook.isNameWritten(DEFAULT_VICTIM));
        assertFalse(dbook.isNameWritten(DEFAULT_CHECK_VICTIM));
        assertFalse(dbook.isNameWritten(""));
    }

    @Test
    void testCauseOfDeath(){
        assertThrows(IllegalStateException.class, ()->dbook.writeDeathCause("Shit is self"));
        dbook.writeName(DEFAULT_VICTIM);
        assertEquals("heart attack", dbook.getDeathCause(DEFAULT_VICTIM));
        dbook.writeName(DEFAULT_CHECK_VICTIM);
        dbook.writeDeathCause("karting accident");
        assertEquals("karting accident", dbook.getDeathCause(DEFAULT_CHECK_VICTIM));
        sleep(INVALID_CAUSE_TIME);
    }
}