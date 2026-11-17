<#import "/shared/layout.ftlh" as l>
    <@l.page title="Add Tour" active="add-tour">
        <div class="container">
            <h1 class="m-3 p-2">Add Service</h1>
            <div class="card background-grey m-3 p-2">
                <form action="/provider/add-tour" method="post">
                    <p>Title: <input type="text" name="tourName" placeholder="EX: Nature Tour" maxlength="100"
                            required /></p>
                    <p>City: <input type="text" name="tourCity" placeholder="EX: Greensboro" maxlength="100" required />
                    </p>
                    <p>State: <input type="text" name="tourState" placeholder="EX: North Carolina" maxlength="100"
                            required /></p>
                    <p>Image link: <input type="url" name="tourImage"
                            placeholder="EX: https://example.com/flowers.jpeg" /></p>
                    <h2>Description:</h2>
                    <textarea name="tourDescription" class="form-control" maxlength="500" style="height: 100px;"
                        placeholder="Enter a description of this service." required></textarea>
                    <p>Price: $<input type="number" name="tourPrice" min="0" step="0.01" placeholder="50.00" required />
                    </p>
                    <button type="submit" class="btn btn-primary mt-2">Add Service</button>
                </form>
            </div>
        </div>
    </@l.page>