<#assign pageTitle="Customer Login - Local Guide">
  <#include "/shared/layout.ftlh">
<!--<body>
    <div class="container">
        <div class="card background-grey m-3 p-2">
            <h1>Customer Login</h1>
            <form method="post" action="${formAction}" enctype="form-data" class="form">

                <div class="mb-3">
                    <label for="name">Name</label>
                    <input id="name" name="name" type="text" value="${(customer.firstName)!''}" required>
                </div>
                <div class="mb-3">
                    <label for="password">Password</label>
                    <input id="password" name="password" type="password" value="${(customer.password)!''}" required>
                </div>
                <div class="actions">
          <button type="submit">Save</button>
          <#if customerId??>
            <a href="/customers/${customerId?c}">Cancel</a>
            <#else>
              <a href="/">Cancel</a>
          </#if>
        </div>
            </form>
            <p>Don't have an account? <a href="/customers/customer-registration">Register here</a></p>
        </div>
    </div>
</body> -->

<body>
    <div class="container">
        <h1>Customer Login</h1>
        <form action="/customers/${customer.id}" method="get"></form>
        <div class="card background-grey m-3 p-2">
        <label for="email">Email: </label><input type="email" id="email" required></input> </p>
        <label for="password">Password: </label><input type="password" id="password" required></input> </p>
        <a class="btn btn-primary" href="/customers/customer-profile">Login</a>
    </div>    
    </div>
</body>