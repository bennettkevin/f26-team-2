      <#assign pageTitle="Customer Profile - Local Guide">
      <#include "/shared/layout.ftlh">
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
      </div>
    </div>