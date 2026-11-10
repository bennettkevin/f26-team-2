<#assign pageTitle="Customer Edit Profile - Local Guide">
  <#include "/shared/layout.ftlh">

<body>
    <h1>${customer.name}</h1>
    <p>Location: ${customer.location}</p>
    <div class="container">
        <div class="card">
            <h2>Interests</h2>
            <ul>
                <#list customer.interests as interest>
                    <li>${interest}</li>
                </#list>
            </ul>
            <!--<a class="btn btn-primary" href="change-customer-interests.html">Add/remove interest.</a>-->
        </div>
        <div class="card">
            <h2>Bio</h2>
            <textarea type="text-box" class="form-control" style="height: 100px;">${customer.bio}</textarea>
        </div>
        <div class="card">
            <h2>Contact Information:</h2>
            <p>Email:<input type="email" class="form-control" value="${customer.email}"></input></p>
            <p>Phone: <input type="tel" class="form-control" value="${customer.phone}"></input></p>
        </div>
        <p>Image link: <input type="url" placeholder="EX: linktonaturepic.com/pretty-flowers.jpeg" value="${customer.imageLink}"> </input></p>
        <a class="btn btn-secondary" href="/customers/${customer.id}/customer-profile.html">Save Changes</a>
    </div>
</body>
</html>