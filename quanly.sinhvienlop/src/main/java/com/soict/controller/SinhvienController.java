package com.soict.controller;


import com.soict.model.Svlop;
import com.soict.model.Sinhvien;
import com.soict.service.SvlopService;
import com.soict.service.SinhvienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SinhvienController {

    @Autowired
    SinhvienService sinhvienService;
    @Autowired
    SvlopService svlopService;

    @GetMapping("/sinhviens")
    public ModelAndView listSinhvien(){
        Iterable<Sinhvien> sinhviens=sinhvienService.findAll();
        ModelAndView modelAndView=new ModelAndView("/sinhvien/list");
        modelAndView.addObject("sinhviens",sinhviens);
        return modelAndView;
    }
    @GetMapping("/create-sinhvien")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView=new ModelAndView("/sinhvien/create","sinhvien",new Sinhvien());
        return modelAndView;
    }
    @PostMapping("/create-sinhvien")
    public ModelAndView saveSinhvien(@ModelAttribute("sinhvien") Sinhvien sinhvien ){
        sinhvienService.save(sinhvien);
        ModelAndView modelAndView = new ModelAndView("/sinhvien/create");
        modelAndView.addObject("sinhvien", new Sinhvien());
        modelAndView.addObject("message", "Tao moi Sinhvien THANH CONG!!!");
        return modelAndView;
    }
    @GetMapping("/edit-sinhvien/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Sinhvien sinhvien = sinhvienService.findById(id);
        if(sinhvien != null) {
            ModelAndView modelAndView = new ModelAndView("/sinhvien/edit");
            modelAndView.addObject("sinhvien", sinhvien);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-sinhvien")
    public ModelAndView updateSinhvien(@ModelAttribute("sinhvien") Sinhvien sinhvien){
        sinhvienService.save(sinhvien);
        ModelAndView modelAndView = new ModelAndView("/sinhvien/edit");
        modelAndView.addObject("sinhvien", sinhvien);
        modelAndView.addObject("message", "Chinh sua Sinhvien THANH CONG!!!");
        return modelAndView;
    }
    @GetMapping("/delete-sinhvien/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Sinhvien sinhvien = sinhvienService.findById(id);
        if(sinhvien != null) {
            ModelAndView modelAndView = new ModelAndView("/sinhvien/delete");
            modelAndView.addObject("sinhvien", sinhvien);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-sinhvien")
    public String deleteSinhvien(@ModelAttribute("sinhvien") Sinhvien sinhvien){
        sinhvienService.remove(sinhvien.getId());
        return "redirect:sinhviens";
    }

    @GetMapping("/view-sinhvien/{id}")
    public ModelAndView viewSinhvien(@PathVariable("id") Long id){
        Sinhvien sinhvien = sinhvienService.findById(id);
        if(sinhvien == null){
            return new ModelAndView("/error.404");
        }

        Iterable<Svlop> svlops = svlopService.findAllBySinhvien(sinhvien);

        ModelAndView modelAndView = new ModelAndView("/sinhvien/view");
        modelAndView.addObject("sinhvien", sinhvien);
        modelAndView.addObject("svlops", svlops);
        return modelAndView;
    }


}
