<#assign pageTitle="Tour - Local Guide">
  <#include "/shared/layout.ftlh">

<body>
<p><a href="/customers/customer-dash">Back to dashboard</a></p>

    <div>
      <div>
        <h1>${guideTour.tourName}</h1>
        <dl>
          <dt>Tour Description</dt>
          <dd>${guideTour.tourDescription}</dd>
          <dt>City</dt>
          <dd>${guideTour.tourCity}</dd>
          <dt>State</dt>
          <dd>${guideTour.tourState}</dd>
        </dl>
      </div>
    </div>

</body>
</html>