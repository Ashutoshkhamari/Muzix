package com.stackroute.service;

import com.stackroute.controller.TrackController;
import com.stackroute.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackrServiceTest {

    private Track track;

    //Create a mock for UserRepository
    @Mock
    private TrackController trackController;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private TrackrServiceTest trackrServiceTest;
    List<Track> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setTrackId(1);
        track.setTrackName("AA");
        track.setComments("Song1");
        list = new ArrayList();
        list.add(track);
    }

    @Test
    public void saveUserTestSuccess() throws UserAlreadyExistException {

        when(trackController.save((Track)any())).thenReturn(user);
        Track savedUser = userService.saveUser(track);
        Assert.assertEquals(user,savedUser);

        //verify here verifies that userRepository save method is only called once
        verify(userRepository,times(1)).save(user);

    }

    @Test(expected = UserAlreadyExistException.class)
    public void saveUserTestFailure() throws UserAlreadyExistException {
        when(userRepository.save((User)any())).thenReturn(null);
        User savedUser = userService.saveUser(user);
        System.out.println("savedUser" + savedUser);
        Assert.assertEquals(user,savedUser);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }

    @Test
    public void getAllUser(){

        userRepository.save(user);
        //stubbing the mock to return specific data
        when(userRepository.findAll()).thenReturn(list);
        List<User> userlist = userService.getAllUser();
        Assert.assertEquals(list,userlist);
    }





}
