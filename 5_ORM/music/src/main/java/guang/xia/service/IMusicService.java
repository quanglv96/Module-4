package guang.xia.service;



import guang.xia.model.Music;
import guang.xia.model.MusicForm;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    void save(Music music,MusicForm musicForm);
    MusicForm findByIdMusicForm(int id);
    Music findByIdMusic(int id);

    void update(int id, Music music,MusicForm musicForm);

    void remove(int id);
}
