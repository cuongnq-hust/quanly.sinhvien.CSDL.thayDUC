package com.soict.controller;

import com.soict.model.Lop;
import com.soict.model.Monhoc;
import com.soict.service.LopService;
import com.soict.service.MonhocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MonhocController {
    @Autowired
    MonhocService monhocService;
    @Autowired
    LopService lopService;

    @GetMapping("/monhocs")
    public ModelAndView listMonhoc(){
        Iterable<Monhoc> monhocs=monhocService.findAll();
        ModelAndView modelAndView=new ModelAndView("/monhoc/list");
        modelAndView.addObject("monhocs",monhocs);
        return modelAndView;
    }
    @GetMapping("/create-monhoc")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView=new ModelAndView("/monhoc/create","monhoc",new Monhoc());
        return modelAndView;
    }
    @PostMapping("/create-monhoc")
    public ModelAndView saveMonhoc(@ModelAttribute("monhoc") Monhoc monhoc ){
        monhocService.save(monhoc);
        ModelAndView modelAndView = new ModelAndView("/monhoc/create");
        modelAndView.addObject("monhoc", new Monhoc());
        modelAndView.addObject("message", "Tao moi Monhoc THANH CONG!!!");
        return modelAndView;
    }
    @GetMapping("/edit-monhoc/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Monhoc monhoc = monhocService.findById(id);
        if(monhoc != null) {
            ModelAndView modelAndView = new ModelAndView("/monhoc/edit");
            modelAndView.addObject("monhoc", monhoc);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-monhoc")
    public ModelAndView updateMonhoc(@ModelAttribute("monhoc") Monhoc monhoc){
        monhocService.save(monhoc);
        ModelAndView modelAndView = new ModelAndView("/monhoc/edit");
        modelAndView.addObject("monhoc", monhoc);
        modelAndView.addObject("message", "Chinh sua Monhoc THANH CONG!!!");
        return modelAndView;
    }
    @GetMapping("/delete-monhoc/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Monhoc monhoc = monhocService.findById(id);
        if(monhoc != null) {
            ModelAndView modelAndView = new ModelAndView("/monhoc/delete");
            modelAndView.addObject("monhoc", monhoc);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-monhoc")
    public String deleteMonhoc(@ModelAttribute("monhoc") Monhoc monhoc){
        monhocService.remove(monhoc.getId());
        return "redirect:monhocs";
    }

    @GetMapping("/view-monhoc/{id}")
    public ModelAndView viewMonhoc(@PathVariable("id") Long id){
        Monhoc monhoc = monhocService.findById(id);
        if(monhoc == null){
            return new ModelAndView("/error.404");
        }

        Iterable<Lop> lops = lopService.findAllByMonhoc(monhoc);

        ModelAndView modelAndView = new ModelAndView("/monhoc/view");
        modelAndView.addObject("monhoc", monhoc);
        modelAndView.addObject("lops", lops);
        return modelAndView;
    }
}
