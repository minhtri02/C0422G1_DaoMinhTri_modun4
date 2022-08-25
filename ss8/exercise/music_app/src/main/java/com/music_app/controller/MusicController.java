package com.music_app.controller;

import com.music_app.dto.MusicDto;
import com.music_app.model.Music;
import com.music_app.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class MusicController {

    @Autowired
    private IMusicService iMusicService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("listMusic",this.iMusicService.findAll());
        return "listMusic";
    }

    @GetMapping("/create")
    public String showAddMusic(Model model){
        model.addAttribute("musicDto",new MusicDto());
        return "/addMusic";
    }

    @GetMapping("/editMusic")
    public String showEditMusic(@RequestParam("id") Integer id,Model model){
        MusicDto musicDto = new MusicDto();
        BeanUtils.copyProperties(this.iMusicService.findById(id),musicDto);
        model.addAttribute("musicDto",musicDto);
        return "editMusic";
    }

    @PostMapping("/create")
    public String addMusic(@ModelAttribute @Valid MusicDto musicDto, BindingResult bindingResult, Model model){
        new MusicDto().validate(musicDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("musicDto",musicDto);
            return "addMusic";
        }

        Music music = new Music();
        BeanUtils.copyProperties(musicDto,music);
        this.iMusicService.add(music);
        model.addAttribute("msg","create access!!");
        return "addMusic";
    }

    @PostMapping("/editMusic")
    public String editMusic(@ModelAttribute @Valid MusicDto musicDto,BindingResult bindingResult, Model model){
        new MusicDto().validate(musicDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("musicDto",musicDto);
            return "editMusic";
        }

        Music music = new Music();
        BeanUtils.copyProperties(musicDto,music);
        this.iMusicService.save(music);
        model.addAttribute("msg","edit access!!");
        return "editMusic";
    }
}
