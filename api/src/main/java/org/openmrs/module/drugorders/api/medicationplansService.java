/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.drugorders.api;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.drugorders.medicationplans;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author harini-geek
 */
@Transactional
public interface medicationplansService extends OpenmrsService{
    
    public medicationplans saveNewTable(medicationplans newTable);
}