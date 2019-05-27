package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track,Integer > {
    public boolean existsByTrackName(String trackName);

    public boolean existsByTrackId(int trackId);

    public boolean existsByTrackIdAndTrackName(int trackId, String trackName);

    public Track findById(int trackId);

    public List<Track> findByTrackName(String trackName);

    public List<Track> findByTrackIdAndTrackName(int trackId, String trackName);
}
