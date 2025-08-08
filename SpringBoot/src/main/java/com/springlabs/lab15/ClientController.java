package com.springlabs.lab15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/clients")
    public String listClients(Model model) {
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "clients-list";
    }

    @GetMapping("/addclient")
    public String addClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "add-client";
    }

    @PostMapping("/saveclient")
    public String saveClient(@ModelAttribute("client") Client client) {
        clientRepository.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit-client");
        Optional<Client> client = clientRepository.findById(id);
        mav.addObject("client", client.orElse(null));
        return mav;
    }

    @PostMapping("/updateclient")
    public String updateClient(@ModelAttribute("client") Client client) {
        clientRepository.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable(name = "id") Long id) {
        clientRepository.deleteById(id);
        return "redirect:/clients";
    }
}