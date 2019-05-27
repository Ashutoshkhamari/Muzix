package com.stackroute.domain;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Track {

  @Id
  int trackId;
  String trackName;
  String comments;

  public Track(int trackId, String name, String comments) {
    this.trackId = trackId;
    this.trackName = name;
    this.comments = comments;
  }

  public Track() {
  }

  public int getTrackId() {
    return trackId;
  }

  public void setTrackId(int trackId) {
    this.trackId = trackId;
  }

  public String getTrackName() {
    return trackName;
  }

  public void setTrackName(String trackName) {
    this.trackName = trackName;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  @Override
  public String    toString() {
    return "\nTrack{" +
      "trackId=" + trackId +
      ", trackName='" + trackName + '\'' +
      ", comments='" + comments + '\'' +
      '}';
  }
}
