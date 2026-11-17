<#import "/shared/layout.ftlh" as l>
    <@l.page title="Provider Dashboard" active="dashboard">
        <h1 class="m-3 p-2">Provider Dashboard</h1>
        <div class="card bg-secondary m-3 p-2">
            <h2>Services</h2>
            <#if guide??>
                <h3>Welcome, ${guide.getFName()!}</h3>
            </#if>
            <div class="d-flex flex-wrap justify-content-center m-3 p-2">
                <#if tours?? && (tours?size> 0)>
                    <#list tours as tour>
                        <div class="card bg-light m-3 p-2 ">
                            <h3>${tour.getTourName()!}</h3>
                            <p>Location: ${tour.getTourCity()!}, ${tour.getTourState()!}</p>
                            <p>Price: $${tour.getTourPrice()?string["0.00"]}</p>
                            <a class="btn btn-primary" href="/provider/tour/${tour.getId()}">View Service</a>
                        </div>
                    </#list>

                    <#else>
                        <p>No services yet add one.</p>
                </#if>
            </div>
            <a class="btn btn-primary m-3 p-2" href="/provider/add-tour">Add a Service</a>
            <form action="/provider/delete-account" method="post"
                onsubmit="return confirm('Delete your account and all of your services? This cannot be undone.');">
                <button type="submit" class="btn btn-danger">Delete Account</button>
            </form>

        </div>
    </@l.page>