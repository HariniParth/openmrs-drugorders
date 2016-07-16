<%
    ui.includeCss("drugorders", "drugorders.css")
%>

<% existingDrugOrdersExtension.each { existingDrugOrderExtension -> %>
    <% existingDrugOrdersMain.each { existingDrugOrderMain -> %>
        <% if(existingDrugOrderMain.orderId == existingDrugOrderExtension.orderId) { %>
            <span id="entries">
                <a href="#" id="existingDrugOrdersID" onclick="showDrugOrderViewWindow('${ ui.format(patient.givenName) }','${ ui.format(patient.familyName) }','${ existingDrugOrderExtension.startdate }','${ existingDrugOrderExtension.drugname }','${ existingDrugOrderMain.dose }','${ existingDrugOrderMain.doseUnits.getDisplayString() }','${ existingDrugOrderMain.route.getDisplayString() }','${ existingDrugOrderMain.duration }','${ existingDrugOrderMain.durationUnits.getDisplayString() }','${ existingDrugOrderMain.quantity }','${ existingDrugOrderMain.quantityUnits.getDisplayString() }','${ existingDrugOrderMain.frequency }','${ existingDrugOrderExtension.patientinstructions }','${ existingDrugOrderExtension.pharmacistinstructions }')">
                    ${ existingDrugOrderExtension.drugname } ${ existingDrugOrderExtension.startdate } 
                </a>    
            </span>

            <span id="button">
                <i class="icon-pencil edit-action" title="${ ui.message("Edit") }" onclick="showEditIndividualDrugOrderWindow('${ existingDrugOrderMain.orderId }','${ existingDrugOrderExtension.drugname }','${ existingDrugOrderExtension.startdate }','${ existingDrugOrderMain.dose }','${ existingDrugOrderMain.doseUnits.getDisplayString() }','${ existingDrugOrderMain.route.getDisplayString() }','${ existingDrugOrderMain.duration }','${ existingDrugOrderMain.durationUnits.getDisplayString() }','${ existingDrugOrderMain.quantity }','${ existingDrugOrderMain.quantityUnits.getDisplayString() }','${ existingDrugOrderMain.frequency }','${ existingDrugOrderExtension.patientinstructions }','${ existingDrugOrderExtension.pharmacistinstructions }')"></i>
                <i class="icon-remove delete-action" title="${ ui.message("Delete") }" onclick="showDiscontinueIndividualDrugOrderWindow('${ ui.format(patient.givenName) }','${ ui.format(patient.familyName) }','${ existingDrugOrderExtension.startdate }','${ existingDrugOrderExtension.drugname }','${ existingDrugOrderMain.dose }','${ existingDrugOrderMain.doseUnits.getDisplayString() }','${ existingDrugOrderMain.route.getDisplayString() }','${ existingDrugOrderMain.duration }','${ existingDrugOrderMain.durationUnits.getDisplayString() }','${ existingDrugOrderMain.quantity }','${ existingDrugOrderMain.quantityUnits.getDisplayString() }','${ existingDrugOrderMain.frequency }','${ existingDrugOrderExtension.patientinstructions }','${ existingDrugOrderExtension.pharmacistinstructions }')"></i>
            </span>
        <% } %>
    <% } %>
    <br/><br/>
<% } %>
