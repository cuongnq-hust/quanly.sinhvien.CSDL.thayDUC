package com.soict.controller;


import com.soict.model.Lop;
import com.soict.model.Giaovien;
import com.soict.model.Lop;
import com.soict.service.LopService;
import com.soict.service.GiaovienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GiaovienController {
    @Autowired
    GiaovienService giaovienService;
    @Autowired
    LopService lopService;

    @GetMapping("/giaoviens")
    public ModelAndView listGiaovien(){
        Iterable<Giaovien> giaoviens=giaovienService.findAll();
        ModelAndView modelAndView=new ModelAndView("/giaovien/list");
        modelAndView.addObject("giaoviens",giaoviens);
        return modelAndView;
    }
    @GetMapping("/create-giaovien")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView=new ModelAndView("/giaovien/create","giaovien",new Giaovien());
        return modelAndView;
    }
    @PostMapping("/create-giaovien")
    public ModelAndView saveGiaovien(@ModelAttribute("giaovien") Giaovien giaovien ){
        giaovienService.save(giaovien);
        ModelAndView modelAndView = new ModelAndView("/giaovien/create");
        modelAndView.addObject("giaovien", new Giaovien());
        modelAndView.addObject("message", "Tao moi Giaovien THANH CONG!!!");
        return modelAndView;
    }
    @GetMapping("/edit-giaovien/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Giaovien giaovien = giaovienService.findById(id);
        if(giaovien != null) {
            ModelAndView modelAndView = new ModelAndView("/giaovien/edit");
            modelAndView.addObject("giaovien", giaovien);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-giaovien")
    public ModelAndView updateGiaovien(@ModelAttribute("giaovien") Giaovien giaovien){
        giaovienService.save(giaovien);
        ModelAndView modelAndView = new ModelAndView("/giaovien/edit");
        modelAndView.addObject("giaovien", giaovien);
        modelAndView.addObject("message", "Chinh sua Giaovien THANH CONG!!!");
        return modelAndView;
    }
    @GetMapping("/delete-giaovien/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Giaovien giaovien = giaovienService.findById(id);
        if(giaovien != null) {
            ModelAndView modelAndView = new ModelAndView("/giaovien/delete");
            modelAndView.addObject("giaovien", giaovien);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-giaovien")
    public String deleteGiaovien(@ModelAttribute("giaovien") Giaovien giaovien){
        giaovienService.remove(giaovien.getId());
        return "redirect:giaoviens";
    }

    @GetMapping("/view-giaovien/{id}")
    public ModelAndView viewGiaovien(@PathVariable("id") Long id){
        Giaovien giaovien = giaovienService.findById(id);
        if(giaovien == null){
            return new ModelAndView("/error.404");
        }

        Iterable<Lop> lops = lopService.findAllByGiaovien(giaovien);

        ModelAndView modelAndView = new ModelAndView("/giaovien/view");
        modelAndView.addObject("giaovien", giaovien);
        modelAndView.addObject("lops", lops);
        return modelAndView;
    }

}
