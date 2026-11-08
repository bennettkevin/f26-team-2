<#assign pageTitle="Customer Login - Local Guide">
  <#include "/shared/layout.ftlh">
  <@page title=pageTitle active="customer-login">
<body>
    <div class="container">
        <div class="card background-grey m-3 p-2">
            <h1>Customer Login</h1>
            <form action="/customers/customer-dash" method="post">
                <div class="mb-3">
                    <p>Username: <input type="text" name="username" required/> </p>
                </div>
                <div class="mb-3">
                    <p>Password: <input type="password" name="password" required/> </p>
                </div>
                <button type="submit" class="btn btn-primary">Login</button>
            </form>
            <p>Don't have an account? <a href="/customers/customer-registration">Register here</a></p>
        </div>
    </div>
</body>
  </@page>