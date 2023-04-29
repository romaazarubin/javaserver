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
public class FilterController {

    @Autowired
    private AutoBlogService serviceAuto;

    @PostMapping("filterDate")
    public String viewfilterDate(Model model, @RequestParam("filter") String keyword){
        List<AutoBlog> listAutoBlog = serviceAuto.searchDate(keyword);
        model.addAttribute("listAutoBlog", listAutoBlog);
        model.addAttribute("keyword", keyword);
        return "autoblog";
    }

    @PostMapping("filterName")
    public String viewfilterName(Model model, @RequestParam("filter") String keyword){
        List<AutoBlog> listAutoBlog = serviceAuto.searchAuthor(keyword);
        model.addAttribute("listAutoBlog", listAutoBlog);
        model.addAttribute("keyword", keyword);
        return "autoblog";
    }

    @PostMapping("filterDateName")
    public String viewfilterDateName(Model model, @RequestParam("filter") String keyword){
        List<AutoBlog> listAutoBlog = serviceAuto.searchDateAuthor(keyword);
        model.addAttribute("listAutoBlog", listAutoBlog);
        model.addAttribute("keyword", keyword);
        return "autoblog";
    }

    @PostMapping("filterText")
    public String viewfilterText(Model model, @RequestParam("filter") String keyword){
        List<AutoBlog> listAutoBlog = serviceAuto.searchText(keyword);
        model.addAttribute("listAutoBlog", listAutoBlog);
        model.addAttribute("keyword", keyword);
        return "autoblog";
    }

    @PostMapping("filterDateText")
    public String viewfilterDateText(Model model, @RequestParam("filter") String keyword){
        List<AutoBlog> listAutoBlog = serviceAuto.searchDateText(keyword);
        model.addAttribute("listAutoBlog", listAutoBlog);
        model.addAttribute("keyword", keyword);
        return "autoblog";
    }

    @PostMapping("filterALL")
    public String viewfilterALL(Model model, @RequestParam("filter") String keyword){
        List<AutoBlog> listAutoBlog = serviceAuto.listAll(keyword);
        model.addAttribute("listAutoBlog", listAutoBlog);
        model.addAttribute("keyword", keyword);
        return "autoblog";
    }
}
