package com.stackroute.Service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.trackAlreadyExistException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrackServiceImpl implements TrackService {

  TrackRepository trackRepository;
  @Autowired
  public TrackServiceImpl(TrackRepository trackRepository) {
this.trackRepository = trackRepository;
  }

  @Override
  public Track saveTrack(Track track) throws trackAlreadyExistException {

    if(trackRepository.existsById(track.getTrackId()))
      throw new trackAlreadyExistException("Track already exists...");

    Track savedTrack = trackRepository.save(track);

    if(savedTrack == null)
      throw new trackAlreadyExistException("Enter another id");

      return savedTrack;
  }

  @Override
  public List<Track> getAllTracks() {
    return trackRepository.findAll();
  }

  @Override
  public List<Track> findByTrackName(String trackName) throws TrackNotFoundException {
    if (trackRepository.existsByTrackName(trackName))
      return (trackRepository.findByTrackName(trackName));
    else
      throw new TrackNotFoundException("Track with Name:"+trackName+" does not exist");
  }
  @Override
  public List<Track> findByTrackIdAndTrackName(int trackId, String trackName) throws TrackNotFoundException {
    if (trackRepository.existsByTrackIdAndTrackName(trackId,trackName))
      return (trackRepository.findByTrackIdAndTrackName(trackId,trackName));
    else
      throw new TrackNotFoundException("Track with Id: "+trackId+" and Name: "+trackName+" does not exist");
  }
  @Override
  public Track updateCommentsFindById(Track track) throws TrackNotFoundException{
    if (trackRepository.existsByTrackId(track.getTrackId())) {
      return trackRepository.save(track);
    }
    else
      throw new TrackNotFoundException("Track with Id:"+track.getTrackId()+" does not exist");
  }
  @Override
  public List<Track> removeTrack(int trackId) throws TrackNotFoundException{
    if (trackRepository.existsByTrackId(trackId)) {
      trackRepository.delete(trackRepository.findById(trackId));
      return getAllTracks();
    }
      else
      throw new TrackNotFoundException("Track with Id:"+trackId+" does not exist");
  }
}
