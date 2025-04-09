package com.test.controller;

import com.test.entity.Client;
import com.test.entity.Master;
import com.test.entity.Specialization;
import com.test.service.ClientService;
import com.test.service.MasterService;

import javax.validation.Valid;

import com.test.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MyController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private MasterService masterService;
    @Autowired
    private SpecializationService specializationService;

    @RequestMapping("/")
    public String showWelcomeView() {
        return "welcome-view";
    }

    @RequestMapping("/all-clients")
    public String showAllClients(Model model) {
        List<Client> allClients = clientService.getAllClients();
        model.addAttribute("allClient_s", allClients);
        return "all-clients";
    }

    @RequestMapping("/askClientDetails")
    public String addNewClient(Model model) {
        model.addAttribute("client", new Client());
        return "ask-client-details";
    }

    @RequestMapping("/saveClientDetails")
    public String saveClient(@Valid @ModelAttribute("client") Client client
            , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "ask-client-details";
        } else {
            clientService.saveClient(client);
            return "redirect:/all-clients";
        }
    }

    @RequestMapping("/updateClient")
    public String updateClient(@RequestParam("clientId") int id, Model model) {
        Client client = clientService.getClient(id);
        model.addAttribute("client", client);
        return "ask-client-details";
    }

    @RequestMapping("/deleteClient")
    public String deleteClient(@RequestParam("clientId") int id) {
        clientService.deleteClient(id);
        return "redirect:/all-clients";
    }

    @RequestMapping("/all-masters")
    public String showAllMasters(Model model) {
        List<Master> allMasters = masterService.getAllMasters();
        model.addAttribute("allMaster_s", allMasters);
        return "all-masters";
    }

    @RequestMapping("/askMasterDetails")
    public String addNewMaster(Model model) {
        model.addAttribute("master", new Master());
        return "ask-master-details";
    }

    @Transactional
    @RequestMapping("/updateMaster")
    public String updateMaster(@RequestParam("masterId") int id, Model model) {
        Master master = masterService.getMaster(id);
        master.getSpecializations().size(); //вызываем инициализацию коллекции прежде чем сессия будет закрыта
        model.addAttribute("master", master);

        Set<Specialization> specializations = new HashSet<>();
        specializations.add(new Specialization("manicure"));
        specializations.add(new Specialization("pedicure"));
        master.setSpecializations(specializations);

        List<String> masterLevels = master.getMasterLevels();
        model.addAttribute("masterLevels", masterLevels);

        return "ask-master-details";
    }

    @RequestMapping("/saveMasterDetails")
    public String saveMaster(@Valid @ModelAttribute("master") Master master
            , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "ask-master-details";
        } else {
            masterService.saveMaster(master);
            return "redirect:/all-masters";
        }
    }

    @RequestMapping("/deleteMaster")
    public String deleteMaster(@RequestParam("masterId") int id) {
        masterService.deleteMaster(id);
        return "redirect:/all-masters";
    }


}
