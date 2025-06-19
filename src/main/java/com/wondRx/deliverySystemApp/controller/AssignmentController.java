package com.wondRx.deliverySystemApp.controller;

import com.wondRx.deliverySystemApp.entity.DeliveryOrder;
import com.wondRx.deliverySystemApp.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/run")
    public String runAssignments() {
        assignmentService.assignOrders();
        return "Assignments complete.";
    }

    @GetMapping
    public List<DeliveryOrder> getAllAssignments() {
        return assignmentService.getAssignments();
    }

    @GetMapping("/truck/{id}")
    public List<DeliveryOrder> getAssignmentsForTruck(@PathVariable String id) {
        return assignmentService.getAssignmentsForTruck(id);
    }
}

