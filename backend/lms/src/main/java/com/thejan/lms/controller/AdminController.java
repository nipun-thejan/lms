package com.thejan.lms.controller;

import com.thejan.lms.dto.RegisterRequest;
import com.thejan.lms.entity.User;
import com.thejan.lms.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/get_all_users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(
                adminService.getAllUsers());
    }

    @PostMapping("/assign")
    public ResponseEntity<?> assignNewAdmin(
            @RequestBody RegisterRequest registerRequest) throws Exception {
        return ResponseEntity.ok(adminService.assignNewAdmin(registerRequest));
    }
}
