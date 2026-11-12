<#assign pageTitle="Customer Login - Local Guide">
  <#include "/shared/layout.ftlh">

<body>
    <div class="container">
        <h1>Customer Login</h1>
        <form action="/customers/customer-login" method="post">
            <div class="card background-grey m-3 p-2">
                <label for="email">Email: </label><input type="email" id="email" name="email" required></input> </p>
                <label for="password">Password: </label><input type="password" id="password" name="password" required></input> </p>
                <button type="submit" class="btn btn-primary">Login</button> 
            </div>
        </form>
    </div>
</body>