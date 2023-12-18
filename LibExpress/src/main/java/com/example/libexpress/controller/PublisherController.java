package com.example.libexpress.controller;

import com.example.libexpress.entity.Publisher;
import com.example.libexpress.service.PublisherService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/lib-express/admin/publishers")
public class PublisherController {


     private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("")
    public String viewHomePage(Model model) {
        String keyword =null;
        return findPaginated(1, "name", "asc",keyword,model);
    }

    @GetMapping("/page/{page}")
    public String findPaginated(@PathVariable(value = "page") Integer page,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDirection") String sortDirection,
                                @RequestParam(value = "keyword", required = false) String keyword,
                                Model model) {
        int limit = 10;
        Page<Publisher> getPublisherPage = publisherService.findPaginated(page, limit, sortField, sortDirection,keyword);
        List<Publisher> publisherList = getPublisherPage.getContent();
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", getPublisherPage.getTotalPages());
        model.addAttribute("totalItems", getPublisherPage.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("pageData", getPublisherPage);
        model.addAttribute("sortDirection",sortDirection);
        model.addAttribute("reverseSortDir",sortDirection.equals("asc") ? "desc" : "asc");
        model.addAttribute("BookList", publisherList);
        model.addAttribute("keyword", keyword);
        return "admin/bookManagement/publisher";
    }
}
