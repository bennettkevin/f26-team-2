<#assign pageTitle="Customer Registration - Local Guide">
  <#include "/shared/layout.ftlh">
<body>
    <div class="container">
        <h1>Customer Registration</h1>
        <div class="card background-grey m-3 p-2">
        <p>First Name: <input type="text" placeholder="EX: Clark"></input> </p>
        <p>Last Name: <input type="text" placeholder="EX: Kent"></input> </p>
        <p>State: <input type="text" placeholder="EX: North Carolina"></input> </p>
        <p>City: <input type="text" placeholder="EX: Greensboro"></input> </p>
        <p>Email: <input type="email" placeholder="EX: clark.kent@thedailybugle.com"></input> </p>
        <p>Password: <input type="text" placeholder="EX: password123"></input> </p>
        <p>Phone: <input type="tel" placeholder="EX: (987) 654-3210"></input> </p>
        <h2>Bio:</h2>
        <textarea style="height: 100px;" class="form-control" placeholder="Enter a brief bio about yourself."></textarea>
        <a class="btn btn-primary" href="/customers/customer-profile">Create Profile</a>
    </div>    
    </div>
</body>