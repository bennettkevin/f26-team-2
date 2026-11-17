<#import "/shared/layout.ftlh" as l>
<@l.page title="View Service" active="view-tour">
<div class="container">
    <#if guideTour??>
        <h1 class="m-3 p-2">${guideTour.getTourName()}</h1>
        <div class="card bg-secondary m-3 p-2">
            <#if guideTour.getTourImage()?has_content>
                <img src="${guideTour.getTourImage()}" alt="${guideTour.getTourName()}" class="img-fluid mb-3" style="max-height: 300px;">
            </#if>
            <p><strong>Location:</strong> ${guideTour.getTourCity()}, ${guideTour.getTourState()}</p>
            <p><strong>Price:</strong> $${guideTour.getTourPrice()?string["0.00"]}</p>
            <h2>Description</h2>
            <p>${guideTour.getTourDescription()}</p>

            <h2>Timeslots</h2>
            <#if guideTour.getTimeslots()?has_content>
                <ul class="list-group mb-3">
                    <#list guideTour.getTimeslots() as slot>
                        <li class="list-group-item d-flex justify-content-between align-items-center">
                            ${slot.getStartTime().toString()?replace("T", " ")} – ${slot.getEndTime().toString()?replace("T", " ")}
                            <#if slot.getIsAvailable()>
                                <span class="badge badge-success">Available</span>
                            <#else>
                                <span class="badge badge-secondary">Booked</span>
                            </#if>
                        </li>
                    </#list>
                </ul>
            <#else>
                <p>No timeslots yet.</p>
            </#if>

            <div>
                <a class="btn btn-primary" href="/provider/tour/${guideTour.getId()}/edit">Edit Service</a>
                <a class="btn btn-secondary" href="/provider/dashboard">Back to Dashboard</a>
            </div>
        </div>
    <#else>
        <p class="m-3">Service not found.</p>
        <a class="btn btn-secondary m-3" href="/provider/dashboard">Back to Dashboard</a>
    </#if>
</div>
</@l.page>
