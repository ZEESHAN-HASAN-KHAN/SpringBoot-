package com.niit.usermovieservice.controller;

import com.niit.usermovieservice.domain.Movie;
import com.niit.usermovieservice.domain.User;
import com.niit.usermovieservice.exception.MovieNotFoundException;
import com.niit.usermovieservice.exception.UserAlreadyExistsException;
import com.niit.usermovieservice.exception.UserNotFoundException;
import com.niit.usermovieservice.service.UserMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Collections;

@RestController
@RequestMapping("/api/v2/")
public class UserMovieController {
private UserMovieService userMovieService;
private ResponseEntity<?> responseEntity;
@Autowired
    public UserMovieController(UserMovieService userMovieService) {
        this.userMovieService = userMovieService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistsException {
    try {
        user.setMovieList(Collections.emptyList());
        System.out.println(user);
        responseEntity =  new ResponseEntity<>(userMovieService.registerUser(user), HttpStatus.CREATED);
    }
    catch(UserAlreadyExistsException e)
    {
        throw new UserAlreadyExistsException();
    }
    return responseEntity;
    }
    @PostMapping("/user/movie")
    public ResponseEntity<?> saveUserMovieToList(@RequestBody Movie movie,HttpServletRequest request) throws UserNotFoundException {
    String email = (String) request.getAttribute("email");
    try {
        responseEntity = new ResponseEntity<>(userMovieService.saveUserMovieToList(movie, email), HttpStatus.CREATED);
    }
    catch (UserNotFoundException e)
    {
        throw new UserNotFoundException();
    }
    return responseEntity;
    }
    @GetMapping("/user/movies")
    public ResponseEntity<?> getAllUserMoviesFromList(HttpServletRequest request) throws UserNotFoundException {
        String email = (String) request.getAttribute("email");
        System.out.println(email);
    try{
        responseEntity = new ResponseEntity<>(userMovieService.getAllUserMovies(email), HttpStatus.OK);
    }catch(UserNotFoundException e)
    {
        throw new UserNotFoundException();
    }
       return responseEntity;
    }
    @DeleteMapping("/user/{movieId}")
    public ResponseEntity<?> deleteUserProductFromList(@PathVariable String movieId,HttpServletRequest request)
            throws UserNotFoundException, MovieNotFoundException
    {
        String email = (String) request.getAttribute("email");
        try {
            responseEntity = new ResponseEntity<>(userMovieService.deleteUserMovieFromList(email, movieId), HttpStatus.OK);
        } catch (UserNotFoundException | MovieNotFoundException m) {
            throw new MovieNotFoundException();
        }
        return responseEntity;
    }
}

