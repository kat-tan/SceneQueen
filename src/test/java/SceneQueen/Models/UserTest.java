package SceneQueen.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }
    @Test
    void getEmail() {
        user.setEmail("aydini@farmingdale.edu");
        assertEquals("aydini@farmingdale.edu", user.getEmail());
    }

    @Test
    void getPassword() {
        user.setPassword("bestProfEver");
        assertEquals("bestProfEver", user.getPassword());
    }

    @Test
    void getFirstName() {
        user.setFirstName("Ilknur");
        assertEquals("Ilknur", user.getFirstName());
    }

    @Test
    void getLastName() {
        user.setLastName("Aydin");
        assertEquals("Aydin", user.getLastName());
    }

    @Test
    void getFullName() {
        user.setFirstName("Doctor");
        user.setLastName("Aydin");
        assertEquals("Doctor Aydin", user.getFullName());
    }
}