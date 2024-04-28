//package com.ece.doxa_backend.model.service;
//
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.*;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.ece.doxa_backend.model.entity.*;
//import com.ece.doxa_backend.model.repository.UserRepository;
//import com.ece.doxa_backend.model.service.UserService;
//
//import java.util.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class UserServiceTest {
//
//    private User Eva;
//    private User Kais;
//    private User Enzo;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @InjectMocks
//    private UserService userService;
//
//    @BeforeEach
//    public void setUp() {
//        this.Eva = new User(1, "eabgrall", null, null, new Date(), new Date(), false);
//        this.Kais = new User(2L, "kzenat", null, null, new Date(), new Date(), true);
//        this.Enzo = new User(3L, "eromero", null, null, new Date(), new Date(), true);
//    }
//
//    /*
//      These methods are used to achieve a synchronisation between the Keycloak Database and MySQL.
//      When the application is started, it will search in the database if the user exists and, if it does,
//      the method will be called to check the synchronisation (since the user can change his name and
//      surname from the Keycloak control panel).
//      Note: The user cannot change his ID or username.
//    */
//    @Test
//    void returnJuanWhenTheKeycloakUserHasTheSameUsername() {
//        /*
//          If the first and last name coming from the Keycloak token are the same as
//          the found user, it does nothing.
//        */
//        UserApp keycloakUser = new UserApp();
//        keycloakUser.setUsername("jpablo");
//        keycloakUser.setName("Juan");
//        keycloakUser.setSurname("Pablo");
//        userService.checkIfUserIsPersisted(this.juan, keycloakUser);
//        verify(userRepository, times(0)).save(this.juan);
//        assertEquals(1L, this.juan.getIdUser());
//        assertEquals("jpablo", this.juan.getUsername());
//        assertEquals("Juan", this.juan.getName());
//        assertEquals("Pablo", this.juan.getSurname());
//    }
//    @Test
//    void returnTheKeycloakUserWhenTheirNamesAreNotEqual() {
//        /*
//          If the first and last name coming from the Keycloak token are the not same as
//          the found user, it updates them.
//        */
//        UserApp keycloakUser = new UserApp();
//        keycloakUser.setUsername("jpablo");
//        keycloakUser.setName("Chris");
//        keycloakUser.setSurname("Redfield");
//        userService.checkIfUserIsPersisted(this.juan, keycloakUser);
//        verify(userRepository, times(1)).save(this.juan);
//        assertEquals(1L, this.juan.getIdUser());
//        assertEquals("jpablo", this.juan.getUsername());
//        assertEquals("Chris", this.juan.getName());
//        assertEquals("Redfield", this.juan.getSurname());
//    }
//}