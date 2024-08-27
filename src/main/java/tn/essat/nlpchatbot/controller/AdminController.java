package tn.essat.nlpchatbot.controller;

import tn.essat.nlpchatbot.entity.Adherent;
import tn.essat.nlpchatbot.entity.Admin;
import tn.essat.nlpchatbot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public String getAllAdmins(Model model) {
        List<Admin> admins = adminService.getAllAdmins();
        model.addAttribute("adherents", admins);
        return "admins/list";
    }

    @GetMapping("/{matricule_admin}")
    public String getAdminById(@PathVariable("matricule_admin") long matricule_admin, Model model) {
        Admin admin = adminService.getAdminById(matricule_admin);
        model.addAttribute("adherent", admin);
        return "admin/detail";
    }
    
}
