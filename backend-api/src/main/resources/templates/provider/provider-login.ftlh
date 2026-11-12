<#import "/shared/layout.ftlh" as l>
<@l.page title="Provider Login" active="login">
<div class="container">
    <div class="card background-grey m-3 p-2">
        <h1>Provider Login</h1>
        <form action="provider-profile.html" method="post">
            <div class="mb-3">
                <p>Username: <input type="text" name="username" required /> </p>
            </div>
            <div class="mb-3">
                <p>Password: <input type="password" name="password" required /> </p>
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
        </form>
        <p>Don't have an account? <a href="/provider/register">Register here</a></p>
    </div>
</div>
</@l.page>