<#import "/shared/layout.ftlh" as l>
    <@l.page title="Customer Profile" active="profile">
    <div>
      <div>
        <h1>${customer.FName!""} ${customer.LName!""}</h1>
        <dl>
          <dt>City</dt>
          <dd>${customer.city!""}</dd>
          <dt>State</dt>
          <dd>${customer.state!""}</dd>
          <dt>Email</dt>
          <dd>${customer.email!""}</dd>
          <dt>Phone</dt>
          <dd>${customer.phoneNumber!""}</dd>
          <dt>Bio</dt>
          <dd>${customer.bio!""}</dd>
        </dl>

        <div class="actions">
          <a href="/customers/${customer.id}/edit" class="button">Edit Profile</a>
        </div>
        <div class="actions">
          <a href="/customers/${customer.id}/delete" class="button">Delete Profile</a>
        </div>
      </div>
    </div>
        </@l.page>