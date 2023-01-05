//package guang.xia.controller;
//
//import guang.xia.model.User;
//
//import guang.xia.security.jwt.JwtResponse;
//import guang.xia.security.jwt.JwtService;
//import guang.xia.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//
//@Controller
//@RequestMapping("/users")
//public class UserController {
//    @Autowired
//    private UserService userService;
//    @PostMapping("/newUser")
//    public String addUser(@RequestPart User user){
//        userService.save(user);
//        return "login/login";
//    }
//    @PostMapping("/registration")
//    public ResponseEntity<Iterable<User>> registration(@RequestBody User user){
//        userService.save(user);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtService jwtService;
//
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody User user) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtService.generateTokenLogin(authentication);
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        User currentUser = userService.findByUsername(user.getUsername()).get();
//        return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), currentUser.getUsername(), userDetails.getAuthorities()));
//    }
//}
