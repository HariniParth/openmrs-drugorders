/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.drugorders.fragment.controller;

import java.util.ArrayList;
import java.util.List;
import org.openmrs.DrugOrder;
import org.openmrs.Order;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.drugorders.api.drugordersService;
import org.openmrs.module.drugorders.drugorders;
import org.openmrs.module.drugorders.page.controller.OrderAndDrugOrder;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author harini-geek
 */
public class DrugOrderSingleFragmentController {
    
    public void controller(PageModel model, @RequestParam("patientId") Patient patient){
        
        List<drugorders> dorders = new ArrayList<drugorders>();
        List<OrderAndDrugOrder> drugOrders = getDrugOrdersByPatient(patient);
                
        for(OrderAndDrugOrder drugOrder : drugOrders){
            drugorders dorder = drugOrder.getdrugorders();
            dorders.add(dorder);
        }
                
        model.addAttribute("existingDrugOrdersExtension", dorders);
        List<DrugOrder> drugOrderMain = getDrugOrderMainDataByPatient(patient);
        model.addAttribute("existingDrugOrdersMain", drugOrderMain);
                
    }
    
    private List<OrderAndDrugOrder> getDrugOrdersByPatient(Patient p) {
        ArrayList<OrderAndDrugOrder> drugOrders = new ArrayList<OrderAndDrugOrder>();
        List<Order> orders = Context.getOrderService().getAllOrdersByPatient(p);
        int drugOrderTypeId = Context.getOrderService().getOrderTypeByName("Drug Order").getOrderTypeId();
        drugorders drugOrder;
        
        for (Order order : orders) {
            if (order.getOrderType().getOrderTypeId() == drugOrderTypeId) {
                drugOrder = Context.getService(drugordersService.class).getNewTable(order.getOrderId());
                drugOrders.add(new OrderAndDrugOrder(order, drugOrder));
            }
        }
        return drugOrders;
    }
    
    private List<DrugOrder> getDrugOrderMainDataByPatient(Patient p){
        ArrayList<DrugOrder> drugOrdersMain = new ArrayList<DrugOrder>();
        List<Order> orders = Context.getOrderService().getAllOrdersByPatient(p);
        int drugOrderTypeId = Context.getOrderService().getOrderTypeByName("Drug Order").getOrderTypeId();
        DrugOrder drugOrderMain;
        
        for (Order order : orders) {
            if (order.getOrderType().getOrderTypeId() == drugOrderTypeId){
                drugOrderMain = (DrugOrder) Context.getOrderService().getOrder(order.getOrderId());
                drugOrdersMain.add(drugOrderMain);
            }
        }
        return drugOrdersMain;
    }
    
}