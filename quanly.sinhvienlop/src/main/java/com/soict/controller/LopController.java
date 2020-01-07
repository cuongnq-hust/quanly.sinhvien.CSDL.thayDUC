package com.soict.controller;

import com.soict.model.Svlop;
import com.soict.model.Monhoc;
import com.soict.model.Giaovien;
import com.soict.model.Lop;
import com.soict.service.SvlopService;
import com.soict.service.MonhocService;
import com.soict.service.GiaovienService;
import com.soict.service.LopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LopController {
    @Autowired
    LopService lopService;
    @Autowired
    SvlopService svlopService;



    @Autowired
    MonhocService monhocService;
    @ModelAttribute("monhocs")
    public Iterable<Monhoc> monhocs(){
        return monhocService.findAll();
    }

    @Autowired
    GiaovienService giaovienService;
    @ModelAttribute("giaoviens")
    public Iterable<Giaovien> giaoviens(){
        return giaovienService.findAll();
    }

    @GetMapping("/lops")
    public ModelAndView listLop(){
        Iterable<Lop> lops=lopService.findAll();
        ModelAndView modelAndView=new ModelAndView("/lop/list");
        modelAndView.addObject("lops",lops);
        return modelAndView;
    }
    @GetMapping("/create-lop")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView=new ModelAndView("/lop/create","lop",new Lop());
        return modelAndView;
    }
    @PostMapping("/create-lop")
    public ModelAndView saveLop(@ModelAttribute("lop") Lop lop ){
        lopService.save(lop);
        ModelAndView modelAndView = new ModelAndView("/lop/create");
        modelAndView.addObject("lop", new Lop());
        modelAndView.addObject("message", "Tao moi Lop THANH CONG!!!");
        return modelAndView;
    }
    @GetMapping("/edit-lop/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Lop lop = lopService.findById(id);
        if(lop != null) {
            ModelAndView modelAndView = new ModelAndView("/lop/edit");
            modelAndView.addObject("lop", lop);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-lop")
    public ModelAndView updateLop(@ModelAttribute("lop") Lop lop){
        lopService.save(lop);
        ModelAndView modelAndView = new ModelAndView("/lop/edit");
        modelAndView.addObject("lop", lop);
        modelAndView.addObject("message", "Chinh sua Lop THANH CONG!!!");
        return modelAndView;
    }
    @GetMapping("/delete-lop/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Lop lop = lopService.findById(id);
        if(lop != null) {
            ModelAndView modelAndView = new ModelAndView("/lop/delete");
            modelAndView.addObject("lop", lop);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-lop")
    public String deleteLop(@ModelAttribute("lop") Lop lop){
        lopService.remove(lop.getId());
        return "redirect:lops";
    }

    @GetMapping("/view-lop/{id}")
    public ModelAndView viewLop(@PathVariable("id") Long id){
        Lop lop = lopService.findById(id);
        if(lop == null){
            return new ModelAndView("/error.404");
        }

        Iterable<Svlop> svlops = svlopService.findAllByLop(lop);

        ModelAndView modelAndView = new ModelAndView("/lop/view");
        modelAndView.addObject("lop", lop);
        modelAndView.addObject("svlops", svlops);
        return modelAndView;
    }

}
