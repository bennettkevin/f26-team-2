<#import "/shared/layout.ftlh" as l>
    <@l.page title="Provider Registration" active="register">
        <div class="container">
            <h1>Provider Registration</h1>
            <div class="card background-grey m-3 p-2">
                <form action="/provider/register" method="post">
                    <p>First Name: <input type="text" name="fName" placeholder="EX: John" maxlength="50" required /></p>
                    <p>Last Name: <input type="text" name="lName" placeholder="EX: Doe" maxlength="50" required /></p>
                    <p>City: <input type="text" name="city" placeholder="EX: Greensboro" maxlength="50" required /></p>
                    <p>State: <input type="text" name="state" placeholder="EX: North Carolina" maxlength="50"
                            required /></p>
                    <p>Email: <input type="email" name="email" placeholder="EX: john.doe@example.com" maxlength="100"
                            required /></p>
                    <p>Password: <input type="password" name="password" maxlength="100" required /></p>
                    <h2>Bio:</h2>
                    <textarea name="bio" style="height: 100px;" class="form-control" maxlength="300"
                        placeholder="Enter a brief bio about yourself." required></textarea>
                    <button type="submit" class="btn btn-primary mt-2">Create Profile</button>
                </form>
            </div>
        </div>
    </@l.page>