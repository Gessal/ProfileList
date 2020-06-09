function getSystems(container) {
    fetch(`http://localhost:8080/systems/all`)
        .then(result => result.json())
        .then(arraySystems => {
            container.empty();
            container.append('<a class="dropdown-item" href="/profiles/all">Все</a>');
            arraySystems.forEach(function (profileSystem) {
                let output = '<a class="dropdown-item" href="/profiles/' + profileSystem.altName + '">' +
                                 profileSystem.name +
                             '</a>';
                container.append(output);
            })
        })
}