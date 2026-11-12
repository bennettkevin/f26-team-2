<#assign pageTitle="Customer Dashboard - Local Guide">
  <#include "/shared/layout.ftlh">
<body>


<nav class="navbar bg-body-tertiary">
  <div class="container-fluid">
    <form class="d-flex" role="search">
      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"/>
      <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
  </div>
</nav>



    <form method="get" action="/customers/customer-dash" class="search">
      <input type="text" name="tourCity" value="${tourCity!''}" placeholder="Search by city">
      <input type="text" name="tourState" value="${tourState!''}" placeholder="Search by state">

      <button type="submit">Search</button>
      <#if tourCity?has_content || tourState?has_content>
        <a href="/customers/customer-dash" class="clear">Clear</a>
      </#if>
    </form>

    <div class="grid">
      <#list guideTours as guideTour>
        <article class="card">
          <a href="/guideTours/${guideTour.id?c}">
            <img src="/thumbnails/${(guideTour.thumbnailUrl)!''}" alt="${guideTour.tourName}" width="200"
              height="200">
          </a>
          <div class="card-body">
            <h3><a href="/guideTours/${guideTour.id?c}">${guideTour.tourName}</a></h3>
            <p class="meta">City: ${guideTour.tourCity}</p>
            <p class="meta">State: ${guideTour.tourState}</p>
            <p class="meta">Description: ${guideTour.tourDescription}</p>
          </div>
        </article>
        <#else>
          <p class="empty">No guide tours found.</p>
      </#list>
    </div>

</body>