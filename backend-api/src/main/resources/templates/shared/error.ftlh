<#assign pageTitle="Something went wrong - Local Guide">
  <#include "/shared/layout.ftlh">
  <@page title=pageTitle active="error">
      <main class="section">
        <div class="card">
          <div class="card-content">
            <h1>We could not complete that request</h1>
            <p>${errorMessage!"Please try again."}</p>
            <a class="btn btn-primary" href="/">Return home</a>
              <a class="btn btn-outline" href="/customers/dashboard">Customer dashboard</a>
          </div>
        </div>
      </main>
  </@page>