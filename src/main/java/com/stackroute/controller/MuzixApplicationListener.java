package com.stackroute.controller;
import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import io.swagger.models.auth.In;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@ComponentScan
@Configuration
@PropertySource("classpath:application.properties")

class MuzixApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    TrackRepository trackRepository;
    @Autowired
    public MuzixApplicationListener(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

      @Value("${track.id}")
      private int trackid;
  
      @Value("${track.name}")
      private String trackName;
  
      @Value("${track.comments}")
      private String comments;

      Track track=new Track(trackid,trackName,comments);

    @PostConstruct
    public void saveTrack(){
        //trackRepository.save(track);
    }

      @Autowired
      private Environment environment;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Track track1=new Track(1,"Song1","AA");
        trackRepository.save(track1);
        Track track2=new Track(2,"Song2","BB");
        trackRepository.save(track2);
        Track track3=new Track(3,"Song3","CC");
        trackRepository.save(track3);
        Track track4=new Track(4,"Song4","DD");
        trackRepository.save(track4);
        Track track=new Track(trackid,trackName,comments);
        trackRepository.save(track);
        Track track5=new Track(Integer.parseInt(environment.getProperty("track.id")));
        trackRepository.save(track5);

    }
}
