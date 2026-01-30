package com.example.ourbusinessproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/partnerships")
public class PartnershipController {

    @Autowired
    private EnterpriseProjectService enterpriseProjectService;

    @Autowired
    private PartnershipService partnershipService;

    public PartnershipController(EnterpriseProjectService enterpriseProjectService, PartnershipService partnershipService){
        this.enterpriseProjectService = enterpriseProjectService;
        this.partnershipService = partnershipService;
    }

    @PostMapping("")
    public Partnership addPartnership(@RequestParam long project_id, @RequestParam long enterprise_id) {
        System.out.println("idP: "+ project_id +"; idE: "+ enterprise_id);
        Project p = this.enterpriseProjectService.findProjectById(project_id);
        Enterprise e = this.enterpriseProjectService.findEnterpriseById(enterprise_id);
        return this.partnershipService.newPartnership(p, e);
    }

    @DeleteMapping("/{id}")
    public void removePartnership(@PathVariable long id) {
        Partnership partnership = this.partnershipService.findPartnershipById(id);
        this.partnershipService.remove(partnership);
    }

}
