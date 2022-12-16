package guang.xia.controller;

import guang.xia.model.Music;
import guang.xia.model.MusicForm;
import guang.xia.service.IMusicService;
import guang.xia.service.MusicService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/home")
public class MusicController {
    @Value("${fileUpload_IMG}")
    private String fileUpload_IMG;
    @Value("${fileUpload_music}")
    private String fileUpload_music;
    private int id=2;
    private IMusicService musicService = new MusicService();

    @GetMapping("")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("musicList", musicService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView formCreate(){
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("musicForm",new MusicForm());
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(@ModelAttribute MusicForm musicForm){
            MultipartFile multipartFileAvatar = musicForm.getAvatar();
        String fileAvatar = multipartFileAvatar.getOriginalFilename();
        MultipartFile multipartFileMusic = musicForm.getUrl();
        String fileMusic = multipartFileMusic.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getAvatar().getBytes(), new File(fileUpload_IMG + fileAvatar));
            FileCopyUtils.copy(musicForm.getUrl().getBytes(), new File(fileUpload_music + fileMusic));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        id++;
        musicForm.setId(id);
        Music music = new Music(id,fileAvatar,musicForm.getName(),musicForm.getSingle(),musicForm.getCategory(),fileMusic);
        musicService.save(music,musicForm);
        return "redirect: /home";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView formEdit(@PathVariable("id") int id){
        MusicForm musicForm=musicService.findByIdMusicForm(id);
        ModelAndView modelAndView=new ModelAndView("edit");
        modelAndView.addObject("musicForm",musicForm);
        return modelAndView;

    }
    @PostMapping("/update")
    public String update(@ModelAttribute("musicForm") MusicForm musicForm){
        MultipartFile multipartFileAvatar = musicForm.getAvatar();
        String fileAvatar = multipartFileAvatar.getOriginalFilename();
        MultipartFile multipartFileMusic = musicForm.getUrl();
        String fileMusic = multipartFileMusic.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getAvatar().getBytes(), new File(fileUpload_IMG + fileAvatar));
            FileCopyUtils.copy(musicForm.getUrl().getBytes(), new File(fileUpload_music + fileMusic));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        id++;
        Music music = new Music(musicForm.getId(),fileAvatar,musicForm.getName(),musicForm.getSingle(),musicForm.getCategory(),fileMusic);
        musicService.update(music.getId(),music,musicForm);
        return "redirect: /home";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        musicService.remove(id);
        return "redirect: /home";
    }
}
