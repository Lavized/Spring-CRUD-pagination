package com.paging.controller;

import com.paging.model.Country;
import com.paging.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class CountryController {

    @Autowired
    private final CountryRepository countryRepository;


    @GetMapping("/")
    public String showPage(Model model,@RequestParam(defaultValue = "0") int page){
        model.addAttribute("data", countryRepository.findAll(PageRequest.of(page,4)));

        model.addAttribute("currentPage", page);

        return "index";
    }


    @PostMapping("/save")
    public String save(Country c){
        countryRepository.save(c);
        return "redirect:/";
    }


    @GetMapping("/delete")
    public String deleteCountry(Long id){
        countryRepository.deleteById(id);
        return "redirect:/";
    }


    @GetMapping("/findOne")
    @ResponseBody
    public Country findOne(Long id){
        return countryRepository.findById(id).get();
    }

}
