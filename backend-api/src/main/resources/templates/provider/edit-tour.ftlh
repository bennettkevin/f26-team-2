<#import "/shared/layout.ftlh" as l>
    <@l.page title="Edit Service" active="edit-tour">
        <div class="container">
            <h1 class="m-3 p-2">Edit Service</h1>

            <div class="card bg-secondary m-3 p-2">
                <h2>Details</h2>
                <form action="/provider/tour/${guideTour.getId()}/edit" method="post">
                    <p>Title: <input type="text" name="tourName" value="${guideTour.getTourName()!}" maxlength="100"
                            required /></p>
                    <p>City: <input type="text" name="tourCity" value="${guideTour.getTourCity()!}" maxlength="100"
                            required /></p>
                    <p>State: <input type="text" name="tourState" value="${guideTour.getTourState()!}" maxlength="100"
                            required /></p>
                    <p>Image link: <input type="url" name="tourImage" value="${guideTour.getTourImage()!}" /></p>
                    <h3>Description:</h3>
                    <textarea name="tourDescription" class="form-control" maxlength="500" style="height: 100px;"
                        required>${guideTour.getTourDescription()!}</textarea>
                    <p class="mt-2">Price: $<input type="number" name="tourPrice" value="${guideTour.getTourPrice()?c}"
                            min="0" step="0.01" required /></p>
                    <button type="submit" class="btn btn-primary">Save Details</button>
                </form>
                <form action="/provider/tour/${guideTour.getId()}/delete" method="post"
                    onsubmit="return confirm('Delete this service? This cannot be undone.');">
                    <button type="submit" class="btn btn-danger mt-3 p-2">Delete Service</button>
                </form>
            </div>

            <div class="card bg-secondary m-3 p-2">
                <h2>Timeslots</h2>
                <#if guideTour.getTimeslots()?has_content>
                    <ul class="list-group mb-3">
                        <#list guideTour.getTimeslots() as slot>
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                ${slot.getStartTime().toString()?replace("T", " ")} –
                                ${slot.getEndTime().toString()?replace("T", " ")}
                                <#if slot.getIsAvailable()>
                                    <span class="badge badge-success">Available</span>
                                    <form action="/provider/tour/${guideTour.getId()}/timeslots/${slot.getId()}/delete"
                                        method="post" class="m-0">
                                        <button type="submit" class="btn btn-sm btn-danger">Remove</button>
                                    </form>
                                    <#else>
                                        <span class="badge badge-secondary">Booked</span>
                                </#if>
                            </li>
                        </#list>
                    </ul>
                    <#else>
                        <p>No timeslots yet.</p>
                </#if>

                <h3>Add a timeslot</h3>
                <form action="/provider/tour/${guideTour.getId()}/timeslots" method="post">
                    <p>Start: <input type="datetime-local" name="startTime" required /></p>
                    <p>End: <input type="datetime-local" name="endTime" required /></p>
                    <button type="submit" class="btn btn-primary">Add Timeslot</button>
                </form>
            </div>

            <div class="m-3">
                <a class="btn btn-secondary" href="/provider/tour/${guideTour.getId()}">Back to Service</a>
                <a class="btn btn-secondary" href="/provider/dashboard">Back to Dashboard</a>
            </div>
        </div>
    </@l.page>