package guang.xia.service;

import guang.xia.model.Music;
import guang.xia.model.MusicForm;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MusicService implements IMusicService {
    private static Map<Integer, Music> musicList;
    private static Map<Integer, MusicForm> musicFormMap;
    @Autowired
    EntityManager entityManager;

    static {
        musicList = new HashMap<>();
        musicFormMap=new HashMap<>();
//        musicList.put(1,new Music(1,"e10be63bd7a1e353bb1a319cf89f646d-1000.jpg","quang","quang,","quang","WaitingForYou-MONOOnionn-7733882.mp3"));
//        musicList.put(2,new Music(2,"e10be63bd7a1e353bb1a319cf89f646d-1000.jpg","huong","quang,","quang","WaitingForYou-MONOOnionn-7733882.mp3"));
    }

    @Override
    public ArrayList<Music> findAll() {
        return new ArrayList<>( musicList.values());
    }


    @Override
    public void save(Music music,MusicForm musicForm) {
        musicList.put(music.getId(), music);
        musicFormMap.put(musicForm.getId(),musicForm);
    }

    @Override
    public Music findByIdMusic(int id) {
        return musicList.get(id);
    }
    @Override
    public MusicForm findByIdMusicForm(int id) {
        return musicFormMap.get(id);
    }

    @Override
    public void update(int id, Music music,MusicForm musicForm) {
        musicList.put(id, music);
        musicFormMap.put(id,musicForm);
    }

    @Override
    public void remove(int id) {
        musicList.remove(id);
        musicFormMap.remove(id);
    }
}
