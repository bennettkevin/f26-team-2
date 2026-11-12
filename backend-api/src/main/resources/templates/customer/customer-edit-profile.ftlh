<#assign pageTitle="Customer Edit Profile - Local Guide">
  <#include "/shared/layout.ftlh">

<body>
    <h1>${customer.FName!"First Name"} ${customer.LName!"Last Name"}</h1>
    <p>Location: ${customer.city!"City"}, ${customer.state!"State"}</p>
    <div class="form-container">
        <h1>Customer Edit Profile</h1>
        <form action="/customers/${customer.id}" method="post" enctype="application/x-www-form-urlencoded">
        <label for="FName">First Name</label> <input type="text" id="FName" name="FName" value="${customer.FName!"First Name"}" required></input>
        <label for="LName">Last Name</label> <input type="text" id="LName" name="LName" value="${customer.LName!"Last Name"}" required></input>
        <label for="state">State</label> <input type="text" id="state" name="state" value="${customer.state!"State"}" required></input>
        <label for="city">City</label> <input type="text" id="city" name="city" value="${customer.city!"City"}" required></input>
        <label for="email">Email</label> <input type="email" id="email" name="email" value="${customer.email!"Email"}" required></input>
        <label for="password">Password</label> <input type="text" id="password" name="password" value="${customer.password!"Password"}" required></input>
        <label for="phoneNumber">Phone</label> <input type="tel" id="phoneNumber" name="phoneNumber" value="${customer.phoneNumber!"Phone"}" required></input>
        <label for="bio">Bio</label><textarea id="bio" name="bio" maxlength="2000" required>${customer.bio!"Enter a brief bio about yourself."}</textarea>
        <label for="profilePicture">Profile Picture</label> <input type="text" id="profilePicture" name="profilePicture" value="${customer.profilePicture!"Profile Picture"}"></input>
        <button type="submit" class="btn btn-primary">Update Profile</button>
        </form>
    </div>