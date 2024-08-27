package tn.essat.nlpchatbot.controller;

import tn.essat.nlpchatbot.entity.Admin;
import tn.essat.nlpchatbot.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/admins")
public class AdminRestController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<Admin> getAlladmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{matricule}")
    public Admin getAdminById(@PathVariable("matricule_admin") long matricule_admin) {
        return adminService.getAdminById(matricule_admin);
    }

    @PostMapping
    public Admin addAdmin(@RequestBody Admin admin) {
        return adminService.addAdmin(admin);
    }
/*
    @PutMapping("/{matricule}")
    public Admin updateadmin(@PathVariable("matricule") long matricule, @RequestBody Admin admin) {
        Admin existingadmin = adminService.getAdminById(matricule);
        if (existingadmin != null) {
            existingadmin.setUsername(admin.getUsername());
            existingadmin.setPassword(admin.getPassword());
            return adminService.updateAdmin(existingadmin);
        }
        return null;
    }
*/
    @DeleteMapping("/{matricule}")
    public void deleteadmin(@PathVariable("matricule_admin") long matricule_admin) {
        adminService.deleteAdmin(matricule_admin);
    }
}
