function getProfiles(pSystem, container, pN) {
    fetch(`http://localhost:8080/profiles/${pSystem}?page=${pN}`)
        .then(result => result.json())
        .then(resporse => {
            container.empty();
            resporse.models.forEach(function (profile) {
                let systems = '';
                profile.profileSystems.forEach(function(profileSystem) {
                    systems += '<a href="/systems/' + profileSystem.altName + '">'+ profileSystem.name + '</a> ';
                })
                let uses = '';
                profile.uses.forEach(function(use) {
                    uses += '<a href="/uses/' + use.altName + '">'+ use.name + '</a> ';
                })
                let output =
                    '<div class="card m-2" style="width: 15rem;">' +
                        '<img src="images/' + profile.image + '" style="width: 13rem; height: 13rem; align-self: center;" class="card-img-top" alt="*">' +
                        '<div class="card-body text-center">\n' +
                        '<h5 class="card-title">' + profile.name + '</h5>' +
                        systems +
                        '</div>' +
                        '<ul class="list-group list-group-flush">' +
                            '<li class="list-group-item">Масса 1 п.м.: ' + profile.weight + ' кг.</li>' +
                            '<li class="list-group-item">Периметр: ' + profile.perimeter + ' мм.</li>' +
                            '<li class="list-group-item p-0">' +
                                '<table class="table table-bordered table-sm m-0">' +
                                    '<tbody>' +
                                        '<tr>' +
                                            '<td>Jx=' + profile.jx + '</td><td>Wx=' + profile.wx + '</td>' +
                                        '</tr>' +
                                        '<tr>' +
                                            '<td>Jy=' + profile.jy + '</td><td>Wy=' + profile.wy + '</td>' +
                                        '</tr>' +
                                    '</tbody>' +
                                '</table>' +
                            '</li>' +
                        '</ul>' +
                        '<div class="card-body">' +
                            uses +
                        '</div>' +
                    '</div>';
                container.append(output);
            })
        })
}