/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.drugorders.fragment.controller;

import org.openmrs.Patient;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author harini-geek
 */

public class AddDrugOrderSingleFragmentController {
    
    /**
     *
     * @param model
     * @param drugname
     * @param patient
     */
    public void controller(PageModel model, @RequestParam(value = "drugname", required = false) String drugname,
            @RequestParam("patientId") Patient patient){

        model.addAttribute("drugname", drugname);
        model.addAttribute("patientid", patient.getPatientId());
    }
}
