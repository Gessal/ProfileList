function getConnections(pSystem, container, pN) {
    fetch(`http://localhost:8080/connections/get/${pSystem}?page=${pN}`)
        .then(result => result.json())
        .then(resporse => {
            container.empty();
            resporse.forEach(function (connection) {
                let output =
                    '<div class="card m-2" style="width: 15rem;">' +
                        '<img src="/images/connections/' + connection.image + '" style="width: 13rem; height: 13rem; align-self: center;" class="card-img-top" alt="*">' +
                        '<div class="card-body text-center">\n' +
                            '<h5 class="card-title">' + connection.name + '</h5>' +
                        '</div>' +
                        '<ul class="list-group list-group-flush">' +
                            '<li class="list-group-item">' + connection.description + '</li>' +
                        '</ul>' +
                    '</div>';
                container.append(output);
            })
        })
}