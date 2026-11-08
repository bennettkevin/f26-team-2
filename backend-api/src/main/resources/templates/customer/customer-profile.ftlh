<#assign pageTitle="Customer Profile - Local Guide">
  <#include "/shared/layout.ftlh">
  <@page title=pageTitle active="customer-profile">
<div class="container m-3 p-2">
        <img src="./Customer images/clark.jpg" alt="Clark Kent Profile Picture" class="img-fluid mb-2" style="max-width: 25rem;"/>
        <h1>Clark Kent</h1>
        <p>Location: Greensboro, NC</p>
    </div>
    <div class="container">
        <div class="card background-grey m-3 p-2">
            <h2>Interests</h2>
            <ul>
                <li>Exploring the wilderness</li>
                <li>Arcades</li>
                <li>Pickleball</li>
            </ul>
        </div>
        <div class="card background-grey  m-3 p-2">
            <h2>Bio</h2>
            <p>Investigative Journalist at the Daily Bugle, originally from Smallville, Kansas.
              I didn't get to travel a lot until I was offered my position at the Daily Bugle. While I go get to see a lot of
              interesting places, it's rare they have anything to do with my hobbies, so I would like to find people to show me
              what there is to do in Greensboro that align with my interests. I love nature, arcades, and pickleball.
            </p>
        </div>
        <a class="btn btn-secondary m-3" href="customer-edit-profile.html">Edit Profile</a>
    </div>
</div>
</div>
</body>
  </@page>