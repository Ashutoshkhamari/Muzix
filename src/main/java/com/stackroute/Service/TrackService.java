package com.stackroute.Service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.trackAlreadyExistException;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {
  public Track saveTrack(Track track) throws trackAlreadyExistException;
  public List<Track> getAllTracks();

  public List<Track> findByTrackName(String TrackName) throws TrackNotFoundException;
  public List<Track> findByTrackIdAndTrackName(int trackId, String trackName) throws TrackNotFoundException;
  public Track updateCommentsFindById(Track track) throws TrackNotFoundException;
  public List<Track> removeTrack(int trackId) throws TrackNotFoundException;
}
