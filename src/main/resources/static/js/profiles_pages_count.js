function profiles_pages_count(pSystem, pageSyze, container) {
    fetch(`http://localhost:8080/util/profiles-count/${pSystem}`)
        .then(result => result.text())
        .then(resporse => {
            container.empty();
            container.append(
                '<li id="prev_page" class="page-item">' +
                    '<button id="prev_btn" class="page-link" aria-label="Previous">' +
                        '<span aria-hidden="true">&laquo;</span>' +
                    '</button>' +
                '</li>' +
                '<li id="pi_1" class="page-item active"><button id="p_1" class="page-link page-btn">1</button></li>');
            for (let i =2; i <= Math.ceil(resporse / pageSyze); i++) {
                container.append('<li id="pi_' + i + '" class="page-item"><button id="p_' + i + '" class="page-link page-btn">' + i + '</button></li>');
            }
            container.append(
                '<li id="next_page" class="page-item">' +
                    '<button id="next_btn" class="page-link" aria-label="Next">' +
                        '<span aria-hidden="true">&raquo;</span>' +
                    '</button>' +
                '</li>');
        })
}