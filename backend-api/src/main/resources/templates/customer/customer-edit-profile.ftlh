<#assign pageTitle="Customer Edit Profile - Local Guide">
  <#include "/shared/layout.ftlh">

<body>
    <h1>${customer.FName!"First Name"} ${customer.LName!"Last Name"}</h1>
    <p>Location: ${customer.city!"City"}, ${customer.state!"State"}</p>
    <div class="container">
        <!--<div class="card">
            <h2>Interests</h2>
            <ul>
                <#list customer.interests as interest>
                    <li>${interest}</li>
                </#list>
            </ul>
            <a class="btn btn-primary" href="change-customer-interests.html">Add/remove interest.</a>
            -->
        </div>
        <div class="card">
            <h2>Bio</h2>
            <textarea type="text-box" class="form-control" style="height: 100px;">${customer.bio!"Enter a brief bio about yourself."}</textarea>
        </div>
        <div class="card">
            <h2>Contact Information:</h2>
            <p>Email:<input type="email" class="form-control" value="${customer.email}"></input></p>
            <p>Phone: <input type="tel" class="form-control" value="${customer.phoneNumber}"></input></p>
        </div>
        <a class="btn btn-secondary" href="/customers/customer-profile">Save Changes</a>
    </div>
</body>
</html>