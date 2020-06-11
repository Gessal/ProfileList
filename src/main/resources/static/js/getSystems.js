function getSystems(container) {
    fetch(`http://localhost:8080/systems/all`)
        .then(result => result.json())
        .then(arraySystems => {
            container.empty();
            container.append('<option value="all" selected>Все</option>');
            arraySystems.forEach(function (profileSystem) {
                let output = '<option value="' + profileSystem.altName + '">' + profileSystem.name + '</option>';
                container.append(output);
            })
        })
}