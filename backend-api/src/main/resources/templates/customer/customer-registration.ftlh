<#assign pageTitle="Customer Registration - Local Guide">
  <#include "/shared/layout.ftlh">
    <div class="form-container">
        <h1>Customer Registration</h1>
        <form action="/customers" method="post" enctype="application/x-www-form-urlencoded">
        <label for="FName">First Name</label> <input type="text" id="FName" name="FName" required></input>
        <label for="LName">Last Name</label> <input type="text" id="LName" name="LName" required></input>
        <label for="state">State</label> <input type="text" id="state" name="state" required></input>
        <label for="city">City</label> <input type="text" id="city" name="city" required></input>
        <label for="email">Email</label> <input type="email" id="email" name="email" required></input>
        <label for="password">Password</label> <input type="text" id="password" name="password" required></input>
        <label for="phoneNumber">Phone</label> <input type="tel" id="phoneNumber" name="phoneNumber" required></input>
        <label for="bio">Bio</label><textarea id="bio" name="bio" maxlength="2000" required></textarea>
        <label for="profilePicture">Profile Picture</label> <input type="text" id="profilePicture" name="profilePicture"></input>
        <button type="submit" class="btn btn-primary">Create Profile</button>
        </form>
    </div>