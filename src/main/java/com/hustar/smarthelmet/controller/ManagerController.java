package com.hustar.smarthelmet.controller;

import com.hustar.smarthelmet.domain.Manager;
import com.hustar.smarthelmet.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ManagerController {

    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/managers/new")
    public String createForm() {
        return "managers/createManagerForm";
    }

    @PostMapping("/managers/new")
    public String create(ManagerForm managerForm) {
        Manager manager = new Manager();
        manager.setName(managerForm.getName());
        manager.setMid(managerForm.getMid());
        manager.setAge(managerForm.getAge());
        manager.setMale(managerForm.getMale());
        manager.setBelong(managerForm.getBelong());
        manager.setPassword(managerForm.getPassword());

        System.out.println("manager = " + manager.getName());

        managerService.join(manager);
        return "redirect:/";
    }

    @GetMapping("/managers")
    public String list(Model model) {
        List<Manager> managers = managerService.findManagers();
        model.addAttribute("managers", managers);
        return "managers/managerList";
    }
}
