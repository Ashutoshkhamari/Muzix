package com.stackroute.controller;

import com.stackroute.Service.TrackService;
import com.stackroute.domain.Track;
import com.stackroute.exceptions.trackAlreadyExistException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@RestController
@PropertySource("classpath:application.properties")
@RequestMapping("/trackproduct/")
@Api(value="Muzix UI", description="Operations related to MUZIX DATABASE")

public class TrackController {
  TrackService trackService;

  public TrackController(TrackService trackService) {
    this.trackService = trackService;
  }

  @PostMapping("addTrack")
  public ResponseEntity<?> saveTrack(@RequestBody Track track) {
    ResponseEntity responseEntity;
    try {

         responseEntity = new ResponseEntity<Track>(trackService.saveTrack(track), HttpStatus.CREATED);
    } catch (trackAlreadyExistException trackAlreadyExistException) {
      responseEntity = new ResponseEntity<String>(trackAlreadyExistException.getMessage(), HttpStatus.CONFLICT);
    } catch (Exception e) {
      responseEntity = new ResponseEntity<String>("server unavailable. try later", HttpStatus.CONFLICT);
      System.out.println(e);
    }
    return responseEntity;
  }

  @GetMapping("/getAllTracks")
  public ResponseEntity<?> getAllTracks() {
    ResponseEntity responseEntity;
    try {
      responseEntity = new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.CREATED);
    } catch (Exception e) {
      responseEntity = new ResponseEntity<String>("server unavailable. try later", HttpStatus.CONFLICT);
      System.out.println(e);
    }
    return responseEntity;
  }

  @GetMapping("/findByTrackName")
  public ResponseEntity<?> findTrack(@RequestBody Track track) {
    ResponseEntity responseEntity;
    try {
      responseEntity = new ResponseEntity<List<Track>>(trackService.findByTrackName(track.getTrackName()), HttpStatus.CREATED);
    } catch (TrackNotFoundException trackNotFoundException) {
      responseEntity = new ResponseEntity<String>(trackNotFoundException.getMessage(), HttpStatus.CONFLICT);
    } catch (Exception e) {
      responseEntity = new ResponseEntity<String>("server unavailable. try later", HttpStatus.CONFLICT);
      System.out.println(e);
    }
    return responseEntity;
  }

  @GetMapping("/findByTrackIdAndTrackName")
  public ResponseEntity<?> findUserByTrackIdplusName(@RequestBody Track track) {
    ResponseEntity responseEntity;
    try {
      List<Track> trackList = new ArrayList<>();
      trackList = trackService.findByTrackIdAndTrackName(track.getTrackId(), track.getTrackName());
      responseEntity = new ResponseEntity<List<Track>>(trackList, HttpStatus.CREATED);
    } catch (TrackNotFoundException trackNotFoundException) {
      responseEntity = new ResponseEntity<String>(trackNotFoundException.getMessage(), HttpStatus.CONFLICT);
    } catch (Exception e) {
      responseEntity = new ResponseEntity<String>("server unavailable. try later", HttpStatus.CONFLICT);
      System.out.println(e);
    }
    return responseEntity;
  }

  @PutMapping("/updateComments")
  public ResponseEntity<?> updateCommentsFindById(@RequestBody Track track) {
    ResponseEntity responseEntity;
    try {
      responseEntity = new ResponseEntity<Track>(trackService.updateCommentsFindById(track), HttpStatus.CREATED);
    } catch (TrackNotFoundException trackNotFoundException) {
      responseEntity = new ResponseEntity<String>(trackNotFoundException.getMessage(), HttpStatus.CONFLICT);
    } catch (Exception e) {
      responseEntity = new ResponseEntity<String>("server unavailable. try later", HttpStatus.CONFLICT);
      System.out.println(e);
    }
    return responseEntity;
  }

  @DeleteMapping("/DeleteTrack")
  public ResponseEntity<?> removeTrack(@RequestBody Track track)
  {
    ResponseEntity responseEntity;
    try{
      responseEntity=new ResponseEntity<List<Track>>(trackService.removeTrack(track.getTrackId()), HttpStatus.CREATED);
    }
    catch (TrackNotFoundException trackNotFoundException)
    {
      responseEntity=new ResponseEntity<String>(trackNotFoundException.getMessage(), HttpStatus.CONFLICT);
    }
    catch (Exception e){ responseEntity=new ResponseEntity<String>("server unavailable. try later", HttpStatus.CONFLICT);
      System.out.println(e);
    }
    return responseEntity;
  }
}