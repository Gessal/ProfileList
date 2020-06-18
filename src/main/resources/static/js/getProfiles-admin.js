function getProfilesAdmin(container) {
    fetch(`http://localhost:8080/profiles/getAll`)
        .then(result => result.json())
        .then(response => {
            container.empty();
            response.forEach(function (profile, index) {
                let row =
                    '<tr>' +
                    '<th scope="row">' + ++index + '</th>' +
                    '<td>' + profile.id + '</td>' +
                    '<td>' + profile.name + '</td>' +
                    '<td>' + profile.type.name + '</td>' +
                    '<td>' + profile.weight + '</td>' +
                    '<td>' + profile.perimeter + '</td>' +
                    '<td>' + profile.image + '</td>' +
                    '<td>' + profile.jx + '</td>' +
                    '<td>' + profile.jy + '</td>' +
                    '<td>' + profile.wx + '</td>' +
                    '<td>' + profile.wy + '</td>' +
                    '</tr>';
                container.append(row);
            })
        })
}