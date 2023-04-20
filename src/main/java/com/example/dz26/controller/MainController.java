package com.example.dz26.controller;

import com.example.dz26.domain.Client;
import com.example.dz26.domain.Message;
import com.example.dz26.repos.MessageRepo;
import com.example.dz26.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

    /*@GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }*/

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewClientForm(Model model){
        Client client = new Client();
        model.addAttribute("client", client);
        return "new_client";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveClient(@ModelAttribute("client") Client client){
        service.save(client);
        return "redirect:/";
    }

    @RequestMapping("/main")
    public String viewHomePage(Model model, @Param("keyword") String keyword){
        List<Client> listClient = service.listAll(keyword);
        model.addAttribute("listClient", listClient);
        model.addAttribute("keyword", keyword);
        return "index";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditClientFrom(@PathVariable(name="id") Long id){
        ModelAndView mav = new ModelAndView("edit_client");
        Client client = service.get(id);
        mav.addObject("Client", client);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteClient(@PathVariable(name="id") Long id){
        service.delete(id);
        return "redirect:/";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }

        model.put("messages", messages);

        return "index";
    }
}