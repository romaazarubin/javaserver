package com.example.dz26.controller;

import com.example.dz26.domain.AutoBlog;
import com.example.dz26.service.AutoBlogService;
import com.example.dz26.domain.Client;
import com.example.dz26.domain.Message;
import com.example.dz26.repos.MessageRepo;
import com.example.dz26.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private ClientService service;

    @Autowired
    private AutoBlogService serviceAuto;

    @RequestMapping("/new")
    public String showNewClientForm(Model model){
        Client client = new Client();
        model.addAttribute("client", client);
        return "new_client";
    }

    @RequestMapping("/autoblog_new")
    public String showNewAutoBlogForm(Model model){
        AutoBlog autoBlog = new AutoBlog();
        model.addAttribute("autoBlog", autoBlog);
        return "autoblog_new";
    }

    @RequestMapping(value = "/autoblog_save", method = RequestMethod.POST)
    public String saveAutoBlog(@ModelAttribute("autoBlog") AutoBlog autoBlog){
        serviceAuto.save(autoBlog);
        return "redirect:/autoblog_panel";
    }

    @RequestMapping("/autoblog")
    public String viewHomePageAuto(Model model, @Param("keyword") String keyword){
        List<AutoBlog> listAutoBlog = serviceAuto.listAll(keyword);
        model.addAttribute("listAutoBlog", listAutoBlog);
        model.addAttribute("keyword", keyword);
        return "autoblog";
    }

    @RequestMapping("/autoblog_panel")
    public String viewHomePagePanel(Model model, @Param("keyword") String keyword){
        List<AutoBlog> listAutoBlog = serviceAuto.listAll(keyword);
        model.addAttribute("listAutoBlog", listAutoBlog);
        model.addAttribute("keyword", keyword);
        return "autoblog_panel";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveClient(@ModelAttribute("client") Client client){
        service.save(client);
        return "redirect:/";
    }

    @RequestMapping("/")
    public String viewHomePageAdmin(Model model, @Param("keyword") String keyword, Authentication authResult){
        String role = authResult.getAuthorities().toString();
        List<Client> listClient = service.listAll(keyword);
        model.addAttribute("listClient", listClient);
        model.addAttribute("keyword", keyword);
        if(role.contains("ADMIN")) {
            return "indexADMIN";
        }
        else{
            return "indexUSER";
        }
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditClientFrom(@PathVariable(name="id") Long id){
        ModelAndView mav = new ModelAndView("edit_client");
        Client client = service.get(id);
        mav.addObject("Client", client);
        return mav;
    }

    @RequestMapping("/autoblog_edit/{id}")
    public ModelAndView showEditAutoBlogFrom(@PathVariable(name="id") Long id){
        ModelAndView mav = new ModelAndView("edit_autoblog");
        AutoBlog autoBlog = serviceAuto.get(id);
        mav.addObject("autoBlog", autoBlog);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteClient(@PathVariable(name="id") Long id){
        service.delete(id);
        return "redirect:/autoblog_panel";
    }

    @RequestMapping("/autoblog_delete/{id}")
    public String deleteAutoBlog(@PathVariable(name="id") Long id){
        serviceAuto.delete(id);
        return "redirect:/autoblog_panel";
    }
}