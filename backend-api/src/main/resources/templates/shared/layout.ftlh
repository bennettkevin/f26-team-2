  <#macro page title active="">
    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>${title} | Local Guide</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/styles.css">
    </head>

    <body>
      <header class="navbar m-3 p-2">
        <a href="/"> Local Guide</a>
        <nav class="navbar m-3 p-2">
          <a href="/" class="${(active == 'home')?then('active', '')}">Dashboard</a>
          <a href="/customer/${customer.id}" class="${(active == 'profile')?then('active', '')}">Profile</a>
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