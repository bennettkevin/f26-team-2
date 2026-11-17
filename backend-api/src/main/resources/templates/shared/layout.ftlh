  <#macro page title active="">
    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>${title} | Local Guide</title>
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
      <link rel="stylesheet" href="/static/styles.css">
    </head>

    <body>
      <header class="navbar m-3 p-2">
        <a href="/"> Local Guide</a>
        <nav class="navbar m-3 p-2">
          <#if customer??>
          <a href="/customer/${customer.id}" class="${(active == 'profile')?then('active', '')}">Profile</a>
          </#if>
          <#if guide??>
          <a href="/provider/dashboard" class="m-3 p-2">Dashboard</a>
          <a href="/provider/logout" class="m-3 p-2">Logout</a>
          <#else>
          <a href="/provider/login" class="m-3 p-2">Provider Login</a>
          </#if>
        </nav>
      </header>

      <main>
          <#if message??>
            <p>${message}</p>
          </#if>
          <#nested>
      </main>

      <footer>Local Guide</footer>

    </body>

    </html>
  </#macro>