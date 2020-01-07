package com.soict.controller;

import com.soict.model.*;
import com.soict.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class SvlopController {
    @Autowired
    SvlopService svlopService;


    @Autowired
    SinhvienService sinhvienService;

    @ModelAttribute("sinhviens")
    public Iterable<Sinhvien> sinhviens() {
        return sinhvienService.findAll();
    }

    @Autowired
    LopService lopService;

    @ModelAttribute("lops")
    public Iterable<Lop> lops() {
        return lopService.findAll();
    }


    @GetMapping("/svlops")
    public ModelAndView listSvlops(
            @RequestParam("s") Optional<String> s,
            @PageableDefault(size = 10) Pageable pageable
    ) {
        Page<Svlop> svlops;
        svlops = svlopService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/svlop/list");
        modelAndView.addObject("svlops", svlops);
        return modelAndView;
    }

    @GetMapping("/create-svlop")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/svlop/create");
        modelAndView.addObject("svlop", new Svlop());
        return modelAndView;
    }

    @PostMapping("/create-svlop")
    public ModelAndView saveCustomer(@ModelAttribute("svlop") Svlop svlop) {
        svlopService.save(svlop);
        ModelAndView modelAndView = new ModelAndView("/svlop/create");
        modelAndView.addObject("svlop", new Svlop());
        modelAndView.addObject("message", "New svlop created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-svlop/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Svlop svlop = svlopService.findById(id);
        if (svlop != null) {
            ModelAndView modelAndView = new ModelAndView("/svlop/edit");
            modelAndView.addObject("svlop", svlop);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-svlop")
    public ModelAndView updateEm(@ModelAttribute("svlop") Svlop svlop) {
        svlopService.save(svlop);
        ModelAndView modelAndView = new ModelAndView("/svlop/edit");
        modelAndView.addObject("svlop", svlop);
        modelAndView.addObject("message", "Svlop Update succeddful");
        return modelAndView;
    }

    @GetMapping("/delete-svlop/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Svlop svlop = svlopService.findById(id);
        if (svlop != null) {
            ModelAndView modelAndView = new ModelAndView("/svlop/delete");
            modelAndView.addObject("svlop", svlop);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-svlop")
    public String deleteEm(@ModelAttribute("svlop") Svlop svlop) {
        svlopService.remove(svlop.getId());
        return "redirect:svlops";
    }

    @GetMapping("searchBySinhvien")
    public ModelAndView getSvlopBySinhvien(
            @RequestParam("search") String search,
            @PageableDefault(size = 10) Pageable pageable
    ) {
        Page<Svlop> svlops;
        if(search == null || search == "") {
            svlops = svlopService.findAll(pageable);
        } else {
            Sinhvien sinhvien = sinhvienService.findById(Long.parseLong(search));
            svlops = svlopService.findAllBySinhvien(pageable, sinhvien);
        }
        ModelAndView modelAndView = new ModelAndView("/svlop/list");
        modelAndView.addObject("svlops", svlops);
        modelAndView.addObject("search", search);
        return modelAndView;
    }

    @GetMapping("/searchByLop")
    public ModelAndView getSvlopByLop(
            @RequestParam("search") String search,
            @PageableDefault(size = 10) Pageable pageable
    ) {
        Page<Svlop> svlops;
        if(search == null || search == "") {
            svlops = svlopService.findAll(pageable);
}else {
            Lop lop = lopService.findById(Long.parseLong(search));
            svlops = svlopService.findAllByLop(pageable, lop);

        }
        ModelAndView modelAndView = new ModelAndView("/svlop/list");
        modelAndView.addObject("svlops", svlops);
        modelAndView.addObject("search", search);
        return modelAndView;
    }

//    @GetMapping("/searchByLop")
//    public ModelAndView getSvlopByLop(@RequestParam("search") String search, Pageable pageable) {
//        Lop lop = lopService.findById(Long.parseLong(search));
//        Page<Svlop> svlops = svlopService.findAllByLop(pageable, lop);
//        ModelAndView modelAndView = new ModelAndView("/svlop/list");
//        modelAndView.addObject("svlops", svlops);
//        modelAndView.addObject("search", search);
//        return modelAndView;
//    }

    @GetMapping("/")
    public String index()
    {
        return "redirect:/svlops";
    }
}

